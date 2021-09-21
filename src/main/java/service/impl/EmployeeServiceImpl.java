package service.impl;

import base.service.BaseServiceImpl;
import domain.Account;
import domain.CreditCard;
import domain.Employee;
import repository.EmployeeRepository;
import service.EmployeeService;
import util.ApplicationContext;
import util.SecurityUser;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl extends BaseServiceImpl<Employee,Long, EmployeeRepository> implements EmployeeService {
    public EmployeeServiceImpl(EmployeeRepository repository) {
        super(repository);
    }

    @Override
    public void firstMenu() {
        while(true){
            try{
                ApplicationContext.getDemonstrationMenus().employeeFirstMenu();
                int choice = new Scanner(System.in).nextInt();
                if(choice == 1){
                    validateEmployee();
                    break;
                }else if(choice == 2){
                    //TODO create a method for the ones who want to be employee
                }else{
                    System.out.println("Wrong input");
                }
            }catch (InputMismatchException exception){
                System.out.println("Wrong input");
            }
        }
    }

    @Override
    public void validateEmployee() {
        while(true){
            try{
                System.out.println("Enter your employee id : ");
                int employeeCode = new Scanner(System.in).nextInt();
                Employee employee = repository.findEmployeeByEmployeeCode(employeeCode);
                if(employee == null){
                    System.out.println("This code is wrong");
                    System.out.println("1.Try again 2.Back");
                    int choice = new Scanner(System.in).nextInt();
                    if(choice == 2){
                        break;
                    }
                }else{
                    System.out.println("Welcome : " + employee.getFirstName() + " " + employee.getLastName());
                    SecurityUser.setEmployee(employee);
                    employeeMenu();
                }
            }catch (InputMismatchException exception){
                System.out.println("Wrong input");
            }
        }
    }

    @Override
    public void employeeMenu() {
        while(true){
            try{
                ApplicationContext.getDemonstrationMenus().employeeMenu();
                int choice = new Scanner(System.in).nextInt();
                if(choice == 1) {
                    activeAccount();
                }else if(choice == 2){
                    break;
                }else{
                    System.out.println("Wrong input");
                }
            }catch (InputMismatchException exception){
                System.out.println("Wrong input");
            }
        }
    }

    @Override
    public void activeAccount() {
        while(true){
            try{
                List<Account> accounts = ApplicationContext.getAccountService().activeAccount();
                if(accounts.size() == 0){
                    System.out.println("You don't have any inactive account");
                    break;
                }else {
                    ApplicationContext.getDemonstrateInfos().printInActiveAccounts(accounts);
                    System.out.println("If you want to exit enter exit");
                    System.out.print("Enter id of account : ");
                    long accountId = new Scanner(System.in).nextLong();
                    Account account = ApplicationContext.getAccountService().checkId(accountId);
                    if (account == null) {
                        System.out.println("This id is incorrect");
                    } else {
                        CreditCard creditCard = new CreditCard(account.getBankBranch().getBankName(),
                                account.getFirstName() + " " + account.getLastName(),
                                ApplicationContext.getCreditCardService().createCreditCardNumber(),
                                ApplicationContext.getCreditCardService().createCVV2(),
                                LocalDate.now().plusYears(5L).minusMonths(5L),
                                account.getBankBranch().getBranchCode(),
                                ApplicationContext.getCreditCardService().createShebaNumber(),
                                ApplicationContext.getCreditCardService().createFirstPassword());
                        ApplicationContext.getCreditCardService().createCreditCard(creditCard);
                        account.setActive(true);
                        account.setCreditCard(creditCard);
                        account.setJoinDate(LocalDateTime.now());
                        ApplicationContext.getAccountService().changeIntoAccount(account);
                        System.out.println("This account successfully activated");
                    }
                }
            }catch (InputMismatchException exception){
                break;
            }
        }
    }
}
