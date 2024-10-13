package org.wisdom.ecommerce.cart.presentation;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import org.wisdom.ecommerce.cart.application.CartServiceDto;

public class CartApiDto {

    @Builder
    public record Response(long userId, long productId, long cartId, String productName, long quantity) {

    }

    @Schema(description = "장바구니 응답")
    @Builder
    public record Request (long userId, long cartId){
        public CartServiceDto.Request toCartServiceDto() {
            return CartServiceDto.Request.builder()
                    .userId(userId)
                    .cartId(cartId)
                    .build();
        }
    }
}
