package org.wisdom.ecommerce.cart.application;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.wisdom.ecommerce.cart.domain.CartItem;

public interface CartItemRepository {

  Page<CartItem> getCartItems(Long validCartId, PageRequest pageRequest);

  void removeItem(Long cartId, Long productId);

  void save(Long validCartId, Long productId, int quantity);
}
