package org.wisdom.ecommerce.wallet.application;

import org.springframework.stereotype.Service;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public WalletServiceDto chargePoint(long userId, int amount) {

        return null;
    }

    public WalletServiceDto getPointBy(long userId) {
        return WalletServiceDto.from(walletRepository.getWalletBy(userId));
    }
}
