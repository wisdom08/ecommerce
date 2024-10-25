package org.wisdom.ecommerce.wallet.presentation;

import lombok.Builder;
import org.wisdom.ecommerce.wallet.application.WalletInfo;

@Builder
public record WalletApiResponse(Long userId, int balance) {

  public static WalletApiResponse from(WalletInfo dto) {
    return WalletApiResponse.builder()
        .userId(dto.userId())
        .balance(dto.balance())
        .build();
  }
}
