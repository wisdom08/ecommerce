package org.wisdom.ecommerce.user.cart;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.wisdom.ecommerce.cart.application.CartService;
import org.wisdom.ecommerce.cart.application.CartServiceDto;
import org.wisdom.ecommerce.cart.presentation.CartApiDto;

@ExtendWith(MockitoExtension.class)
class CartServiceTest {

    @InjectMocks
    private CartService service;

    @Test
    void 장바구니_조회_응답_확인() {
        // given

        // when
        List<CartApiDto.Response> result = service.getCartsBy(1);

        // then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.stream().map(CartApiDto.Response::productName)).isEqualTo(
            List.of("MOCK_PRODUCT_NAME_1", "MOCK_PRODUCT_NAME_2"));
    }

    @Test
    void 장바구니_추가_응답_확인() {
        // given

        // when
        List<CartApiDto.Response> result = service.addCarts(10);

        // then
        assertThat(result.size()).isEqualTo(3);
        assertThat(result.stream().map(CartApiDto.Response::productName)).isEqualTo(
            List.of("MOCK_PRODUCT_NAME_1", "MOCK_PRODUCT_NAME_2", "MOCK_PRODUCT_NAME_3"));
    }

    @Test
    void 장바구니_삭제_응답_확인() {
        // given
        CartServiceDto.Request cartServiceDto = CartServiceDto.Request.builder().cartId(2).build();
        // when
        List<CartApiDto.Response> result = service.removeProductInCarts(cartServiceDto);
        // then
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.stream().map(CartApiDto.Response::productName)).isEqualTo(List.of("MOCK_PRODUCT_NAME_2"));
    }

}