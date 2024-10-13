package org.wisdom.ecommerce.product.presentation;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.math.BigDecimal;

public class ProductApiDto {

    @Schema(description = "상품 응답")
    @Builder
    public record Response(long productId, String name, BigDecimal price, int stock) {
    }
}
