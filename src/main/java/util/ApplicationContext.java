package util;

import repository.*;
import repository.impl.*;
import service.*;
import service.impl.*;

import javax.persistence.EntityManager;

public class ApplicationContext {

    private static final AccountRepository accountRepository;
    private static final BankBranchRepository bankBranchRepository;
    private static final CEORepository cEORepository;
    private static final CreditCardRepository creditCardRepository;
    private static final CustomerRepository customerRepository;
    private static final EmployeeRepository employeeRepository;
    private static final TransactionRepository transactionRepository;
    private static final UserRepository userRepository;

    private static final AccountServiceImpl accountService;
    private static final BankBranchServiceImpl bankBranchService;
    private static final CEOServiceImpl cEOService;
    private static final CreditCardServiceImpl creditCardService;
    private static final CustomerServiceImpl customerService;
    private static final EmployeeServiceImpl employeeService;
    private static final TransactionServiceImpl transactionService;
    private static final UserServiceImpl userService;
    static {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
        accountRepository = new AccountRepositoryImpl(entityManager);
        bankBranchRepository = new BankBranchRepositoryImpl(entityManager);
        cEORepository = new CEORepositoryImpl(entityManager);
        creditCardRepository = new CreditCardRepositoryImpl(entityManager);
        customerRepository = new CustomerRepositoryImpl(entityManager);
        employeeRepository = new EmployeeRepositoryImpl(entityManager);
        transactionRepository = new TransactionRepositoryImpl(entityManager);
        userRepository = new UserRepositoryImpl(entityManager);

        accountService = new AccountServiceImpl(accountRepository);
        bankBranchService = new BankBranchServiceImpl(bankBranchRepository);
        cEOService = new CEOServiceImpl(cEORepository);
        creditCardService = new CreditCardServiceImpl(creditCardRepository);
        customerService = new CustomerServiceImpl(customerRepository);
        employeeService = new EmployeeServiceImpl(employeeRepository);
        transactionService = new TransactionServiceImpl(transactionRepository);
        userService = new UserServiceImpl(userRepository);
    }

    public static AccountServiceImpl getAccountService(){return accountService;}
    public static CEOServiceImpl getCEOService(){return cEOService;}
    public static CreditCardServiceImpl getCreditCardService(){return creditCardService;}
    public static BankBranchServiceImpl getBankBranchService(){return bankBranchService;}
    public static UserServiceImpl getUserService(){return userService;}
    public static CustomerServiceImpl getCustomerService(){return customerService;}
    public static EmployeeServiceImpl getEmployeeService(){return employeeService;}
    public static TransactionServiceImpl getTransactionService(){return transactionService;}
}
