package org.wisdom.ecommerce.wallet.application;

import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public void saveTransaction(long walletId, int amount) {
        repository.save(walletId, amount);
    }
}
