package org.wisdom.ecommerce.wallet.application;

import org.springframework.stereotype.Repository;
import org.wisdom.ecommerce.wallet.domain.Wallet;

@Repository
public interface WalletRepository {

  Wallet getWalletBy(Long validUserId);

  void updateBalance(Wallet wallet, Integer amount);
}
