package org.wisdom.ecommerce.wallet.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Repository;
import org.wisdom.ecommerce.wallet.application.WalletRepository;
import org.wisdom.ecommerce.wallet.domain.Wallet;

@Repository
public class WalletRepositoryImpl implements WalletRepository {

  private final WalletJpaRepository walletJpaRepository;

  public WalletRepositoryImpl(WalletJpaRepository walletJpaRepository) {
    this.walletJpaRepository = walletJpaRepository;
  }

  @Override
  public Wallet getWalletBy(Long userId) {
    return walletJpaRepository.findByUserId(userId)
        .orElseThrow(() -> new EntityNotFoundException(userId + "의 지갑이 없습니다"))
        .toDomain();
  }

  @Override
  public void updateBalance(Long walletId, Integer amount) {
    walletJpaRepository.updateBalance(walletId, amount);
  }
}
