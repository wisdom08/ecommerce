package org.wisdom.ecommerce.cart.application;

import lombok.Builder;
import org.wisdom.ecommerce.cart.domain.CartItem;
import org.wisdom.ecommerce.product.application.ProductApplicationDto;

@Builder
public record CartApplicationDto(long id, long productId, long userId, long quantity, String productName, int price) {

    public static CartApplicationDto from(CartItem cartItem) {
        return CartApplicationDto.builder()
            .id(cartItem.id())
            .productId(cartItem.productId())
            .quantity(cartItem.quantity())
            .build();
    }

    public static CartApplicationDto from(ProductApplicationDto dto, CartApplicationDto cartItem) {
        return CartApplicationDto.builder()
            .id(dto.id())
            .productId(cartItem.productId)
            .price(dto.price())
            .productName(dto.name())
            .quantity(cartItem.quantity)
            .build();
    }

}
