package service;

import base.service.BaseService;
import domain.CreditCard;

public interface CreditCardService extends BaseService<CreditCard, Long> {

    long createCreditCardNumber();

    int createCVV2();

    String createShebaNumber();

    int createFirstPassword();

    void createCreditCard(CreditCard creditCard);

    void cardToCard();

    void changeFirstPassword();
}
