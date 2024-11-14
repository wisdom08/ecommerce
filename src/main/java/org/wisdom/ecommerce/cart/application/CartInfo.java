package org.wisdom.ecommerce.cart.application;

import lombok.Builder;
import org.wisdom.ecommerce.cart.domain.CartItem;
import org.wisdom.ecommerce.product.domain.Product;

@Builder
public record CartInfo(Long id, Long productId, Long userId, Integer quantity, String productName,
                       Integer price) {

  public static CartInfo from(CartItem cartItem) {
    return CartInfo.builder()
        .id(cartItem.id())
        .productId(cartItem.productId())
        .quantity(cartItem.quantity())
        .build();
  }

  public static CartInfo from(Product product, CartInfo cartItem) {
    return CartInfo.builder()
        .productId(cartItem.productId)
        .price(product.price())
        .productName(product.name())
        .quantity(cartItem.quantity)
        .build();
  }

}
