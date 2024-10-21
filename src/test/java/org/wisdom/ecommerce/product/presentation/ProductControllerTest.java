package org.wisdom.ecommerce.product.presentation;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.wisdom.ecommerce.product.application.ProductApplicationDto;
import org.wisdom.ecommerce.product.application.ProductFacade;
import org.wisdom.ecommerce.product.domain.Product;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @InjectMocks
    private ProductController controller;

    @Mock
    private ProductFacade facade;

    @Test
    void 상품_조회_호출_확인() {
        // given
        long productId = 0;
        when(facade.getProductBy(productId)).thenReturn(
            ProductApplicationDto.toResponse(Product.builder().build())); // Moc
        // when
        controller.getProductBy(productId);
        // then
        verify(facade).getProductBy(productId);
    }

    @Test
    void 인기_상품_조회_호출_확인() {
        // given
        // when
        controller.getBestOfProducts();
        // then
        verify(facade).getBestOfProducts();
    }
}