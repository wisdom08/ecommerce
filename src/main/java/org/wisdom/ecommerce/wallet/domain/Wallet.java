package org.wisdom.ecommerce.wallet.domain;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Builder
public record Wallet(Long walletId, Long userId, int balance) {

  public void validateChargeAmount(Integer pointToCharge) {
    if (pointToCharge < 10000) {
      log.error("[포인트] 충전 에러: 최소 포인트 충전 금액인 10000보다 작음 {}", pointToCharge);
      throw new IllegalArgumentException("충전할 포인트는 10000 이상 이어야 합니다");
    }
  }

  public void validatePayAmount(Integer pointToPay) {
    if (pointToPay > balance) {
      throw new IllegalArgumentException("잔고가 부족합니다.");
    }
  }
}
