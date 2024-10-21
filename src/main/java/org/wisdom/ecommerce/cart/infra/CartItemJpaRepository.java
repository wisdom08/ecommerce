package org.wisdom.ecommerce.cart.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemJpaRepository extends JpaRepository<CartItemEntity, Long> {

    List<CartItemEntity> findAllByCartId(long validCartId);

    void deleteByCartIdAndProductId(long cartId, long productId);
}
