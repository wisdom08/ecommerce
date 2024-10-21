package org.wisdom.ecommerce.product.application;

import lombok.Builder;
import org.wisdom.ecommerce.product.domain.Product;

@Builder
public record ProductApplicationDto(long id, int price, int quantity, String name) {

  public static ProductApplicationDto from(Product product) {
    return ProductApplicationDto.builder()
        .id(product.productId())
        .name(product.name())
        .price(product.price())
        .build();

  }

  public static ProductApplicationDto toResponse(Product product) {
    return ProductApplicationDto.builder()
        .id(product.productId())
        .price(product.price())
        .quantity(product.quantity())
        .name(product.name())
        .build();
  }

  @Builder
  public record Response(long productId, int price, int quantity) {

    public ProductApplicationDto.Response toResponse(Product product) {
      return Response.builder()
          .productId(product.productId())
          .price(product.price())
          .quantity(product.quantity())
          .build();
    }

  }
}
