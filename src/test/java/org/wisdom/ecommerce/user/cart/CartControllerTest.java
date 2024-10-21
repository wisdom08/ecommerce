package org.wisdom.ecommerce.user.cart;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.wisdom.ecommerce.cart.application.CartFacade;
import org.wisdom.ecommerce.cart.presentation.CartApiDto.AddRequest;
import org.wisdom.ecommerce.cart.presentation.CartApiDto.DeleteRequest;
import org.wisdom.ecommerce.cart.presentation.CartController;

@ExtendWith(MockitoExtension.class)
class CartControllerTest {

  @InjectMocks
  private CartController controller;

  @Mock
  private CartFacade facade;

  @Test
  void 장바구니_조회() {
    // given
    long userId = 0;
    // when
    controller.getCartBy(userId);
    // then
    verify(facade).getCartBy(userId);
  }

  @Test
  void 장바구니_추가() {
    // given
    // when
    AddRequest request = AddRequest.builder().userId(0).productId(0).quantity(0).build();
    controller.addProductToCart(request);
    // then
    verify(facade).addProductToCart(request.userId(), request.productId(), request.quantity());
  }

  @Test
  void 장바구니_삭제() {
    // given
    // when
    DeleteRequest request = DeleteRequest.builder().userId(0).cartId(0).build();
    controller.removeProductFromCart(request);
    // then
    verify(facade).removeProductFromCart(request.userId(), request.cartId());
  }

}