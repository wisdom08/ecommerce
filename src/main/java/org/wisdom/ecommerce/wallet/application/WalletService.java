package org.wisdom.ecommerce.wallet.application;

import org.springframework.stereotype.Service;
import org.wisdom.ecommerce.wallet.domain.Wallet;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }



    public Wallet getWalletBy(long validUserId) {
        return walletRepository.getWalletBy(validUserId);
    }

    public WalletServiceDto charge(Wallet wallet, int amount) {
        wallet.validateAmount(amount);
        walletRepository.updateBalance(wallet.walletId(), amount+ wallet.balance());
        return WalletServiceDto.walletCharged(wallet, amount);
    }
}
