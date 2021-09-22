package repository.impl;

import base.repository.BaseRepositoryImpl;
import domain.CreditCard;
import repository.CreditCardRepository;
import util.SecurityUser;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.InputMismatchException;

public class CreditCardRepositoryImpl extends BaseRepositoryImpl<CreditCard, Long> implements CreditCardRepository {
    public CreditCardRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<CreditCard> getEntity() {
        return CreditCard.class;
    }

    @Override
    public CreditCard findCreditCardByCardNumber(long cardNumber) {
        try{
            return entityManager.createQuery("SELECT c " +
                    "FROM CreditCard c " +
                    "JOIN c.account a " +
                    "WHERE c.cardNumber = :cardNumber " +
                    "AND a.isBlocked = false ",CreditCard.class).
                    setParameter("cardNumber",cardNumber).getSingleResult();
        }catch (NoResultException exception){
            return null;
        }
    }

    @Override
    public CreditCard findCreditCardByShebaNumber(String shebaNumberString) {
        try{
            return entityManager.createQuery("SELECT c " +
                    "FROM CreditCard c " +
                    "JOIN c.account a " +
                    "WHERE c.shebaNumber = :shebaNumber " +
                    "AND a.isBlocked = false ",CreditCard.class).
                    setParameter("shebaNumber",shebaNumberString).getSingleResult();
        }catch (NoResultException exception){
            return null;
        }
    }

    @Override
    public CreditCard findCreditCardById(long id) {
        try{
            return entityManager.createQuery("SELECT c " +
                    "FROM CreditCard c " +
                    "JOIN c.account a " +
                    "JOIN a.user u " +
                    "WHERE c.id = :id " +
                    "AND u.id = :userId " +
                    "AND a.isBlocked = false ",CreditCard.class).
                    setParameter("id",id).setParameter("userId", SecurityUser.getCustomer().getId()).getSingleResult();
        }catch (NoResultException exception){
            return null;
        }
    }
}
