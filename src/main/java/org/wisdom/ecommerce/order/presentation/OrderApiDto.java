package org.wisdom.ecommerce.order.presentation;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import lombok.Builder;
import org.wisdom.ecommerce.order.application.OrderServiceDto;

public class OrderApiDto {

    @Builder
    public record Request(long userId, long productId) {

        public OrderServiceDto.Request toOrderServiceDto() {
            return OrderServiceDto.Request.builder()
                .userId(userId)
                .productId(productId)
                .build();
        }
    }

    @Schema(description = "주문 응답")
    @Builder
    public record Response(long userId, long productId, long orderId, BigDecimal totalAmount) {

    }
}
