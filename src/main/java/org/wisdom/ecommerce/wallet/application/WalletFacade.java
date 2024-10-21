package org.wisdom.ecommerce.wallet.application;

import lombok.val;
import org.springframework.stereotype.Component;
import org.wisdom.ecommerce.user.application.UserService;

@Component
public class WalletFacade {

  private final WalletService walletService;
  private final UserService userService;
  private final TransactionService transactionService;

  public WalletFacade(WalletService walletService, UserService userService,
      TransactionService transactionService) {
    this.walletService = walletService;
    this.userService = userService;
    this.transactionService = transactionService;
  }

  public WalletInfoDto getWalletBalance(Long userId) {
    val validUserId = userService.getUserBy(userId);
    return WalletInfoDto.from(walletService.getWalletBy(validUserId));
  }

  public WalletInfoDto charge(Long userId, Integer amount) {
    val validWallet = walletService.getWalletBy(userService.getUserBy(userId));
    walletService.charge(validWallet, amount);
    transactionService.saveTransaction(validWallet.walletId(), amount);
    return WalletInfoDto.walletCharged(validWallet, amount);
  }
}
