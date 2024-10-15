package org.wisdom.ecommerce.product.presentation;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import org.wisdom.ecommerce.product.application.ProductInfo;

public class ProductApiDto {

    @Schema(description = "상품 응답")
    @Builder
    public record Response(long productId, String name, int price, int quantity) {

        public static Response from(ProductInfo.Response product) {
            return Response.builder()
                .productId(product.productId())
                .name(product.name())
                .price(product.quantity())
                .quantity(product.quantity())
                .build();
        }
    }
}
