package org.wisdom.ecommerce.product.application;

import org.springframework.stereotype.Service;
import org.wisdom.ecommerce.product.presentation.ProductApiDto;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {
    public ProductApiDto.Response getProductBy(long productId) {
        return ProductApiDto.Response.builder()
                .productId(productId)
                .name("MOCK_PRODUCT_1")
                .price(BigDecimal.valueOf(100000))
                .stock(100)
                .build();
    }

    public List<ProductApiDto.Response> getBestOfProducts() {
        return List.of(
                ProductApiDto.Response.builder()
                .productId(1)
                .name("MOCK_PRODUCT_1")
                .price(BigDecimal.valueOf(100000))
                .stock(100)
                .build(),

                ProductApiDto.Response.builder()
                        .productId(1)
                        .name("MOCK_PRODUCT_2")
                        .price(BigDecimal.valueOf(200000))
                        .stock(200)
                        .build()
                );
    }
}
