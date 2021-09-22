package service;

import base.service.BaseService;
import domain.CreditCard;
import domain.Transaction;

public interface TransactionService extends BaseService<Transaction, Long> {

    void newTransaction(CreditCard creditCard, long destinationCardNumber, double amount);
}
