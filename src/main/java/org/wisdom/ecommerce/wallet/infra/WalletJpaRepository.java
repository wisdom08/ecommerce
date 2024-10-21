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

  Optional<WalletEntity> findByUserId(long userId);

  @Lock(LockModeType.PESSIMISTIC_WRITE)
  @Transactional
  @Modifying
  @Query(value = "update WalletEntity w SET w.balance = :balanceCharged where w.id = :walletId")
  void updateBalance(@Param("walletId") long walletId, @Param("balanceCharged") int balanceCharged);
}
