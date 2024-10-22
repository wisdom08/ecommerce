package org.wisdom.ecommerce.product.domain;

import lombok.Builder;

@Builder
public record Product(Long id, String name, int price, int quantity) {

}
