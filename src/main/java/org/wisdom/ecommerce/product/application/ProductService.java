package org.wisdom.ecommerce.product.application;

import java.util.List;
import org.springframework.stereotype.Service;
import org.wisdom.ecommerce.product.infra.Product;
import org.wisdom.ecommerce.product.presentation.ProductApiDto;
import org.wisdom.ecommerce.product.presentation.ProductApiDto.Response;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public ProductInfo.Response getProductBy(long productId) {
    Product product = productRepository.findBy(productId);
    return ProductInfo.Response.from(product);
  }

  public List<Response> getBestOfProducts() {
    return List.of(
        ProductApiDto.Response.builder()
            .productId(1)
            .name("MOCK_PRODUCT_1")
            .price(100000)
            .quantity(100)
            .build(),

        ProductApiDto.Response.builder()
            .productId(1)
            .name("MOCK_PRODUCT_2")
            .price(200000)
            .quantity(200)
            .build()
    );
  }
}
