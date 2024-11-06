package org.wisdom.ecommerce.wallet.infra;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WalletJpaRepository extends JpaRepository<WalletEntity, Long> {

  Optional<WalletEntity> findByUserId(Long userId);

  @Modifying
  @Query("update WalletEntity w SET w.balance = :newBalance where w.id = :id")
  void updateBalance(@Param("id") Long id, @Param("newBalance") int newBalance);
}
