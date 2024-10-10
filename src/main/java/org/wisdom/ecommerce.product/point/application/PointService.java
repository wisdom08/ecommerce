package org.wisdom.ecommerce.product.point.application;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.stereotype.Service;
import org.wisdom.ecommerce.product.point.presentation.PointApiDto;

import java.math.BigDecimal;

@Schema(description = "상품 응답")
@Service
public class PointService {

    public PointApiDto.Response chargePoints(PointServiceDto.Request pointServiceDto) {
        return PointApiDto.Response.builder()
                .userId(pointServiceDto.userId())
                .totalPoint(pointServiceDto.point())
                .build();
    }

    public PointApiDto.Response getPointsBy(long userId) {
        return PointApiDto.Response.builder()
                .userId(userId)
                .totalPoint(BigDecimal.valueOf(100000)).build();
    }
}
