package org.wisdom.ecommerce.product.infra;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.wisdom.ecommerce.product.application.ProductRepository;
import org.wisdom.ecommerce.product.domain.Product;

@Slf4j
@Repository
public class ProductRepositoryImpl implements ProductRepository {

  private final ProductJpaRepository productJpaRepository;

  public ProductRepositoryImpl(ProductJpaRepository productJpaRepository) {
    this.productJpaRepository = productJpaRepository;
  }

  @Override
  public Product getProductBy(Long productId) {
    return productJpaRepository.findById(productId)
        .orElseThrow(() -> new EntityNotFoundException(productId + "의 상품이 없습니다"))
        .toDomain();
  }

  @Override
  public List<Product> getProductsBy(List<Long> productIds) {
    return productJpaRepository.findAllById(productIds).stream().map(ProductEntity::toDomain)
        .toList();
  }

  @Override
  public void updateStock(Product product, Integer quantity) {
    productJpaRepository.updateStock(product.id(), quantity);
    log.info("minus stock");
  }
}
