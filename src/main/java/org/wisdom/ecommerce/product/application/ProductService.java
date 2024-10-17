package org.wisdom.ecommerce.product.application;

import org.springframework.stereotype.Service;
import org.wisdom.ecommerce.product.domain.Product;
import org.wisdom.ecommerce.product.presentation.ProductApiDto;

import java.util.List;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Product getProductBy(long productId) {
    return productRepository.getProductBy(productId);
  }

  public List<ProductApiDto> getBestOfProducts() {
    return List.of(
        ProductApiDto.builder()
            .productId(1)
            .name("MOCK_PRODUCT_1")
            .price(100000)
            .quantity(100)
            .build(),

        ProductApiDto.builder()
            .productId(1)
            .name("MOCK_PRODUCT_2")
            .price(200000)
            .quantity(200)
            .build()
    );
  }

  public List<ProductServiceDto> getProductsBy(List<Long> productIds) {
    return productRepository.getProductsBy(productIds).stream().map(ProductServiceDto::from).toList();
  }
}
