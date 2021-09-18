package repository.impl;

import base.repository.BaseRepositoryImpl;
import domain.Transaction;
import repository.TransactionRepository;

import javax.persistence.EntityManager;

public class TransactionRepositoryImpl extends BaseRepositoryImpl<Transaction, Long> implements TransactionRepository {
    public TransactionRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Transaction> getEntity() {
        return Transaction.class;
    }
}
