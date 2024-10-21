package org.wisdom.ecommerce.wallet.application;

import org.springframework.stereotype.Repository;
import org.wisdom.ecommerce.wallet.domain.Wallet;

@Repository
public interface WalletRepository {

    Wallet getWalletBy(long validUserId);

    void updateBalance(long walletId, int amount);
}
