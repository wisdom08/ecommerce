package org.wisdom.ecommerce.cart.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartService {

  private final CartRepository cartRepository;

  public CartService(CartRepository cartRepository) {
    this.cartRepository = cartRepository;
  }

  @Transactional(readOnly = true)
  public Long getCartsBy(Long userId) {
    return cartRepository.getCartBy(userId);
  }
}
