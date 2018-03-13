package com.mizlicai.eudemon.mng.utils;
import com.mizlicai.eudemon.mng.exception.BusinessException;
import com.mizlicai.eudemon.mng.exception.BusinessExceptionCode;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * 防撞库工具类
 * Created by chars on 2016/1/18.
 * Copyright © mizhuanglicai
 */
public class SafetyUtils {


    public static String SAFETY = "SAFETY_";//保存到redis key值

    public static final int LIVE_CYCLE = 1;// 存活周期时

    public static final int LIVE_TIMES = 5;// 次数

    private static final String message = "请求过于频繁,请稍后再试";

    public enum Type {
        LOGIN, PASSWORD, REGISTER, ISREGISTER, NOREGISTER;
    }

    /**
     * 防撞库操作次数累计
     *
     * @param redisTemplate redisTemplate
     * @param mobile        mobile
     * @param userAgent     userAgent
     * @param ip            ip
     * @param type          type
     * @throws
     */
    public static void safetyTimes(RedisTemplate<String, String> redisTemplate, final String mobile, final String userAgent, String ip, Type type) {
        if (Type.REGISTER.equals(type)) {
            safetyByMobile(redisTemplate, Type.REGISTER, mobile);
        } else {
            safetyByIpAndUserAgent(redisTemplate, type, userAgent, ip);
        }
    }

    /**
     * 防撞库操作安全校验
     *
     * @param redisTemplate redisTemplate
     * @param mobile        mobile
     * @param userAgent     userAgent
     * @param ip            ip
     * @param type          type
     * @param checkSafety
     * @throws
     */
    public static void checkSafety(RedisTemplate<String, String> redisTemplate, final String mobile, final String userAgent, String ip, Type type, Boolean checkSafety) throws BusinessException {
        if (checkSafety) {
            if (Type.REGISTER.equals(type)) {
                checkSafetyByMobile(redisTemplate, Type.REGISTER, mobile);
            } else {
                checkSafetyByIpAndUserAgent(redisTemplate, type, userAgent, ip);
            }
        }
    }

    private static void safetyByIpAndUserAgent(RedisTemplate<String, String> redisTemplate, Type type, String userAgent, String ip) {
        String key = SAFETY + type + Md5Util.encrypt(userAgent + ip);
        int times = 1;
        String value = redisTemplate.opsForValue().get(key);
        if (value != null) {
            times = Integer.valueOf(value) + 1;
        }
        redisTemplate.opsForValue().set(key, String.valueOf(times), LIVE_CYCLE, TimeUnit.HOURS);
    }


    private static void checkSafetyByIpAndUserAgent(RedisTemplate<String, String> redisTemplate, Type type, String userAgent, String ip) throws BusinessException {
        String key = SAFETY + type + Md5Util.encrypt(userAgent + ip);
        String value = redisTemplate.opsForValue().get(key);
        if (value != null) {
            int times = Integer.valueOf(value);
            if (times >= LIVE_TIMES) {
                throw new BusinessException(BusinessExceptionCode.EXCEPTION_1, message);
            }
        }
    }

    private static void safetyByMobile(RedisTemplate<String, String> redisTemplate, Type type, String mobile) {
        String key = SAFETY + type + mobile;
        int times = 1;
        String value = redisTemplate.opsForValue().get(key);
        if (value != null) {
            times = Integer.valueOf(value) + 1;
        }
        redisTemplate.opsForValue().set(key, String.valueOf(times), LIVE_CYCLE, TimeUnit.HOURS);
    }

    private static void checkSafetyByMobile(RedisTemplate<String, String> redisTemplate, Type type, String mobile) throws BusinessException {
        String key = SAFETY + type + mobile;
        String value = redisTemplate.opsForValue().get(key);
        if (value != null) {
            int times = Integer.valueOf(value);
            if (times >= LIVE_TIMES) {
                throw new BusinessException(BusinessExceptionCode.EXCEPTION_1, message);
            }
        }
    }
}
