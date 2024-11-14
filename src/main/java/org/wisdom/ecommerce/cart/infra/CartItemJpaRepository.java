package org.wisdom.ecommerce.cart.infra;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemJpaRepository extends JpaRepository<CartItemEntity, Long> {

  Page<CartItemEntity> findAllByCartId(Long validCartId, PageRequest pageRequest);

  void deleteByCartIdAndProductId(Long cartId, Long productId);
}
