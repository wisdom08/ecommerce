package org.wisdom.ecommerce.user.wallet.application;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.wisdom.ecommerce.wallet.application.WalletRepository;
import org.wisdom.ecommerce.wallet.application.WalletService;
import org.wisdom.ecommerce.wallet.domain.Wallet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WalletServiceTest {


    @InjectMocks
    private WalletService service;

    @Mock
    private WalletRepository repository;

    @Test
    void 포인트_조회_응답_확인() {
        // given
        when(repository.getWalletBy(0L)).thenReturn(Wallet.builder().userId(0L).balance(100000).build());
        // when
        Wallet result = service.getWalletBy(0L);
        // then
        assertThat(result.userId()).isEqualTo(0L);
        assertThat(result.balance()).isEqualTo(100000);
    }

//    @Test
//    void 포인트_충전_응답_확인() {
//        // given
//        WalletServiceDto.Request serviceDto = WalletApiDto.Request.builder()
//            .userId(0L)
//            .pointToCharge(BigDecimal.valueOf(100000))
//            .build()
//            .toPointServiceDto();
//
//        // when
//        WalletApiDto.Response result = service.chargePoints(serviceDto);
//
//        // then
//        assertThat(result.userId()).isEqualTo(0L);
//        assertThat(result.totalPoint()).isEqualTo(BigDecimal.valueOf(100000));
//    }
}