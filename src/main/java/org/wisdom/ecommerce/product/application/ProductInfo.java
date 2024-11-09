package org.wisdom.ecommerce.product.application;

import lombok.Builder;
import org.wisdom.ecommerce.product.domain.Product;

@Builder
public record ProductInfo(Long id, int price, String name) {

  public static ProductInfo from(Product product) {
    return ProductInfo.builder()
        .id(product.id())
        .name(product.name())
        .price(product.price())
        .build();
  }
}
