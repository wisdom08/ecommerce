package org.wisdom.ecommerce.wallet.application;

import lombok.Builder;
import org.wisdom.ecommerce.wallet.domain.Wallet;

@Builder
public record WalletServiceDto(long walletId, long userId, int balance) {

    public static WalletServiceDto from(Wallet wallet) {
        return WalletServiceDto.builder()
                .walletId(wallet.walletId())
                .userId(wallet.userId())
                .balance(wallet.balance())
                .build();
    }

    public static WalletServiceDto walletCharged(Wallet wallet, int amount) {
        return WalletServiceDto.builder()
                .walletId(wallet.walletId())
                .userId(wallet.userId())
                .balance(wallet.balance()+amount)
                .build();
    }
}