package org.wisdom.ecommerce.cart.application;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartItemService {

  private final CartItemRepository repository;

  public CartItemService(CartItemRepository repository) {
    this.repository = repository;
  }

  @Transactional(readOnly = true)
  public Page<CartInfo> getCartItems(Long validCartId, PageRequest pageRequest) {
    return repository.getCartItems(validCartId, pageRequest).map(CartInfo::from);
  }

  @Transactional
  public void removeItem(Long cartId, Long productId) {
    repository.removeItem(cartId, productId);
  }

  @Transactional
  public void addItem(Long validCartId, Long productId, int quantity) {
    repository.save(validCartId, productId, quantity);
  }
}
