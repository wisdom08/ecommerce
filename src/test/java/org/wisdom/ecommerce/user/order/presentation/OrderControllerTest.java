package org.wisdom.ecommerce.user.order.presentation;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.wisdom.ecommerce.order.application.OrderFacade;
import org.wisdom.ecommerce.order.presentation.OrderApiDto;
import org.wisdom.ecommerce.order.presentation.OrderController;


@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

  @InjectMocks
  private OrderController controller;

  @Mock
  private OrderFacade facade;

  @Test
  void 주문_호출_확인() {
    // given
    OrderApiDto.Request request = OrderApiDto.Request.builder()
        .userId(0)
        .productId(0)
        .quantity(0)
        .build();
    // when
    controller.order(request);
    // then
    verify(facade).place(request.userId(), request.productId(), request.quantity());
  }
}