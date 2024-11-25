package org.wisdom.ecommerce.cart.presentation;

import lombok.Builder;
import org.wisdom.ecommerce.cart.application.CartInfo;

@Builder
public record CartApiResponse(Long productId, String productName, Integer quantity) {

  public static CartApiResponse of(CartInfo carts) {
    return CartApiResponse.builder()
        .productId(carts.productId())
        .productName(carts.productName())
        .quantity(carts.quantity())
        .build();
  }
}
