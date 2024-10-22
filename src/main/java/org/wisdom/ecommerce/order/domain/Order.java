package org.wisdom.ecommerce.order.domain;


import lombok.Builder;

public record Order(Long userId, Long productId, int quantity) {

  @Builder
  public static Order of(Long userId, Long productId, int quantity) {
    return Order.builder()
        .userId(userId)
        .productId(productId)
        .quantity(quantity)
        .build();
  }

}
