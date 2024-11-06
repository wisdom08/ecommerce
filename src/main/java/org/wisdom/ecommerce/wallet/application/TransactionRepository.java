package org.wisdom.ecommerce.wallet.application;

import org.wisdom.ecommerce.wallet.infra.TransactionType;

public interface TransactionRepository {

  void save(Long walletId, Integer amount, TransactionType deduct);
}
