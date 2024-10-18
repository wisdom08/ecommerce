package org.wisdom.ecommerce.user.order.application;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.wisdom.ecommerce.order.application.OrderService;
import org.wisdom.ecommerce.order.application.OrderServiceDto;
import org.wisdom.ecommerce.order.presentation.OrderApiDto;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @InjectMocks
    private OrderService service;

    @Test
    void 주문_응답_확인() {
        // given
        OrderServiceDto.Request orderServiceDto = OrderApiDto.Request.builder()
            .userId(0)
            .productId(0)
            .build().toOrderServiceDto();

        // when
//        OrderApiDto.Response result = service.order(orderServiceDto);

        // then
//        assertThat(result.productId()).isEqualTo(0);
//        assertThat(result.userId()).isEqualTo(0);
    }


}