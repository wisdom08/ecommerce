package org.wisdom.ecommerce.wallet.application;

import lombok.Builder;
import org.wisdom.ecommerce.wallet.domain.Wallet;

@Builder
public record WalletServiceDto(long userId, int balance) {

    public static WalletServiceDto from(Wallet wallet) {
        return WalletServiceDto.builder()
            .userId(wallet.userId())
            .balance(wallet.balance())
            .build();
    }
}