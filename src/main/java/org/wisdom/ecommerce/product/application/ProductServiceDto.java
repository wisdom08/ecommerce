package org.wisdom.ecommerce.product.application;

import lombok.Builder;
import org.wisdom.ecommerce.product.domain.Product;

@Builder
public record ProductServiceDto(long id, String name, int price) {

    public static ProductServiceDto of(long id, String name, int price) {
        return ProductServiceDto.builder()
                .id(id)
                .name(name)
                .price(price)
                .build();
    }

    public static ProductServiceDto from(Product product) {
        return ProductServiceDto.builder()
                .id(product.productId())
                .name(product.name())
                .price(product.price())
                .build();

    }
}
