package org.wisdom.ecommerce.user.wallet.presentation;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.wisdom.ecommerce.wallet.application.WalletFacade;
import org.wisdom.ecommerce.wallet.application.WalletServiceDto;
import org.wisdom.ecommerce.wallet.presentation.WalletController;

@ExtendWith(MockitoExtension.class)
class WalletControllerTest {

    @InjectMocks
    private WalletController controller;

    @Mock
    private WalletFacade facade;

    @Test
    void 포인트_조회_호출_확인() {
        // given
        long userId = 1L;
        when(facade.getWalletBalance(userId)).thenReturn(WalletServiceDto.builder().build());
        // when
        controller.getPointsBy(userId);
        // then
        verify(facade).getWalletBalance(userId);
    }

//    @Test
//    void 포인트_충전_호출_확인() {
//        // given
//        WalletApiDto request = WalletApiDto.builder().build();
//        // when
//        controller.chargePoint(request);
//        // then
//        verify(service).chargePoint(request.toPointServiceDto());
//    }

}