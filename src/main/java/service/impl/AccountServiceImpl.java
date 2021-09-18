package service.impl;

import base.service.BaseServiceImpl;
import domain.Account;
import repository.AccountRepository;
import service.AccountService;

public class AccountServiceImpl extends BaseServiceImpl<Account,Long, AccountRepository> implements AccountService {
    public AccountServiceImpl(AccountRepository repository) {
        super(repository);
    }
}
