package service.impl;

import base.service.BaseServiceImpl;
import domain.CreditCard;
import domain.Transaction;
import repository.TransactionRepository;
import service.TransactionService;
import util.ApplicationContext;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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
        transaction.setCreditCards(creditCard);
        createOrUpdate(transaction);
    }

    @Override
    public void seeHistory() {
        System.out.println("To see history enter a date");
        int year = year();
        int month = month();
        int day = day();
        long id = id();
        LocalDateTime requestDate = LocalDateTime.of(year,month,day,0,0);
        List<Transaction> transactionList = repository.findTransactionsBasedOnDate(requestDate,id);
        if(transactionList.size() == 0){
            System.out.println("You don't have any transaction yet");
        }else{
            ApplicationContext.getDemonstrateInfos().printTransactionsHistory(transactionList);
        }
    }

    private long id() {
        while(true){
            try{
                System.out.println("Enter id of credit card you want to see history : ");
                long id = new Scanner(System.in).nextLong();
                CreditCard creditCard = ApplicationContext.getCreditCardService().findCard(id);
                if(creditCard == null){
                    System.out.println("Wrong id");
                }else{
                    return id;
                }
            }catch (InputMismatchException exception){
                System.out.println("Wrong input");
            }
        }
    }

    private int year(){
        while (true) {
            try {
                System.out.print("Year: ");
                int year = new Scanner(System.in).nextInt();
                while (String.valueOf(year).length() != 4) {
                    System.out.println("This is not a valid number for year");
                    System.out.println("Try again");
                    year = new Scanner(System.in).nextInt();
                }
                return year;
            } catch (InputMismatchException exception) {
                System.out.println("You should enter number");
                System.out.println("Try again");
            }
        }
    }

    private int day() {
        while (true) {
            try {
                System.out.print("Day : ");
                int day = new Scanner(System.in).nextInt();
                while (day < 1 || day > 31) {
                    System.out.println("This is not a valid number for day");
                    System.out.println("Try again");
                    day = new Scanner(System.in).nextInt();
                }
                return day;
            } catch (InputMismatchException exception) {
                System.out.println("You should enter number");
                System.out.println("Try again");
            }
        }
    }

    private int month() {
        while (true) {
            try {
                System.out.print("Month : ");
                int month = new Scanner(System.in).nextInt();
                while (month < 1 || month > 12) {
                    System.out.println("This is not a valid number for month");
                    System.out.println("Try again");
                    month = new Scanner(System.in).nextInt();
                }
                return month;
            } catch (InputMismatchException exception) {
                System.out.println("You should enter number");
                System.out.println("Try again");
            }
        }
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
            for(int i = 0 ; i < 12 ; i++){
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
