package service.impl;

import base.service.BaseServiceImpl;
import domain.Account;
import domain.BankBranch;
import repository.AccountRepository;
import service.AccountService;
import util.ApplicationContext;
import util.SecurityCustomer;

import java.security.Security;
import java.util.InputMismatchException;
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
                    Account account = new Account(SecurityCustomer.getCustomer().getFirstName(),
                            SecurityCustomer.getCustomer().getLastName(),
                            SecurityCustomer.getCustomer().getNationalCode(),
                            SecurityCustomer.getCustomer().getBirthDate(),
                            customerFatherName,
                            bankBranch,SecurityCustomer.getCustomer());
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
}
