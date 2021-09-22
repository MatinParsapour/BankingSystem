package repository.impl;

import base.repository.BaseRepositoryImpl;
import domain.CreditCard;
import domain.Transaction;
import repository.TransactionRepository;
import util.SecurityUser;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

    @Override
    public List<Transaction> findTransactionsBasedOnDate(LocalDateTime requestDate) {
        try{
            return entityManager.createQuery("SELECT t " +
                    "FROM Transaction t " +
                    "JOIN t.creditCards c " +
                    "JOIN c.account a " +
                    "JOIN a.user u " +
                    "WHERE t.date > :date " +
                    "AND u.id = :id ", Transaction.class).
                    setParameter("date",requestDate).setParameter("id", SecurityUser.getCustomer().getId()).getResultList();
        }catch (NoResultException exception){
            return null;
        }
    }
}
