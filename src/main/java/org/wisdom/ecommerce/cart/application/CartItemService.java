package org.wisdom.ecommerce.cart.application;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CartItemService {

  private final CartItemRepository repository;

  public CartItemService(CartItemRepository repository) {
    this.repository = repository;
  }

  public List<CartInfo> getCartItems(Long validCartId) {
    return repository.getCartItems(validCartId).stream().map(CartInfo::from).toList();
  }

  public void removeItem(Long cartId, Long productId) {
    repository.removeItem(cartId, productId);
  }

  public void addItem(Long validCartId, Long productId, int quantity) {
    repository.save(validCartId, productId, quantity);
  }
}
