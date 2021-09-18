package service.impl;

import base.service.BaseServiceImpl;
import domain.Transaction;
import repository.TransactionRepository;
import service.TransactionService;

public class TransactionServiceImpl extends BaseServiceImpl<Transaction,Long, TransactionRepository> implements TransactionService {
    public TransactionServiceImpl(TransactionRepository repository) {
        super(repository);
    }
}
