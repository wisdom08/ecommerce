package org.wisdom.ecommerce.product.domain;

import lombok.Builder;

@Builder
public record Product(long productId, String name, int price, int quantity) {
}
