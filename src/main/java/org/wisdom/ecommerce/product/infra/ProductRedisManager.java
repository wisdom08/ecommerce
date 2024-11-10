package org.wisdom.ecommerce.product.infra;

import java.util.concurrent.TimeUnit;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.wisdom.ecommerce.product.domain.Product;

@Component
public class ProductRedisManager {

  private final RedisTemplate<String, Product> redisTemplate;
  private static final String PRODUCT_CACHE_KEY = "product:";
  private static final long CACHE_TTL = 5;

  public ProductRedisManager(RedisTemplate<String, Product> redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  public Product get(Long productId) {
    return redisTemplate.opsForValue().get(PRODUCT_CACHE_KEY + productId);
  }

  public void save(Product product) {
    redisTemplate.opsForValue().set(PRODUCT_CACHE_KEY + product.id(), product, CACHE_TTL, TimeUnit.MINUTES);
  }

  public void update(Product product) {
    save(product);
  }
}
