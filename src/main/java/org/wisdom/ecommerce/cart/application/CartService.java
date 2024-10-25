package org.wisdom.ecommerce.cart.application;

import org.springframework.stereotype.Service;

@Service
public class CartService {

  private final CartRepository cartRepository;

  public CartService(CartRepository cartRepository) {
    this.cartRepository = cartRepository;
  }

  public Long getCartsBy(Long userId) {
    return cartRepository.getCartBy(userId);
  }
}
