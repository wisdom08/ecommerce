package org.wisdom.ecommerce.cart.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartJpaRepository extends JpaRepository<CartEntity, Long> {

  @Query("SELECT c.id FROM CartEntity c WHERE c.userId = :userId")
  Long findByUserId(@Param("userId") Long userId);
}
