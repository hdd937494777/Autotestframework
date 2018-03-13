package com.mizlicai.eudemon.utils;

import com.mizlicai.eudemon.context.TokenConstant;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by huangyt on 2017/6/16.
 */
@Component
public final class TokenHelp {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 数据执行器
     *
     * @param <T>
     */
    public interface IPreExecution<T> {
        /**
         * 如果验证合法, 则执行该动作
         */
        T legal() throws Exception;

        /**
         * 如果验证不合法, 则执行该动作
         */
        T unlegal();
    }


    @Autowired
    private GlobalTokenHelp globalTokenHelp;

    @Resource
    private RedisTemplate<String, String> stringRedisTemplate;

    /**
     * 使用给定的字串作为token名字保存token<br>
     * 放入全局token池<br>
     * 放入单一token池
     */
    public String createToken(final String tokenName) {
        final String token = token();

		/* 放入全局token池 */
        globalTokenHelp.createGlobalToken(token);

		/* 放入单一token池 */
        final String tokenKey = createTokenName(tokenName);
        stringRedisTemplate.opsForList().rightPush(tokenKey, token);
        stringRedisTemplate.expire(tokenKey, TokenConstant.CYCLE,
                TimeUnit.SECONDS);

       // logger.info("tokenName:{} tokenKey:{} token:{}", tokenName, tokenKey, token);
        return token;
    }

    /**
     * 构建一个基于token名字的带有命名空间为前缀的token名字
     */
    private String createTokenName(final String tokenName) {
        return TokenConstant.TOKEN_NAMESPACE + "." + tokenName;
    }

    private String token() {
        final String token = generateUUID();
        // TODO
        final int traceId = Math.abs(generateUUID().hashCode());

        return token + "" + traceId;
    }
    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 校验全局token,校验n次或m秒后失效<
     *
     * @param token
     *            token
     * @param execute
     *            执行逻辑
     * @param <T>
     *            返回类型
     * @return T
     */
    public <T> T validTokenGlobal(final String token,
                                  final IPreExecution<T> execute) throws Exception {
        if (StringUtils.isEmpty(token)) {
            // 执行不合法方法
            return execute.unlegal();
        }

        // 校验全局token是否存在
        final boolean flag = globalTokenHelp.isMember(token);
        if (!flag) {
            // 执行不合法方法
            return execute.unlegal();
        }

        //
        final T t = execute.legal();

        // // TODO 一次验证成功后token即失效
        // globalTokenService.remove(token);
        return t;
    }

    /**
     * 校验签名内token,只能使用一次,验证成功后即失效
     *
     * @param tokenName
     *            token名称
     * @param token
     *            token
     * @return true为验证成功, false为验证失败
     */
    public <T> boolean validTokenSign(final String tokenName,
                                      final String token, final IPreExecution<T> execute) throws Exception {
        execute.legal();

        final String tokenCacheName = createTokenName(tokenName);
        final String cacheToken = stringRedisTemplate.opsForList().rightPop(
                tokenCacheName);
       // logger.info("tokenCacheName:{} cacheToken:{} token:{}", tokenCacheName,cacheToken, token);

        try {
            if (token.equals(cacheToken)) {
                return true;
            }
        } catch (final Exception e) {
            logger.error("消费token异常:", e);
        }

        execute.unlegal();
        return false;
    }

}
