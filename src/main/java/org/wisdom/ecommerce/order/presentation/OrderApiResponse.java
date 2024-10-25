package org.wisdom.ecommerce.order.presentation;

import lombok.Builder;

@Builder
public record OrderApiResponse(Long userId, Long productId, Long orderId, Integer totalAmount) {

}
