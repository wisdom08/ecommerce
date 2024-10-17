package org.wisdom.ecommerce.cart.application;


import org.wisdom.ecommerce.cart.domain.CartItem;

import java.util.List;

public interface CartItemRepository {

    List<CartItem> getCartItems(long validCartId);

    void removeItem(long cartId, long productId);

    void save(long validCartId, long productId, int quantity);
}
