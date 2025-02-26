package org.wisdom.ecommerce.wallet.infra;

import org.springframework.stereotype.Repository;
import org.wisdom.ecommerce.wallet.application.TransactionRepository;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

  private final TransactionJpaRepository repository;

  public TransactionRepositoryImpl(TransactionJpaRepository repository) {
    this.repository = repository;
  }

  @Override
  public void save(Long walletId, Integer amount, TransactionType transactionType) {
    TransactionEntity entity = TransactionEntity.of(walletId, amount, transactionType);
    repository.save(entity);
  }
}
