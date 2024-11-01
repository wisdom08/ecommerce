package org.wisdom.ecommerce.product.infra;

import jakarta.persistence.LockModeType;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {

  @Lock(LockModeType.PESSIMISTIC_WRITE)
  Optional<ProductEntity> findById(Long productId);

  @Modifying
  @Query("update ProductEntity p SET p.quantity = :newStock where p.id = :id")
  void updateStock(@Param("id") Long id, @Param("newStock") int newStock);
}
