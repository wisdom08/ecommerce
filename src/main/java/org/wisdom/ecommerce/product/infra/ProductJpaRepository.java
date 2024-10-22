package org.wisdom.ecommerce.product.infra;

import jakarta.persistence.LockModeType;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {

  @Lock(LockModeType.PESSIMISTIC_WRITE)
  Optional<ProductEntity> findById(Long productId);
}
