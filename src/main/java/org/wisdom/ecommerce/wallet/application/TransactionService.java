package org.wisdom.ecommerce.wallet.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService {

  private final TransactionRepository repository;

  public TransactionService(TransactionRepository repository) {
    this.repository = repository;
  }

  @Transactional
  public void saveTransaction(Long walletId, Integer amount) {
    repository.save(walletId, amount);
  }
}
