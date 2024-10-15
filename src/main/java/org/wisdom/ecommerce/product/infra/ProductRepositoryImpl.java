package org.wisdom.ecommerce.product.infra;

import org.wisdom.ecommerce.product.application.ProductRepository;

public class ProductRepositoryImpl implements ProductRepository {

  private ProductJpaRepository productJpaRepository;

  @Override
  public Product findBy(long productId) {
    return productJpaRepository.findById(productId);
  }
}
