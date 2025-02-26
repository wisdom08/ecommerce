package org.wisdom.ecommerce.wallet.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.wisdom.ecommerce.wallet.domain.Wallet;

@ExtendWith(MockitoExtension.class)
class WalletServiceTest {

  private final Integer amount = 100000;
  @InjectMocks
  private WalletService service;
  @Mock
  private WalletRepository repository;

  @Test
  void 포인트_조회_응답_확인() {
    // given
    val userId = 0L;
    when(repository.getWalletBy(userId)).thenReturn(Wallet.builder().userId(userId).balance(amount).build());
    // when
    Wallet result = service.getWalletBy(userId);
    // then
    assertThat(result.userId()).isEqualTo(userId);
    assertThat(result.balance()).isEqualTo(amount);
  }

  @Test
  void 포인트_충전을_하기_위해_walletRepository의_plusBalance를_호출한다() {
    // given
    // when
    service.charge(Wallet.builder().build(), amount);
    // then
    verify(repository, only()).plusBalance(any(), any());
  }
}