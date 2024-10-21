package org.wisdom.ecommerce.product.application;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public ProductApplicationDto getProductBy(long productId) {
    return ProductApplicationDto.toResponse(productRepository.getProductBy(productId));
  }

  public List<ProductApplicationDto> getProductsBy(List<Long> productIds) {
    return productRepository.getProductsBy(productIds).stream().map(ProductApplicationDto::from)
        .toList();
  }
}
