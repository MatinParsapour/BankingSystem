package service.impl;

import base.service.BaseServiceImpl;
import domain.CreditCard;
import repository.CreditCardRepository;
import service.CreditCardService;
import util.ApplicationContext;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class CreditCardServiceImpl extends BaseServiceImpl<CreditCard,Long, CreditCardRepository> implements CreditCardService {
    public CreditCardServiceImpl(CreditCardRepository repository) {
        super(repository);
    }

    @Override
    public long createCreditCardNumber() {
        Random random = new Random();
        String cardNumberString ="";
        long cardNumber = 0;
        while(true){
            cardNumberString = "";
            for(int i = 0 ; i< 16; i++){
                cardNumberString += random.nextInt(9);
            }
            cardNumber = Long.parseLong(cardNumberString);
            CreditCard creditCard = repository.findCreditCardByCardNumber(cardNumber);
            if(creditCard == null){
                break;
            }
        }
        return cardNumber;
    }

    @Override
    public int createCVV2() {
        Random random = new Random();
        String cVV2String = "";
        for(int i = 0 ; i<4 ; i++){
            cVV2String += random.nextInt(9);
        }
        int cVV2 = Integer.parseInt(cVV2String);
        return cVV2;
    }

    @Override
    public String createShebaNumber() {
        Random random = new Random();
        String shebaNumberString ="";
        while(true){
            shebaNumberString = "IR";
            for(int i = 0 ; i< 16; i++){
                shebaNumberString += random.nextInt(9);
            }
            CreditCard creditCard = repository.findCreditCardByShebaNumber(shebaNumberString);
            if(creditCard == null){
                break;
            }
        }
        return shebaNumberString;
    }

    @Override
    public int createFirstPassword() {
        Random random = new Random();
        String firstPassword = "";
        for(int i = 0 ; i < 4 ; i++){
            firstPassword += random.nextInt(9);
        }
        int cVV2 = Integer.parseInt(firstPassword);
        return cVV2;
    }

    @Override
    public void createCreditCard(CreditCard creditCard) {
        createOrUpdate(creditCard);
    }

    @Override
    public void cardToCard() {
        System.out.print("Enter id of source card : ");
        long id = new Scanner(System.in).nextLong();
        CreditCard sourceCard = repository.findCreditCardById(id);
        if(sourceCard == null){
            System.out.println("The id is incorrect");
        }else{
            getDestinationCardNumber(sourceCard);
        }

    }

    @Override
    public void changeFirstPassword() {
        System.out.print("Enter id : ");
        long id = new Scanner(System.in).nextLong();
        CreditCard card = repository.findCreditCardById(id);
        if(card == null){
            System.out.println("id is incorrect");
        }else{
            System.out.println("Enter new password : ");
            int password = new Scanner(System.in).nextInt();
            if(String.valueOf(password).length() == 4){
                card.setFirstPassword(password);
                createOrUpdate(card);
                System.out.println("Your password successfully changed");
            }else{
                System.out.println("Your password should be 4-digit");
            }
        }
    }

    @Override
    public void setOrChangeSecondPassword() {
        System.out.print("Enter id : ");
        long id = new Scanner(System.in).nextLong();
        CreditCard card = repository.findCreditCardById(id);
        if(card == null){
            System.out.println("id is incorrect");
        }else{
            System.out.println("Enter password : ");
            int password = new Scanner(System.in).nextInt();
            if(String.valueOf(password).length() == 6){
                card.setSecondPassword(password);
                createOrUpdate(card);
                System.out.println("Your password successfully changed");
            }else{
                System.out.println("Your password should be 6-digit");
            }
        }
    }

    private void getDestinationCardNumber(CreditCard sourceCard) {
        System.out.print("Enter destination card number : ");
        long destinationCardNumber = new Scanner(System.in).nextLong();
        CreditCard destinationCard = repository.findCreditCardByCardNumber(destinationCardNumber);
        if(destinationCard == null){
            System.out.println("Destination card number is incorrect");
        }else{
            getAmount(sourceCard, destinationCardNumber, destinationCard);
        }
    }

    private void getAmount(CreditCard sourceCard, long destinationCardNumber, CreditCard destinationCard) {
        System.out.print("Enter amount : ");
        double amount = new Scanner(System.in).nextDouble();
        if(sourceCard.getBalance() > amount + .6){
            getCVV2(sourceCard, destinationCardNumber, destinationCard, amount);
        }else{
            System.out.println("You don't have enough balance");
        }
    }

    private void getCVV2(CreditCard sourceCard, long destinationCardNumber, CreditCard destinationCard, double amount) {
        System.out.print("Enter CVV2 : ");
        int cVV2 = new Scanner(System.in).nextInt();
        if(sourceCard.getCVV2() == cVV2){
            getExpirationDate(sourceCard, destinationCardNumber, destinationCard, amount);
        }else{
            System.out.println("CVV2 is incorrect");
        }
    }

    private void getExpirationDate(CreditCard sourceCard, long destinationCardNumber, CreditCard destinationCard, double amount) {
        System.out.print("Enter year of expiration date : ");
        int year = year();
        System.out.print("Enter month of expiration date : ");
        int month = month();
        if(sourceCard.getExpirationDate().getYear() == year && sourceCard.getExpirationDate().getMonth().getValue() == month){
            getPassword(sourceCard, destinationCardNumber, destinationCard, amount);
        }else {
            System.out.println("the date is incorrect");
        }
    }

    private void getPassword(CreditCard sourceCard, long destinationCardNumber, CreditCard destinationCard, double amount) {
        System.out.print("Enter second password : ");
        int secondPassword = new Scanner(System.in).nextInt();
        if(sourceCard.getSecondPassword() == secondPassword){
            doTransaction(sourceCard, destinationCardNumber, destinationCard, amount);
        }else{
            System.out.println("Password is wrong");
            for(int i = 2 ; i > 0 ; i--){
                secondPassword = new Scanner(System.in).nextInt();
                if(sourceCard.getSecondPassword() == secondPassword){
                    doTransaction(sourceCard, destinationCardNumber, destinationCard, amount);
                }else{
                    System.out.println("password is wrong");
                }if(i == 1){
                    sourceCard.getAccount().setBlocked(true);
                    createOrUpdate(sourceCard);
                    System.out.println("Your card is blocked");
                }
            }
        }
    }

    private void doTransaction(CreditCard sourceCard, long destinationCardNumber, CreditCard destinationCard, double amount) {
        double amountPlusWage = amount + .6;
        double sourceCardCurrentBalance = sourceCard.getBalance();
        sourceCardCurrentBalance -= amountPlusWage;
        sourceCard.setBalance(sourceCardCurrentBalance);
        createOrUpdate(sourceCard);
        double destinationCardCurrentBalance = destinationCard.getBalance();
        destinationCardCurrentBalance += amount;
        destinationCard.setBalance(destinationCardCurrentBalance);
        ApplicationContext.getTransactionService().newTransaction(sourceCard, destinationCardNumber, amount);
        createOrUpdate(destinationCard);
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

}
