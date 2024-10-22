package org.wisdom.ecommerce.product.presentation;

import lombok.Builder;
import org.wisdom.ecommerce.product.application.ProductInfo;

@Builder
public record ProductApiResponse(Long id, String name, Integer price, Integer quantity) {

  public static ProductApiResponse from(ProductInfo product) {
    return ProductApiResponse.builder()
        .id(product.id())
        .name(product.name())
        .price(product.price())
        .quantity(product.quantity())
        .build();
  }
}
