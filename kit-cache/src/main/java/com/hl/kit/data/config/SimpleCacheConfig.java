package com.hl.kit.data.config;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheFactoryBean;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;

import java.util.Collections;
import java.util.List;

/**
 * @author: honglei
 * @Date: 2019/3/25 16:09
 * @Version: 1.0
 * @See:
 * @Description:
 */
public class SimpleCacheConfig {
    @Bean("cacheManager")
    // List<Cache>会主动搜索Cache的实现bean，并添加到caches中
    public CacheManager cacheManager(List<Cache> caches){
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        simpleCacheManager.setCaches(caches);
        return simpleCacheManager;
    }
    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Collections.singletonList(new ConcurrentMapCache("models")));
        return cacheManager;
    }

    @Bean("stockDetail")
    public ConcurrentMapCacheFactoryBean stockDetail(){
        ConcurrentMapCacheFactoryBean stockDetail = new ConcurrentMapCacheFactoryBean();
        // 如果用户设置名称为stockDetail的缓存，则需要添加这样的一个bean
        stockDetail.setName("stockDetail");
        return stockDetail;
    }

    @Bean("detailMsg")
    public ConcurrentMapCacheFactoryBean detailMsg(){
        ConcurrentMapCacheFactoryBean stockDetail = new ConcurrentMapCacheFactoryBean();
        // 如果用户设置名称为detailMsg的缓存，则需要添加这样的一个bean
        stockDetail.setName("detailMsg");
        return stockDetail;
    }
   // 注意：如果读者在使用@Cache的时候，需要多个不同命名的cache时，需添加多个ConcurrentMapCacheFactoryBean
}
