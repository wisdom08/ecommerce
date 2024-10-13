package org.wisdom.ecommerce.point.application;

import org.springframework.stereotype.Service;
import org.wisdom.ecommerce.point.presentation.PointApiDto;

import java.math.BigDecimal;

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
