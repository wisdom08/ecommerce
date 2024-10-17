package org.wisdom.ecommerce.cart.application;

import lombok.Builder;
import org.wisdom.ecommerce.cart.domain.CartItem;
import org.wisdom.ecommerce.product.application.ProductServiceDto;

@Builder
public record CartServiceDto(long id, long productId, long userId, long quantity, String productName, int price) {

    public static CartServiceDto from(CartItem cartItem) {
        return CartServiceDto.builder()
                .id(cartItem.id())
                .productId(cartItem.productId())
                .quantity(cartItem.quantity())
                .build();
    }

    public static CartServiceDto from(ProductServiceDto dto, CartServiceDto cartItem) {
        return CartServiceDto.builder()
                .id(dto.id())
                .productId(cartItem.productId)
                .price(dto.price())
                .productName(dto.name())
                .quantity(cartItem.quantity)
                .build();
    }

}
