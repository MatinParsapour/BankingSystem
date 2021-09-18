package service.impl;

import base.service.BaseServiceImpl;
import domain.Transaction;
import repository.TransactionRepository;

public class TransactionServiceImpl extends BaseServiceImpl<Transaction,Long, TransactionRepository> {
    public TransactionServiceImpl(TransactionRepository repository) {
        super(repository);
    }
}
