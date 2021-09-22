package service.impl;

import base.service.BaseServiceImpl;
import domain.CreditCard;
import domain.Transaction;
import repository.TransactionRepository;
import service.TransactionService;

import java.time.LocalDateTime;
import java.util.Random;

public class TransactionServiceImpl extends BaseServiceImpl<Transaction,Long, TransactionRepository> implements TransactionService {
    public TransactionServiceImpl(TransactionRepository repository) {
        super(repository);
    }

    @Override
    public void newTransaction(CreditCard creditCard, long destinationCardNumber, double amount) {
        Transaction transaction = new Transaction();
        transaction.setBankName(creditCard.getBankName());
        transaction.setUserSureName(creditCard.getUserSureName());
        transaction.setSourceCardNumber(creditCard.getCardNumber());
        transaction.setDestinationCardNumber(destinationCardNumber);
        transaction.setAmount(amount);
        transaction.setDate(LocalDateTime.now());
        transaction.setBalanceAfterTransaction(creditCard.getBalance());
        transaction.setTrackingNo(trackingNo());
        transaction.setReferenceNo(referenceNo());
        createOrUpdate(transaction);
    }
    private int trackingNo(){
        String trackingNoString = "";
        Random random = new Random();
        while(true){
            trackingNoString = "";
            for(int i = 0 ; i <= 6 ; i++){
                trackingNoString += random.nextInt(9);
            }
            int trackingNo = Integer.parseInt(trackingNoString);
            Transaction transaction = repository.findTransactionByTrackingNo(trackingNo);
            if(transaction == null){
                return trackingNo;
            }
        }
    }

    private long referenceNo(){
        String referenceNoString = "";
        Random random = new Random();
        while(true){
            referenceNoString = "";
            for(int i = 0 ; i <= 12 ; i++){
                referenceNoString += random.nextInt(9);
            }
            long referenceNo = Long.parseLong(referenceNoString);
            Transaction transaction = repository.findTransactionByReferenceNo(referenceNo);
            if(transaction == null){
                return referenceNo;
            }
        }
    }
}
