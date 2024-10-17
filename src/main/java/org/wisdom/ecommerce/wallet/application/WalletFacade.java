package org.wisdom.ecommerce.wallet.application;

import org.springframework.stereotype.Component;
import org.wisdom.ecommerce.user.application.UserService;
import org.wisdom.ecommerce.user.application.UserServiceDto;

@Component
public class WalletFacade {

    private final WalletService walletService;
    private final UserService userService;

    public WalletFacade(WalletService walletService, UserService userService) {
        this.walletService = walletService;
        this.userService = userService;
    }

    public WalletServiceDto getWallet(long userId) {
        UserServiceDto user = userService.getUserBy(userId);
        return walletService.getPointBy(user.userId());
    }
}
