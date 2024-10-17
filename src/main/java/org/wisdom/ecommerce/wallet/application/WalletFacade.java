package org.wisdom.ecommerce.wallet.application;

import org.springframework.stereotype.Component;
import org.wisdom.ecommerce.user.application.UserService;
import org.wisdom.ecommerce.wallet.domain.Wallet;

@Component
public class WalletFacade {

    private final WalletService walletService;
    private final UserService userService;
    private final TransactionService transactionService;

    public WalletFacade(WalletService walletService, UserService userService, TransactionService transactionService) {
        this.walletService = walletService;
        this.userService = userService;
        this.transactionService = transactionService;
    }

    public WalletServiceDto getWalletBalance(long userId) {
        long validUserId = userService.getUserBy(userId);
        return WalletServiceDto.from(walletService.getWalletBy(validUserId));
    }

    public WalletServiceDto charge(long userId, int amount) {
        /*
        validation
        - userId
        - amount -> 0보다 커야함

        * 1. 유저 조회
        * 2. 월렛 조회
        * 3. 월렛 발란스 업데이트
        * 4. 트랜잭션 히스토리 추가
        * */
        Wallet wallet = walletService.getWalletBy(userService.getUserBy(userId));
        transactionService.saveTransaction(wallet.walletId(), amount);
        return walletService.charge(wallet, amount);
    }
}
