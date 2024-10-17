package org.wisdom.ecommerce.cart.presentation;

import lombok.Builder;
import org.wisdom.ecommerce.cart.application.CartServiceDto;

import java.util.List;

public record CartApiDto(long userId, long productId, int quantity) {

    @Builder
    public record Response(long userId, long productId, long cartId, String productName, long quantity) {

        public static List<Response> of(List<CartServiceDto> carts) {
            return carts.stream().map(v -> Response.builder()
                    .productId(v.productId())
                    .productName(v.productName())
                    .quantity(v.quantity())
                    .build()).toList();
        }
    }

    @Builder
    public record request(long userId, long cartId) {
        public CartApiDto.Response toResponse() {
            return Response.builder()
                    .userId(userId)
                    .cartId(cartId)
                    .build();
        }
    }

//    @Schema(description = "장바구니 응답")
//    @Builder
//    public record Request (long userId, long cartId){
//        public CartServiceDto.Request toCartServiceDto() {
//            return CartServiceDto.Request.builder()
//                    .userId(userId)
//                    .cartId(cartId)
//                    .build();
//        }
//    }
}
