package org.wisdom.ecommerce.product.presentation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.wisdom.ecommerce.product.application.ProductService;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @InjectMocks
    private ProductController controller;

    @Mock
    private ProductService service;

    @Test
    void 상품_조회_호출_확인() {
        // given
        long productId = 0;
        // when
        controller.getProductBy(productId);
        // then
        verify(service).getProductBy(productId);
    }

    @Test
    void 인기_상품_조회_호출_확인() {
        // given
        // when
        controller.getBestOfProducts();
        // then
        verify(service).getBestOfProducts();
    }
}