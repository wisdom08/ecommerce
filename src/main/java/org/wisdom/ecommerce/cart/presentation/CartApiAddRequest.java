package org.wisdom.ecommerce.cart.presentation;

import lombok.Builder;

@Builder
public record CartApiAddRequest(Long userId, Long productId, int quantity) {

}
