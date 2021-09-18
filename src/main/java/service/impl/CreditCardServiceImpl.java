package service.impl;

import base.service.BaseServiceImpl;
import domain.CreditCard;
import repository.CreditCardRepository;

public class CreditCardServiceImpl extends BaseServiceImpl<CreditCard,Long, CreditCardRepository> {
    public CreditCardServiceImpl(CreditCardRepository repository) {
        super(repository);
    }
}
