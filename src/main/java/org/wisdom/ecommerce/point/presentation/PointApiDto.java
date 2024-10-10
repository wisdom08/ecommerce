package org.wisdom.ecommerce.point.presentation;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import org.wisdom.ecommerce.point.application.PointServiceDto;

import java.math.BigDecimal;

public class PointApiDto {

    @Builder
    public record Request(long userId, BigDecimal pointToCharge){
        public PointServiceDto.Request toPointServiceDto() {
            return PointServiceDto.Request.builder()
                    .userId(userId)
                    .point(pointToCharge)
                    .build();
        }

    }

    @Schema(description = "포인트 응답")
    @Builder
    public record Response(long userId, BigDecimal totalPoint) {
    }
}
