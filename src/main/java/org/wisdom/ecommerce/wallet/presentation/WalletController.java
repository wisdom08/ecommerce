package org.wisdom.ecommerce.wallet.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wisdom.ecommerce.common.model.CommonApiResponse;
import org.wisdom.ecommerce.wallet.application.WalletFacade;
import org.wisdom.ecommerce.wallet.application.WalletServiceDto;

@Tag(name = "[지갑]")
@RequestMapping("/api/v1/wallet")
@RestController
public class WalletController {

  private final WalletFacade walletFacade;

  public WalletController(WalletFacade walletFacade) {
    this.walletFacade = walletFacade;
  }

  @Operation(summary = "충전")
  @PatchMapping()
  public CommonApiResponse<WalletApiDto> chargePoint(
      @RequestBody WalletApiDto.Request walletRequest) {
    WalletServiceDto wallet = walletFacade.charge(walletRequest.userId(), walletRequest.amount());
    return CommonApiResponse.success(WalletApiDto.from(wallet));
  }


  @Operation(summary = "사용 가능한 포인트 조회")
  @GetMapping("/{userId}")
  public CommonApiResponse<WalletApiDto> getPointsBy(@PathVariable(name = "userId") long userId) {
    return CommonApiResponse.success(WalletApiDto.from(walletFacade.getWalletBalance(userId)));
  }
}
