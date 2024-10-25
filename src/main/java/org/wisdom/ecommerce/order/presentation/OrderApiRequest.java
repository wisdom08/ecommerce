package org.wisdom.ecommerce.order.presentation;

import lombok.Builder;

@Builder
public record OrderApiRequest(Long userId, Long productId, int quantity) {

}
