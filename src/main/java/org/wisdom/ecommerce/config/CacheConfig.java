package org.wisdom.ecommerce.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import java.util.concurrent.TimeUnit;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {
  @Bean
  public CaffeineCacheManager cacheManager() {
    CaffeineCacheManager cacheManager = new CaffeineCacheManager("best");
    cacheManager.setCaffeine(caffeineCacheBuilder());
    cacheManager.setAsyncCacheMode(true);
    return cacheManager;
  }

  @Bean
  public Caffeine<Object, Object> caffeineCacheBuilder() {
    return Caffeine.newBuilder()
        .expireAfterWrite(5, TimeUnit.MINUTES)
        .maximumSize(100);
  }
}
