package org.wisdom.ecommerce.user.order.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.wisdom.ecommerce.order.application.OrderRepository;
import org.wisdom.ecommerce.order.application.OrderService;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

  @InjectMocks
  private OrderService service;

  @Mock
  private OrderRepository repository;

  @Test
  void 주문_요청_시_주문ID를_반환한다() {
    // given
    val userId = 0L;
    when(repository.place(userId)).thenReturn(1L);
    // when
    val result = service.order(userId);
    // then
    assertThat(result).isNotNull();
  }
}