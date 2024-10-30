package org.wisdom.ecommerce.cart.infra;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemJpaRepository extends JpaRepository<CartItemEntity, Long> {

  List<CartItemEntity> findAllByCartId(Long validCartId);

  void deleteByCartIdAndProductId(Long cartId, Long productId);
}
