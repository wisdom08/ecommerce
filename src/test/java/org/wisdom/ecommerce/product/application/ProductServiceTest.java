package org.wisdom.ecommerce.product.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.wisdom.ecommerce.product.domain.Product;

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
        .id(0L)
        .name("MOCK_PRODUCT_1")
        .quantity(100)
        .price(100000)
        .build());
    // when
    var result = service.getProductBy(0L);
    // then
    assertThat(result.id()).isEqualTo(0L);
    assertThat(result.name()).isEqualTo("MOCK_PRODUCT_2");
    assertThat(result.price()).isEqualTo(100000);
  }
}