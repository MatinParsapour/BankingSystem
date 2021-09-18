package repository.impl;

import base.repository.BaseRepositoryImpl;
import domain.CreditCard;
import repository.CreditCardRepository;

import javax.persistence.EntityManager;

public class CreditCardRepositoryImpl extends BaseRepositoryImpl<CreditCard, Long> implements CreditCardRepository {
    public CreditCardRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<CreditCard> getEntity() {
        return CreditCard.class;
    }
}
