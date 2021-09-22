package repository.impl;

import base.repository.BaseRepositoryImpl;
import domain.CreditCard;
import domain.Transaction;
import repository.TransactionRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class TransactionRepositoryImpl extends BaseRepositoryImpl<Transaction, Long> implements TransactionRepository {
    public TransactionRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Transaction> getEntity() {
        return Transaction.class;
    }

    @Override
    public Transaction findTransactionByTrackingNo(int trackingNo) {
        try{
            return entityManager.createQuery("SELECT t " +
                    "FROM Transaction t " +
                    "WHERE t.trackingNo = :trackingNo ", Transaction.class).
                    setParameter("trackingNo",trackingNo).getSingleResult();
        }catch (NoResultException exception){
            return null;
        }
    }

    @Override
    public Transaction findTransactionByReferenceNo(long referenceNo) {
        try{
            return entityManager.createQuery("SELECT t " +
                    "FROM Transaction t " +
                    "WHERE t.referenceNo = :referenceNo ", Transaction.class).
                    setParameter("referenceNo",referenceNo).getSingleResult();
        }catch (NoResultException exception){
            return null;
        }
    }
}
