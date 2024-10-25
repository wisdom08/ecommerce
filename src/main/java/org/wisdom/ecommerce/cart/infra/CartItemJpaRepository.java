package org.wisdom.ecommerce.cart.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemJpaRepository extends JpaRepository<CartItemEntity, Long> {

  List<CartItemEntity> findAllByCartId(Long validCartId);

  void deleteByCartIdAndProductId(Long cartId, Long productId);
}
