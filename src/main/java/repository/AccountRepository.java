package repository;

import base.repository.BaseRepository;
import domain.Account;

import java.util.List;

public interface AccountRepository extends BaseRepository<Account,Long> {

    Account existsByAccountNumber(int accountNumber);

    List<Account> findAccountsForEmployee();

    Account findAccountById(Long id);

    List<Account> findCustomerAccounts();

    Account findAccountByAccountNumber(long accountNumber);
}
