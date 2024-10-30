package org.wisdom.ecommerce.wallet.infra;

import jakarta.persistence.LockModeType;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface WalletJpaRepository extends JpaRepository<WalletEntity, Long> {
  
  @Transactional
  @Lock(LockModeType.PESSIMISTIC_WRITE)
  Optional<WalletEntity> findByUserId(Long userId);

  @Transactional
  @Modifying
  @Query("update WalletEntity w SET w.balance = :newBalance where w.id = :id")
  void updateBalance(@Param("id") Long id, @Param("newBalance") int newBalance);
}
