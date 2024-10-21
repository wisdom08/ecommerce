package org.wisdom.ecommerce.user.wallet.presentation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.wisdom.ecommerce.wallet.application.WalletService;
import org.wisdom.ecommerce.wallet.presentation.WalletController;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class WalletControllerTest {

    @InjectMocks
    private WalletController controller;

    @Mock
    private WalletService service;

    @Test
    void 포인트_조회_호출_확인() {
        // given
        long userId = 1L;
        // when
        controller.getPointsBy(userId);
        // then
        verify(service).getWalletBy(userId);
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