package service.impl;

import base.service.BaseServiceImpl;
import domain.CreditCard;
import repository.CreditCardRepository;
import service.CreditCardService;

import java.util.Random;

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
}
