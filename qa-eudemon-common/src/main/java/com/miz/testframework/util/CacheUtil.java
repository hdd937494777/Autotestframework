package com.miz.testframework.util;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

/**
 * dongdong Created by 上午10:38  2018/4/3
 */
public class CacheUtil {

    /**
     * 从Spring缓存中获取缓存数据
     *
     * @param cacheName 缓存name
     * @param key       缓存key
     * @return 返回缓存中的对象数据
     */
    public static <T extends Object> T getCacheComent(String cacheName, Object key) {
        CacheManager cacheCacheManager = SpringContextUtil.getBean("cacheManager");
        Cache cache = cacheCacheManager.getCache(cacheName);
        T t = (T) cache.get(key).get();
        return t;
    }

    /**
     * 从Spring缓存中删除缓存数据
     *
     * @param cacheName 缓存name
     * @param key       缓存key
     */
    public static void delCacheComent(String cacheName, Object key) {
        CacheManager cacheCacheManager = SpringContextUtil.getBean("cacheManager");
        Cache cache = cacheCacheManager.getCache(cacheName);
        cache.evict(key);
    }

    /**
     * 从Spring缓存中清空缓存数据
     *
     * @param cacheName 缓存name
     */
    public static void clearCacheComent(String cacheName) {
        CacheManager cacheCacheManager = SpringContextUtil.getBean("cacheManager");
        Cache cache = cacheCacheManager.getCache(cacheName);
        cache.clear();
    }


    /**
     * 设置Spring缓存数据
     *
     * @param cacheName 缓存name
     * @param key       缓存key
     */
    public static <T extends Object, R extends Object>  void putCacheComent(String cacheName, R key, T value) {
        CacheManager cacheCacheManager = SpringContextUtil.getBean("cacheManager");
        Cache cache = cacheCacheManager.getCache(cacheName);
        cache.put(key, value);
    }
}
