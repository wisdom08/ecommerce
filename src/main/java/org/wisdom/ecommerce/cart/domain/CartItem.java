package org.wisdom.ecommerce.cart.domain;

import lombok.Builder;

@Builder
public record CartItem(long id, long cartId, long productId, int quantity) {

    public void validateQuantity() {
        if (this.quantity <= 0) {
            throw new IllegalArgumentException("수량은 1이상이어야 합니다");
        }
    }
}
