package repository.impl;

import base.repository.BaseRepositoryImpl;
import domain.Account;
import repository.AccountRepository;

import javax.persistence.EntityManager;

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
        return entityManager.createQuery("SELECT a FROM Account a WHERE a.accountNumber =:accountNumber",Account.class).
                setParameter("accountNumber",accountNumber).getSingleResult();
    }
}
