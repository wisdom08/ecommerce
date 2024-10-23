package org.wisdom.ecommerce.order.presentation;

import static org.mockito.Mockito.verify;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.wisdom.ecommerce.order.application.OrderFacade;


@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

  @InjectMocks
  private OrderController controller;

  @Mock
  private OrderFacade facade;

  @Test
  void 주문_호출_확인() {
    // given
    val request = OrderApiRequest.builder()
        .userId(0L)
        .productId(0L)
        .quantity(0)
        .build();
    // when
    controller.order(request);
    // then
    verify(facade).place(request.userId(), request.productId(), request.quantity());
  }
}