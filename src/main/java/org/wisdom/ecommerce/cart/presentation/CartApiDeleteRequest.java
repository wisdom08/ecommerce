package org.wisdom.ecommerce.cart.presentation;

import lombok.Builder;

@Builder
public record CartApiDeleteRequest(Long userId, Long cartId) {

}
