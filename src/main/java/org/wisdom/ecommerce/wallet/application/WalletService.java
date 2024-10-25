package org.wisdom.ecommerce.wallet.application;

import org.springframework.stereotype.Service;
import org.wisdom.ecommerce.wallet.domain.Wallet;

@Service
public class WalletService {

  private final WalletRepository walletRepository;

  public WalletService(WalletRepository walletRepository) {
    this.walletRepository = walletRepository;
  }


  public Wallet getWalletBy(Long validUserId) {
    return walletRepository.getWalletBy(validUserId);
  }

  public void charge(Wallet wallet, Integer amount) {
    wallet.validateChargeAmount(amount);
    walletRepository.updateBalance(wallet, amount + wallet.balance());
  }

  public void updateBalance(Wallet wallet, int price) {
    walletRepository.updateBalance(wallet, price);
  }
}
