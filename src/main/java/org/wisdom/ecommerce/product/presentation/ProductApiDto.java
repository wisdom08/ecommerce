package org.wisdom.ecommerce.product.presentation;

import lombok.Builder;
import org.wisdom.ecommerce.product.application.ProductApplicationDto;

@Builder
public record ProductApiDto(long productId, String name, int price, int quantity) {

    public static ProductApiDto from(ProductApplicationDto product) {
        return ProductApiDto.builder()
            .productId(product.id())
            .name(product.name())
            .price(product.price())
            .quantity(product.quantity())
            .build();
    }
}
