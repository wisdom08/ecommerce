package org.wisdom.ecommerce.wallet.presentation;

import lombok.Builder;
import org.wisdom.ecommerce.wallet.application.WalletServiceDto;

@Builder
public record WalletApiDto(long userId, int balance) {

    public static WalletApiDto from(WalletServiceDto wallet) {
        return WalletApiDto.builder()
            .userId(wallet.userId())
            .balance(wallet.balance())
            .build();
    }
}
