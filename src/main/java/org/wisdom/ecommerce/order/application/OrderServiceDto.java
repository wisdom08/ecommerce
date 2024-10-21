package org.wisdom.ecommerce.order.application;

import lombok.Builder;

public class OrderServiceDto {

  @Builder
  public static Request of(long userId, long productId, int quantity) {
    return OrderServiceDto.builder()
        .userId(userId)
        .productId(productId)
        .quantity(quantity)
        .build();
  }

  @Builder
  public record Request(long userId, long productId) {

  }
}
