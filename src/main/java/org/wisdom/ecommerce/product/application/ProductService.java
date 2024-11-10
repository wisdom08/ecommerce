package org.wisdom.ecommerce.product.application;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wisdom.ecommerce.product.domain.Product;
import org.wisdom.ecommerce.product.infra.ProductRedisManager;

@Service
public class ProductService {

  private final ProductRepository productRepository;
  private final ProductRedisManager productRedisManager;

  public ProductService(ProductRepository productRepository, ProductRedisManager productRedisManager) {
    this.productRepository = productRepository;
    this.productRedisManager = productRedisManager;
  }

  @Transactional
  public Product getProductBy(Long productId) {
    return Optional.ofNullable(productRedisManager.get(productId))
        .or(() -> Optional.ofNullable(productRepository.getProductBy(productId))
            .map(product -> {
              productRedisManager.save(product);
              return product;
            })
        ).orElse(null);
  }

  @Transactional(readOnly = true)
  public List<Product> getProductsBy(List<Long> productIds) {
    return productRepository.getProductsBy(productIds);
  }

  @Transactional
  public void updateStock(Product product, Integer quantity) {
    product.validateQuantity(quantity);
    productRepository.updateStock(product, product.quantity() - quantity);
    productRedisManager.update(Product.builder()
        .id(product.id())
        .name(product.name())
        .price(product.price())
        .quantity(product.quantity() - quantity)
        .build());
  }
}
