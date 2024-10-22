package org.wisdom.ecommerce.user.cart;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.wisdom.ecommerce.cart.application.CartRepository;
import org.wisdom.ecommerce.cart.application.CartService;

@ExtendWith(MockitoExtension.class)
class CartServiceTest {

  @InjectMocks
  private CartService service;

  @Mock
  private CartRepository repository;

  @Test
  void 유저의_장바구니_아이디를_가져온다() {
    // given
    when(repository.getCartBy(1L)).thenReturn(1L);
    // when
    val result = service.getCartsBy(1L);
    // then
    assertThat(result).isEqualTo(1L);
  }
}