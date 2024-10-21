package org.wisdom.ecommerce.wallet.application;

import lombok.Builder;
import org.wisdom.ecommerce.wallet.domain.Wallet;

@Builder
public record WalletInfoDto(Long walletId, Long userId, Integer balance) {

  public static WalletInfoDto from(Wallet wallet) {
    return WalletInfoDto.builder()
        .walletId(wallet.walletId())
        .userId(wallet.userId())
        .balance(wallet.balance())
        .build();
  }

  public static WalletInfoDto walletCharged(Wallet wallet, Integer amount) {
    return WalletInfoDto.builder()
        .walletId(wallet.walletId())
        .userId(wallet.userId())
        .balance(wallet.balance() + amount)
        .build();
  }
}