package service.impl;

import base.service.BaseServiceImpl;
import domain.Account;
import repository.AccountRepository;

public class AccountServiceImpl extends BaseServiceImpl<Account,Long, AccountRepository> {
    public AccountServiceImpl(AccountRepository repository) {
        super(repository);
    }
}
