package repository.impl;

import base.repository.BaseRepositoryImpl;
import domain.Account;
import domain.CreditCard;
import repository.AccountRepository;
import util.SecurityUser;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.InputMismatchException;
import java.util.List;

public class AccountRepositoryImpl extends BaseRepositoryImpl<Account, Long> implements AccountRepository {
    public AccountRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Account> getEntity() {
        return Account.class;
    }

    @Override
    public Account existsByAccountNumber(int accountNumber) {
        try{
            return entityManager.createQuery("SELECT a FROM Account a WHERE a.accountNumber =:accountNumber AND a.isBlocked = false ",Account.class).
                    setParameter("accountNumber",accountNumber).getSingleResult();
        }catch (NoResultException exception){
            return null;
        }
    }

    @Override
    public List<Account> findAccountsForEmployee() {
        try{
            return entityManager.createQuery("SELECT a " +
                    "FROM Account a " +
                    "JOIN a.bankBranch b " +
                    "WHERE b.id = :id " +
                    "AND a.isBlocked = false " +
                    "AND a.isActive = false",Account.class)
                    .setParameter("id", SecurityUser.getEmployee().getBankBranch().getId())
                    .getResultList();
        }catch (NoResultException exception){
            return null;
        }
    }

    @Override
    public Account findAccountById(Long id) {
        try{
            return entityManager.createQuery("SELECT a " +
                    "FROM Account a " +
                    "JOIN a.bankBranch b " +
                    "WHERE a.id = :id " +
                    "AND a.isBlocked = false " +
                    "AND b.id = :bankId",Account.class).setParameter("id",id).
                    setParameter("bankId",SecurityUser.getEmployee().getBankBranch().getId())
                    .getSingleResult();
        }catch (NoResultException exception){
            return null;
        }
    }

    @Override
    public List<Account> findCustomerAccounts() {
        try{
            return entityManager.createQuery("SELECT a " +
                    "FROM Account a " +
                    "WHERE a.user = :user " +
                    "AND a.isBlocked = false",Account.class).setParameter("user",SecurityUser.getCustomer()).getResultList();
        }catch (NoResultException exception){
            return null;
        }
    }

    @Override
    public Account findAccountByAccountNumber(long accountNumber) {
        try{
            return entityManager.createQuery("SELECT a " +
                    "FROM Account a " +
                    "WHERE a.accountNumber = :accountNumber " +
                    "AND a.isBlocked = false", Account.class).
                    setParameter("accountNumber",accountNumber).getSingleResult();
        }catch (NoResultException exception){
            return null;
        }
    }

    @Override
    public Account findAccountByIdToDelete(long id) {
        try{
            return entityManager.createQuery("SELECT a " +
                    "FROM Account a " +
                    "WHERE a.id = :id " +
                    "AND a.isBlocked = false "
                    ,Account.class).setParameter("id",id).getSingleResult();
        }catch (NoResultException exception){
            return null;
        }
    }
}
