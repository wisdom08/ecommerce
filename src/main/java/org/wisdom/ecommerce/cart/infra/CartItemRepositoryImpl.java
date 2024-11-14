package org.wisdom.ecommerce.cart.infra;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.wisdom.ecommerce.cart.application.CartItemRepository;
import org.wisdom.ecommerce.cart.domain.CartItem;

@Repository
public class CartItemRepositoryImpl implements CartItemRepository {

  private final CartItemJpaRepository repository;

  public CartItemRepositoryImpl(CartItemJpaRepository repository) {
    this.repository = repository;
  }


  @Override
  public Page<CartItem> getCartItems(Long validCartId, PageRequest pageRequest) {
    return repository.findAllByCartId(validCartId, pageRequest).map(CartItemEntity::toDomain);
  }

  @Override
  public void removeItem(Long cartId, Long productId) {
    repository.deleteByCartIdAndProductId(cartId, productId);
  }

  @Override
  public void save(Long validCartId, Long productId, int quantity) {
    repository.save(CartItemEntity.of(validCartId, productId, quantity));
  }
}
