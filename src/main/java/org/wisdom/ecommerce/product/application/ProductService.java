package org.wisdom.ecommerce.product.application;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wisdom.ecommerce.product.domain.Product;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Transactional(readOnly = true)
  public Product getProductBy(Long productId) {
    return productRepository.getProductBy(productId);
  }

  @Transactional(readOnly = true)
  public List<Product> getProductsBy(List<Long> productIds) {
    return productRepository.getProductsBy(productIds);
  }

  @Transactional
  public void updateStock(Product product, Integer quantity) {
    product.validateQuantity(quantity);
    productRepository.updateStock(product, product.quantity() - quantity);
  }
}
