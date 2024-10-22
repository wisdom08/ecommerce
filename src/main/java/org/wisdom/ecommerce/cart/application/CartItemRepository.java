package org.wisdom.ecommerce.cart.application;


import org.wisdom.ecommerce.cart.domain.CartItem;

import java.util.List;

public interface CartItemRepository {

  List<CartItem> getCartItems(Long validCartId);

  void removeItem(Long cartId, Long productId);

  void save(Long validCartId, Long productId, int quantity);
}
