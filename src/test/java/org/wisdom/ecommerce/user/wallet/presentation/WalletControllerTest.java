package org.wisdom.ecommerce.user.wallet.presentation;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.wisdom.ecommerce.wallet.application.WalletFacade;
import org.wisdom.ecommerce.wallet.application.WalletInfoDto;
import org.wisdom.ecommerce.wallet.presentation.WalletApiRequest;
import org.wisdom.ecommerce.wallet.presentation.WalletController;

@ExtendWith(MockitoExtension.class)
class WalletControllerTest {

  private final Long userId = 0L;
  private final Integer amount = 100000;

  @InjectMocks
  private WalletController controller;
  @Mock
  private WalletFacade facade;

  @Test
  void 포인트_조회_호출_확인() {
    // given
    when(facade.getWalletBalance(userId)).thenReturn(getWalletInfoDto(amount));
    // when
    controller.getPointsBy(userId);
    // then
    verify(facade).getWalletBalance(userId);
  }


  @Test
  void 포인트_충전_호출_확인() {
    // given
    when(facade.charge(userId, amount)).thenReturn(getWalletInfoDto(amount));
    // when
    controller.chargePoint(WalletApiRequest.builder().userId(userId).amount(amount).build());
    // then
    verify(facade).charge(userId, amount);
  }

  private WalletInfoDto getWalletInfoDto(Integer amount) {
    return WalletInfoDto.builder().userId(userId).balance(amount).build();
  }
}