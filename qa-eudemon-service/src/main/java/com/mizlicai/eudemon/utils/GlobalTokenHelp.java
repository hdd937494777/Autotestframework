package com.mizlicai.eudemon.utils;

import com.mizlicai.eudemon.context.TokenConstant;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;

/**
 * Created by huangyt on 2017/6/16.
 */
@Component
public final class GlobalTokenHelp {
    /**
     * 默认有效score: 10分钟
     */
    public static final Long DEFAULT_SCORE = 600L;
    private static final Logger logger = LoggerFactory
            .getLogger(GlobalTokenHelp.class);
    @Resource
    private RedisTemplate<String, String> stringRedisTemplate;

    /**
     * 放入全局token池<br>
     */
    public boolean createGlobalToken(final String token) {
        // opsForZSet
        return stringRedisTemplate.opsForZSet().add(
                TokenConstant.TOKEN_GLOBAL_NAMESPACE, token,
                getCurrentSeconds());

        // // opsForSet
        // return stringRedisTemplate.opsForSet().add(
        // TokenConstant.TOKEN_GLOBAL_NAMESPACE, token);
    }

    /**
     * @return 得到当前秒数
     */
    public Long getCurrentSeconds() {
        return nowTime(false) / 1000;
    }

    /**
     * 校验全局token是否存在
     */
    public boolean isMember(final String token) {
        // 校验全局token是否存在
        if (StringUtils.isEmpty(token)) {
            return false;
        }
        boolean flag = false;

        // opsForZSet, 成员的权重, 基于0，这意味着，具有最低得分的构件具有等级0
        final Long rank = stringRedisTemplate.opsForZSet().rank(
                TokenConstant.TOKEN_GLOBAL_NAMESPACE, token);
        if (rank != null && rank >= 0L) {
            flag = true;
        }

        // // opsForSet
        // flag = stringRedisTemplate.opsForSet().isMember(
        // TokenConstant.TOKEN_GLOBAL_NAMESPACE, token);
        return flag;
    }
    public static long nowTime(final boolean isNano) {
        return isNano ? System.nanoTime() : System.currentTimeMillis();
    }

    /**
     * 校验全局remove
     */
    public Set<String> members(final String key, final Long startTime,
                               final Long EndTime) {
        // opsForZSet
        final Set<String> values = stringRedisTemplate.opsForZSet()
                .rangeByScore(TokenConstant.TOKEN_GLOBAL_NAMESPACE, startTime,
                        EndTime);

        // opsForSet
        // final Set<String> values = stringRedisTemplate.opsForSet().members(
        // TokenConstant.TOKEN_GLOBAL_NAMESPACE);
        return values;
    }

    /**
     * 校验全局remove
     */
    public boolean remove(final String v) {
        // opsForZSet
        final Long count = stringRedisTemplate.opsForZSet().remove(
                TokenConstant.TOKEN_GLOBAL_NAMESPACE, v);
        logger.info(v
                + " score is "
                + stringRedisTemplate.opsForZSet().score(
                TokenConstant.TOKEN_GLOBAL_NAMESPACE, v));

        // opsForSet
        // final Long count = stringRedisTemplate.opsForSet().remove(
        // TokenConstant.TOKEN_GLOBAL_NAMESPACE, v);

        return count == 1L;
    }
}
