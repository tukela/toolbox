package com.hl.kit.data.config;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author: honglei
 * @Date: 2019/3/25 16:05
 * @Version: 1.0
 * @See:
 * @Description:
 */
@Configuration
public class RedisCacheConfig {
    //springboot1.x的版本可以使用
//    @Bean
//    public CacheManager cacheManager(RedisTemplate redisTemplate){
//        return new RedisCacheManager(redisTemplate);
//    }
    @SuppressWarnings("rawtypes")
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheConfiguration redisCacheConfiguration=RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(null);
        return RedisCacheManager.builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
                .cacheDefaults(redisCacheConfiguration).build();
    }


    @Bean
    public RedisConnectionFactory redisCF() {
        JedisConnectionFactory c =new JedisConnectionFactory();
        c.setHostName("0.0.0.0");
        c.setPort(6379);
        return c;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory cf) {
        RedisTemplate<String, Object> redis = new RedisTemplate<String, Object>();
        redis.setConnectionFactory(cf);
        return redis;
    }
}