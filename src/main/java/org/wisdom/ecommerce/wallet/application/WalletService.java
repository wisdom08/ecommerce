package org.wisdom.ecommerce.wallet.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wisdom.ecommerce.wallet.domain.Wallet;

@Service
public class WalletService {

  private final WalletRepository walletRepository;

  public WalletService(WalletRepository walletRepository) {
    this.walletRepository = walletRepository;
  }


  @Transactional(readOnly = true)
  public Wallet getWalletBy(Long validUserId) {
    return walletRepository.getWalletBy(validUserId);
  }

  @Transactional
  public void charge(Wallet wallet, Integer amount) {
    wallet.validateChargeAmount(amount);
    walletRepository.plusBalance(wallet, amount + wallet.balance());
  }

  @Transactional
  public void minusBalance(Wallet wallet, int price) {
    wallet.validatePayAmount(price);
    walletRepository.minusBalance(wallet, wallet.balance() - price);
  }
}
