package org.wisdom.ecommerce.wallet.application;

import org.springframework.stereotype.Repository;
import org.wisdom.ecommerce.wallet.domain.Wallet;

@Repository
public interface WalletRepository {

  Wallet getWalletBy(Long validUserId);

  void plusBalance(Wallet wallet, Integer amount);
  
  void minusBalance(Wallet wallet, Integer amount);
}
