package org.wisdom.ecommerce.order.domain;

import lombok.Builder;

@Builder
public record Order(Long productId, int quantity, Long orderId, int unitPrice, Long userId) {
}
