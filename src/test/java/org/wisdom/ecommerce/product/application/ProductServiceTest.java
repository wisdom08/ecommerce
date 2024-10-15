package org.wisdom.ecommerce.product.application;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.wisdom.ecommerce.product.domain.Product;
import org.wisdom.ecommerce.product.presentation.ProductApiDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @InjectMocks
    private ProductService service;

    @Mock
    private ProductRepository repository;

    @Test
    void 상품_조회_응답_확인() {
        // given
        when(repository.getProductBy(0L)).thenReturn(Product.builder()
                .productId(0L)
                .name("MOCK_PRODUCT_1")
                .quantity(100)
                .price(100000)
                .build());
        // when
        Product result = service.getProductBy(0L);

        // then
        assertThat(result.productId()).isEqualTo(0L);
        assertThat(result.name()).isEqualTo("MOCK_PRODUCT_1");
        assertThat(result.price()).isEqualTo(100000);
        assertThat(result.quantity()).isEqualTo(100);
    }

    @Test
    void 인기_상품_조회_응답_확인() {
        // given
        // when
        List<ProductApiDto> result = service.getBestOfProducts();

        // then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.stream().map(ProductApiDto::name)).isEqualTo(List.of("MOCK_PRODUCT_1", "MOCK_PRODUCT_2"));
    }
}