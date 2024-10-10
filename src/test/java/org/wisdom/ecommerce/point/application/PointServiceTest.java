package org.wisdom.ecommerce.point.application;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.wisdom.ecommerce.point.presentation.PointApiDto;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class PointServiceTest {


    @InjectMocks
    private PointService service;

    @Test
    void 포인트_조회_응답_확인() {
        // given
        // when
        PointApiDto.Response result = service.getPointsBy(0L);

        // then
        assertThat(result.userId()).isEqualTo(0L);
        assertThat(result.totalPoint()).isEqualTo(BigDecimal.valueOf(100000));
    }

    @Test
    void 포인트_충전_응답_확인() {
        // given
        PointServiceDto.Request serviceDto = PointApiDto.Request.builder()
                .userId(0L)
                .pointToCharge(BigDecimal.valueOf(100000))
                .build()
                .toPointServiceDto();

        // when
        PointApiDto.Response result = service.chargePoints(serviceDto);

        // then
        assertThat(result.userId()).isEqualTo(0L);
        assertThat(result.totalPoint()).isEqualTo(BigDecimal.valueOf(100000));
    }
}