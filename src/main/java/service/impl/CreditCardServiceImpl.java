package service.impl;

import base.service.BaseServiceImpl;
import domain.CreditCard;
import repository.CreditCardRepository;
import service.CreditCardService;
import util.ApplicationContext;

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
            for(int i = 0 ; i<= 16; i++){
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
        for(int i = 0 ; i<=4 ; i++){
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
            for(int i = 0 ; i<= 16; i++){
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
        for(int i = 0 ; i<=4 ; i++){
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
            System.out.print("Enter destination card number : ");
            long destinationCardNumber = new Scanner(System.in).nextLong();
            CreditCard destinationCard = repository.findCreditCardByCardNumber(destinationCardNumber);
            if(destinationCard == null){
                System.out.println("Destination card number is incorrect");
            }else{
                System.out.print("Enter amount : ");
                double amount = new Scanner(System.in).nextDouble();
                if(sourceCard.getBalance() > amount + .6){
                    System.out.print("Enter CVV2 : ");
                    int cVV2 = new Scanner(System.in).nextInt();
                    if(sourceCard.getCVV2() == cVV2){
                        System.out.print("Enter year of expiration date : ");
                        int year = new Scanner(System.in).nextInt();
                        System.out.print("Enter month of expiration date : ");
                        int month = new Scanner(System.in).nextInt();
                        if(sourceCard.getExpirationDate().getYear() == year && sourceCard.getExpirationDate().getMonth().getValue() == month){
                            System.out.print("Enter second password : ");
                            int secondPassword = new Scanner(System.in).nextInt();
                            if(sourceCard.getSecondPassword() == secondPassword){
                                double amountPlusWage = amount + .6;
                                double sourceCardCurrentBalance = sourceCard.getBalance();
                                sourceCardCurrentBalance -= amountPlusWage;
                                sourceCard.setBalance(sourceCardCurrentBalance);
                                createOrUpdate(sourceCard);
                                double destinationCardCurrentBalance = destinationCard.getBalance();
                                destinationCardCurrentBalance += amount;
                                destinationCard.setBalance(destinationCardCurrentBalance);
                                ApplicationContext.getTransactionService().newTransaction(sourceCard,destinationCardNumber,amount);
                                createOrUpdate(destinationCard);
                            }else{
                                System.out.println("Second password is incorrect");
                            }
                        }else {
                            System.out.println("the date is incorrect");
                        }
                    }else{
                        System.out.println("CVV2 is incorrect");
                    }
                }else{
                    System.out.println("You don't have enough balance");
                }
            }
        }

    }
}
