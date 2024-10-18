package org.wisdom.ecommerce.order.domain;


import lombok.Builder;

public record Order(long userId, long productId, int quantity) {

    @Builder
    public static Order of(long userId, long productId, int quantity) {
        return Order.builder()
            .userId(userId)
            .productId(productId)
            .quantity(quantity)
            .build();
    }

}
