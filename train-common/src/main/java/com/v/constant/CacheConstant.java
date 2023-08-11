package com.v.constant;

/**
 * 缓存相关常量
 *
 * @author xiongxiaoyang
 * @date 2022/5/12
 */
public class CacheConstant {

    /**
     * 本项目 Redis 缓存前缀
     */
    public static final String REDIS_CACHE_PREFIX = "Cache::train::";


    /**
     * Redis 缓存管理器
     */
    public static final String REDIS_CACHE_MANAGER = "redisCacheManager";


    /**
     * 验证码缓存 KEY
     */
    public static final String VERIFY_CODE_CACHE_KEY =
            REDIS_CACHE_PREFIX + "VerifyCodeCache::";


}
