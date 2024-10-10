package org.wisdom.ecommerce.product.application;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.wisdom.ecommerce.product.presentation.ProductApiDto;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @InjectMocks
    private ProductService service;

    @Test
    void 상품_조회_응답_확인() {
        // given
        // when
        ProductApiDto.Response result = service.getProductBy(0L);

        // then
        assertThat(result.productId()).isEqualTo(0L);
        assertThat(result.name()).isEqualTo("MOCK_PRODUCT_1");
        assertThat(result.price()).isEqualTo(BigDecimal.valueOf(100000));
        assertThat(result.stock()).isEqualTo(100);
    }

    @Test
    void 인기_상품_조회_응답_확인() {
        // given
        // when
        List<ProductApiDto.Response> result = service.getBestOfProducts();

        // then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.stream().map(ProductApiDto.Response::name)).isEqualTo(List.of("MOCK_PRODUCT_1", "MOCK_PRODUCT_2"));
    }
}