package org.wisdom.ecommerce.product.presentation;

import lombok.Builder;
import org.wisdom.ecommerce.product.domain.Product;

@Builder
public record ProductApiDto(long productId, String name, int price, int quantity) {
    public static ProductApiDto from(Product product) {
        return ProductApiDto.builder()
                .productId(product.productId())
                .name(product.name())
                .price(product.price())
                .quantity(product.quantity())
                .build();
    }
}
