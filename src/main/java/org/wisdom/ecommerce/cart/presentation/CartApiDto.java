package org.wisdom.ecommerce.cart.presentation;

import java.util.List;
import lombok.Builder;
import org.wisdom.ecommerce.cart.application.CartApplicationDto;

public record CartApiDto() {

    @Builder
    public record DeleteRequest(long userId, long cartId) {

    }

    @Builder
    public record AddRequest(long userId, long productId, int quantity) {

    }

    @Builder
    public record Response(long userId, long productId, long cartId, String productName, long quantity) {

        public static List<Response> of(List<CartApplicationDto> carts) {
            return carts.stream().map(v -> Response.builder()
                .productId(v.productId())
                .productName(v.productName())
                .quantity(v.quantity())
                .build()).toList();
        }
    }
}
