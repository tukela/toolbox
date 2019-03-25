package com.hl.kit.data.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
/***
 * 五个缓存管理器实现，如下所示：
 * SimpleCacheManager
 * NoOpCacheManager
 * ConcurrentMapCacheManager
 * CompositeCacheManager
 * EhCacheCacheManager
 * RedisCacheManager（来自于Spring Data Redis项目）
 * GemfireCacheManager（来自于Spring Data GemFire项目）
 */
@Configuration
@EnableCaching
public class CacheConfig {

}
