package org.wisdom.ecommerce.wallet.domain;

import lombok.Builder;

@Builder
public record Wallet(long walletId, long userId, int balance) {

    public void validateAmount(int pointToCharge) {
        if(pointToCharge < 10000) {
            throw new IllegalArgumentException("충전할 포인트는 10000 이상 이어야 합니다");
        }
    }

}
