package org.wisdom.ecommerce.product.application;

import java.util.List;
import org.springframework.stereotype.Service;
import org.wisdom.ecommerce.product.domain.Product;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Product getProductBy(Long productId) {
    return productRepository.getProductBy(productId);
  }

  public List<Product> getProductsBy(List<Long> productIds) {
    return productRepository.getProductsBy(productIds);
  }

  public void updateStock(Product product, Integer quantity) {
    product.validateQuantity(quantity);
    productRepository.updateStock(product, quantity);
  }
}
