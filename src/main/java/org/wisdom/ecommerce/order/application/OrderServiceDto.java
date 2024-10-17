package org.wisdom.ecommerce.order.application;

import lombok.Builder;

public class OrderServiceDto {

    @Builder
    public record Request(long userId, long productId) {

    }
}
