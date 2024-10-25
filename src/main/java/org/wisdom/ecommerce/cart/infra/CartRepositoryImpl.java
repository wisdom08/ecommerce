package org.wisdom.ecommerce.cart.infra;

import org.springframework.stereotype.Repository;
import org.wisdom.ecommerce.cart.application.CartRepository;

@Repository
public class CartRepositoryImpl implements CartRepository {

  private final CartJpaRepository repository;

  public CartRepositoryImpl(CartJpaRepository repository) {
    this.repository = repository;
  }

  @Override
  public Long getCartBy(Long userId) {
    return repository.findByUserId(userId);
  }
}
