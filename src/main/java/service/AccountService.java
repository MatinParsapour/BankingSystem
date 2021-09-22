package service;

import base.service.BaseService;
import domain.Account;

import java.util.List;

public interface AccountService extends BaseService<Account,Long> {

    void openAccount();

    List<Account> activeAccount();

    Account checkId(Long id);

    void changeIntoAccount(Account account);

    List<Account> findCustomerAccounts();

    long createAccountNumber();
}
