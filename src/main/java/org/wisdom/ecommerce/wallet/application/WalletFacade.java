package org.wisdom.ecommerce.wallet.application;

import lombok.val;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class WalletFacade {

  private final WalletService walletService;
  private final TransactionService transactionService;

  public WalletFacade(WalletService walletService, TransactionService transactionService) {
    this.walletService = walletService;
    this.transactionService = transactionService;
  }

  public WalletInfo getWalletBalance(Long userId) {
    return WalletInfo.from(walletService.getWalletBy(userId));
  }

  @Transactional
  public WalletInfo charge(Long userId, Integer amount) {
    val validWallet = walletService.getWalletBy(userId);
    walletService.charge(validWallet, amount);
    transactionService.saveTransaction(validWallet.walletId(), amount);
    return WalletInfo.walletCharged(validWallet, amount);
  }
}
