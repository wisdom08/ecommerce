package org.wisdom.ecommerce.cart.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CartJpaRepository extends JpaRepository<CartEntity, Long> {

    @Query("SELECT c.id FROM CartEntity c WHERE c.userId = :userId")
    long findByUserId(long userId);
}
