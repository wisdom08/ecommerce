package org.wisdom.ecommerce.wallet.application;

public interface TransactionRepository {

  void save(Long walletId, Integer amount);
}
