package org.wisdom.ecommerce.wallet.presentation;

import lombok.Builder;
import org.wisdom.ecommerce.wallet.application.WalletInfoDto;

@Builder
public record WalletApiResponse(long userId, int balance) {

  public static WalletApiResponse from(WalletInfoDto dto) {
    return WalletApiResponse.builder()
        .userId(dto.userId())
        .balance(dto.balance())
        .build();
  }
}
