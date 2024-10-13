package org.wisdom.ecommerce.point.presentation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.wisdom.ecommerce.point.application.PointService;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PointControllerTest {

    @InjectMocks
    private PointController controller;

    @Mock
    private PointService service;

    @Test
    void 포인트_조회_호출_확인() {
        // given
        long userId = 1L;
        // when
        controller.getPointsBy(userId);
        // then
        verify(service).getPointsBy(userId);
    }

    @Test
    void 포인트_충전_호출_확인() {
        // given
        PointApiDto.Request request = PointApiDto.Request.builder().build();
        // when
        controller.charge(request);
        // then
        verify(service).chargePoints(request.toPointServiceDto());
    }

}