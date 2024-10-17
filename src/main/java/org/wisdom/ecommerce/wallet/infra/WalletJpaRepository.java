package org.wisdom.ecommerce.wallet.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface WalletJpaRepository extends JpaRepository<WalletEntity, Long> {

    Optional<WalletEntity> findByUserId(long userId);

    @Transactional
    @Modifying
    @Query(value = "update WalletEntity w SET w.balance = :balanceCharged where w.id = :walletId")
    void updateBalance(@Param("walletId") long walletId, @Param("balanceCharged") int balanceCharged);
}
