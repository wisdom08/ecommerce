package org.wisdom.ecommerce.user.cart;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
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
    // when
    controller.getCartBy(any());
    // then
    verify(facade).getCartBy(any());
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