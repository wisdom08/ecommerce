package org.wisdom.ecommerce.wallet.application;

import lombok.Builder;
import org.wisdom.ecommerce.wallet.domain.Wallet;

@Builder
public record WalletInfo(Long walletId, Long userId, Integer balance) {

  public static WalletInfo from(Wallet wallet) {
    return WalletInfo.builder()
        .walletId(wallet.walletId())
        .userId(wallet.userId())
        .balance(wallet.balance())
        .build();
  }

  public static WalletInfo walletCharged(Wallet wallet, Integer amount) {
    return WalletInfo.builder()
        .walletId(wallet.walletId())
        .userId(wallet.userId())
        .balance(wallet.balance() + amount)
        .build();
  }
}