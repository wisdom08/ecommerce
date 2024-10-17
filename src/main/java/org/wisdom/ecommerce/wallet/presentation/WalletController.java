package org.wisdom.ecommerce.wallet.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wisdom.ecommerce.common.model.CommonApiResponse;
import org.wisdom.ecommerce.wallet.application.WalletFacade;
import org.wisdom.ecommerce.wallet.application.WalletServiceDto;

@Tag(name = "[유저]-포인트")
@RequestMapping("/api/v1/users")
@RestController
public class WalletController {

    private final WalletFacade walletFacade;

    public WalletController(WalletFacade walletFacade) {
        this.walletFacade = walletFacade;
    }

//    @Operation(summary = "충전")
//    @PatchMapping("/wallet/point")
//    public CommonApiResponse<WalletApiDto> chargePoint(@RequestBody WalletApiDto walletRequest) {
//        WalletServiceDto wallet = walletFacade.chargePoint(walletRequest.userId(), walletRequest.amount());
//        return CommonApiResponse.success(WalletApiDto.from(wallet));
//    }


    @Operation(summary = "조회")
    @GetMapping("/{userId}/wallet/point")
    public CommonApiResponse<WalletApiDto> getPointsBy(@PathVariable(name = "userId") long userId) {
        WalletServiceDto wallet = walletFacade.getWallet(userId);
        return CommonApiResponse.success(WalletApiDto.from(wallet));
    }
}
