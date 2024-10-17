package org.wisdom.ecommerce.user.order.presentation;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.wisdom.ecommerce.order.application.OrderService;
import org.wisdom.ecommerce.order.presentation.OrderApiDto;
import org.wisdom.ecommerce.order.presentation.OrderController;


@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

    @InjectMocks
    private OrderController controller;

    @Mock
    private OrderService service;

    @Test
    void 주문_호출_확인() {
        // given
        OrderApiDto.Request orderApiDto = OrderApiDto.Request.builder().build();
        // when
        controller.order(orderApiDto);
        // then
        verify(service).order(orderApiDto.toOrderServiceDto());
    }
}