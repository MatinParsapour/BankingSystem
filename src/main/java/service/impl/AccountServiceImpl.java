package service.impl;

import base.service.BaseServiceImpl;
import domain.Account;
import domain.BankBranch;
import domain.CreditCard;
import repository.AccountRepository;
import service.AccountService;
import util.ApplicationContext;
import util.SecurityUser;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AccountServiceImpl extends BaseServiceImpl<Account,Long, AccountRepository> implements AccountService {
    public AccountServiceImpl(AccountRepository repository) {
        super(repository);
    }

    @Override
    public void openAccount() {
        while (true){
            try{

                BankBranch bankBranch = ApplicationContext.getBankBranchService().chooseBank();
                if(bankBranch == null){
                    System.out.println("There's no such bank");
                    System.out.println("1.Try again   2.Back");
                    int choice = new Scanner(System.in).nextInt();
                    if(choice == 2){
                        break;
                    }
                }else{
                    System.out.println("Enter your father name : ");
                    String customerFatherName = new Scanner(System.in).nextLine();
                    Account account = new Account(SecurityUser.getCustomer().getFirstName(),
                            SecurityUser.getCustomer().getLastName(),
                            SecurityUser.getCustomer().getNationalCode(),
                            SecurityUser.getCustomer().getBirthDate(),
                            customerFatherName,
                            bankBranch, SecurityUser.getCustomer());
                    createOrUpdate(account);
                    System.out.println("Your account's been created");
                    System.out.println("Wait for employee to active your account");
                    break;
                }
            }catch (InputMismatchException exception){
                System.out.println("Wrong input");
            }
        }
    }

    @Override
    public List<Account> activeAccount() {
        return repository.findAccountsForEmployee();
    }

    @Override
    public Account checkId(Long id) {
        return repository.findAccountById(id);
    }

    @Override
    public void changeIntoAccount(Account account) {
        createOrUpdate(account);
    }

    @Override
    public List<Account> findCustomerAccounts() {
        return repository.findCustomerAccounts();
    }

    @Override
    public long createAccountNumber() {
        Random random = new Random();
        String accountNumberString ="";
        long accountNumber = 0;
        while(true){
            accountNumberString = "";
            for(int i = 0 ; i<= 10; i++){
                accountNumberString += random.nextInt(9);
            }
            accountNumber = Long.parseLong(accountNumberString);
            Account account = repository.findAccountByAccountNumber(accountNumber);
            if(account == null){
                return accountNumber;
            }
        }
    }
}
