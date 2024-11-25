package org.wisdom.ecommerce.cart;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.wisdom.ecommerce.cart.application.CartFacade;
import org.wisdom.ecommerce.cart.presentation.CartApiAddRequest;
import org.wisdom.ecommerce.cart.presentation.CartApiDeleteRequest;
import org.wisdom.ecommerce.cart.presentation.CartController;

@ExtendWith(MockitoExtension.class)
class CartControllerTest {

  @InjectMocks
  private CartController controller;

  @Mock
  private CartFacade facade;

  @Test
  void 장바구니_조회_호출() {
    // given
    val userId = 1L;
    val page = 0;
    val size = 10;
    // when
    when(facade.getCartBy(eq(userId), eq(page), eq(size))).thenReturn(
        new PageImpl<>(new ArrayList<>(), PageRequest.of(page, size), 10));
    controller.getCartBy(userId, page, size);
    // then
    verify(facade).getCartBy(eq(userId), eq(page), eq(size));
  }

  @Test
  void 장바구니_추가_호출() {
    // given
    // when
    controller.addProductToCart(CartApiAddRequest.builder().build());
    // then
    verify(facade).addProductToCart(any(), any(), any());
  }

  @Test
  void 장바구니_삭제_호출() {
    // given
    // when
    controller.removeProductFromCart(CartApiDeleteRequest.builder().build());
    // then
    verify(facade).removeProductFromCart(any(), any());
  }

}