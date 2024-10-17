package org.wisdom.ecommerce.cart.application;

import lombok.Builder;

public class CartServiceDto {

    @Builder
    public record Request(long userId, long cartId) {

    }
}
