package org.wisdom.ecommerce.user.cart;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.wisdom.ecommerce.cart.application.CartService;
import org.wisdom.ecommerce.cart.presentation.CartApiDto;
import org.wisdom.ecommerce.cart.presentation.CartController;

@ExtendWith(MockitoExtension.class)
class CartControllerTest {

    @InjectMocks
    private CartController controller;

    @Mock
    private CartService service;

    @Test
    void 장바구니_조회() {
        // given
        long userId = 0;
        // when
        controller.getCartsBy(userId);
        // then
        verify(service).getCartsBy(userId);
    }

    @Test
    void 장바구니_추가() {
        // given
        long userId = 0;
        // when
        controller.getCartsBy(userId);
        // then
        verify(service).getCartsBy(userId);
    }

    @Test
    void 장바구니_삭제() {
        // given
        CartApiDto.Request cartApiRequest = CartApiDto.Request.builder().build();
        // when
        controller.removeProductInCarts(cartApiRequest);
        // then
        verify(service).removeProductInCarts(cartApiRequest.toCartServiceDto());
    }

}