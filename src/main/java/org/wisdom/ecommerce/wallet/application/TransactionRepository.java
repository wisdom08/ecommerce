package org.wisdom.ecommerce.wallet.application;

public interface TransactionRepository {

  void save(long walletId, int amount);
}
