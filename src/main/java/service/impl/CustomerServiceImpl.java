package service.impl;

import base.service.BaseServiceImpl;
import domain.Account;
import domain.Customer;
import repository.CustomerRepository;
import service.CustomerService;
import util.ApplicationContext;
import util.SecurityUser;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerServiceImpl extends BaseServiceImpl<Customer,Long, CustomerRepository> implements CustomerService {
    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);
    }

    @Override
    public void firstMenu() {
        while(true){
            try{
                ApplicationContext.getDemonstrationMenus().customerFirstMenu();
                int choice = new Scanner(System.in).nextInt();
                if(choice == 1){
                    enter();
                    break;
                }else if(choice == 2){
                    fillTheForm();
                    break;
                }else if(choice == 3){
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
    public void fillTheForm() {
        Customer customer = new Customer(firstName(),lastName(),email(null),
                phoneNumber(null),nationalCode(),birthday(),
                userName(),password());
        createOrUpdate(customer);
        enter();
    }

    @Override
    public void enter() {
        System.out.println(" enter ");
        while (true) {
            try {
                System.out.print("Username : ");
                String userName = new Scanner(System.in).nextLine();
                System.out.print("Password : ");
                String password = new Scanner(System.in).next();
                Customer customer = repository.findUserByUserNameAndPassword(userName, password);
                if (customer == null) {
                    System.out.println("Username or Password is incorrect\nor maybe you haven't sign up yet");
                    System.out.println("1.Try again                   2.fill the form");
                    int choice = new Scanner(System.in).nextInt();
                    if (choice == 2) {
                        fillTheForm();
                        break;
                    }
                } else {
                    SecurityUser.setCustomer(customer);
                    customerMenu();
                    break;
                }
            } catch (InputMismatchException exception) {
                System.out.println("Invalid entry");
                System.out.println("Try again");
            }
        }
    }

    @Override
    public void customerMenu() {
        while(true){
            try{
                ApplicationContext.getDemonstrationMenus().customerMenu();
                int choice = new Scanner(System.in).nextInt();
                if(choice == 1){
                    //TODO create a method for customer to see transactions history
                }else if(choice == 2){
                    ApplicationContext.getAccountService().openAccount();
                }else if (choice == 3){
                    yourCards();
                }else if (choice == 4){
                    int nextMove = logOut();
                    if(nextMove == 1){
                        break;
                    }
                }else if(choice == 5){
                    break;
                }else{
                    System.out.println("Wrong input");
                }
            }catch (InputMismatchException exception){
                System.out.println("Wrong input");
            }
        }
    }

    private String nationalCode() {
        while (true) {
            try {
                Pattern pattern = Pattern.compile("[0-9]{10}");
                System.out.print("National code : ");
                String nationalCode = new Scanner(System.in).next();
                Matcher matcher = pattern.matcher(nationalCode);
                while (!matcher.matches()) {
                    System.out.println("You should enter a 10-digit for national code");
                    System.out.println("Try again");
                    nationalCode = new Scanner(System.in).next();
                    matcher = pattern.matcher(nationalCode);
                }
                System.out.println("1.Acceptable         2.Unacceptable");
                int choice = new Scanner(System.in).nextInt();
                if (choice == 1) {
                    return nationalCode;
                } else {
                    System.out.println("Now try again");
                }
            } catch (InputMismatchException exception) {
                System.out.println("You should enter number");
                System.out.println("Start over");
            }
        }
    }

    private String firstName() {
        while (true) {
            try {
                System.out.print("Firstname : ");
                String firstName = new Scanner(System.in).nextLine();
                System.out.println("1.Acceptable        2.Unacceptable");
                int choice = new Scanner(System.in).nextInt();
                if (choice == 1) {
                    return firstName;
                }
            } catch (InputMismatchException exception) {
                System.out.println("Invalid entry");
                System.out.println("Try again");
            }
        }
    }

    private String lastName() {
        while (true) {
            try {
                System.out.print("Lastname : ");
                String lastName = new Scanner(System.in).nextLine();
                System.out.println("1.Acceptable        2.Unacceptable");
                int choice = new Scanner(System.in).nextInt();
                if (choice == 1) {
                    return lastName;
                }
            } catch (InputMismatchException exception) {
                System.out.println("Invalid entry");
                System.out.println("Try again");
            }
        }
    }

    private String userName() {
        while (true) {
            try {
                System.out.print("Username : ");
                String userName = new Scanner(System.in).nextLine();
                Customer customer = repository.findUserByUserName(userName);
                if (customer == null) {
                    System.out.println("1.Acceptable         2.Unacceptable");
                    int choice = new Scanner(System.in).nextInt();
                    if (choice == 1) {
                        return userName;
                    }
                } else {
                    System.out.println("This username already exist");
                    System.out.println("Choose another username");
                }
            } catch (InputMismatchException exception) {
                System.out.println("Invalid entry");
                System.out.println("Try again");
            }
        }
    }

    private String password() {
        while (true) {
            try {
                Pattern pattern = Pattern.compile("[0-9]{10}");
                System.out.print("Password : ");
                String password = new Scanner(System.in).next();
                Matcher matcher = pattern.matcher(password);
                while (!matcher.matches()) {
                    System.out.println("You should enter a 10-digit password");
                    System.out.println("Try again");
                    password = new Scanner(System.in).next();
                    matcher = pattern.matcher(password);
                }
                System.out.println("1.Acceptable         2.Unacceptable");
                int choice = new Scanner(System.in).nextInt();
                if (choice == 1) {
                    return password;
                } else {
                    System.out.println("Now try again");
                }
            } catch (InputMismatchException exception) {
                System.out.println("You should enter number");
                System.out.println("Start over");
            }
        }
    }

    private String email(String currentEmail) {
        Pattern validEmail = Pattern.compile("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[\\a-zA-Z]{2,6}");
        System.out.print("Email : ");
        String email = new Scanner(System.in).next();
        Matcher machEmail = validEmail.matcher(email);
        while (!machEmail.matches()) {
            System.out.println("this is not a valid email");
            System.out.println("Try again");
            email = new Scanner(System.in).next();
            machEmail = validEmail.matcher(email);
        }
        return validationEmail(email, currentEmail);
    }

    private String validationEmail(String email, String currentEmail) {
        while (true) {
            try {
                Random random = new Random();
                int validationCode = random.nextInt(1000000);
                System.out.println("Please wait, we are sending a validation code to " + email);
                for (int waiting = 0; waiting <= 5; waiting++) {
                    Thread.sleep(1000);
                    System.out.print("" + "🟩");
                }
                System.out.println();
                System.out.println("This is your validation code : " + validationCode);
                System.out.print("Write your validation code : ");
                int validate = new Scanner(System.in).nextInt();
                if (validate == validationCode) {
                    System.out.print("Please wait, we are syncing data");
                    for (int delay = 0; delay <= 5; delay++) {
                        Thread.sleep(1000);
                        System.out.print(" .");
                    }
                    System.out.println();
                    System.out.println("Now you are good to go");
                    System.out.println("Your email is valid");
                    return email;
                } else {
                    System.out.println("Invalid code");
                    System.out.println("1.Send another code       2.back to main menu");
                    int choice = new Scanner(System.in).nextInt();
                    if (choice == 2) {
                        return currentEmail;
                    }
                }
            } catch (InputMismatchException | InterruptedException exception) {
                System.out.println("Something went wrong");
                System.out.println("Try again");
            }
        }
    }

    private String phoneNumber(String currentPhoneNumber) {
        Pattern validPhoneNumber = Pattern.compile("[0][9][0-9]{9}");
        System.out.println("Enter your full phone number");
        String phoneNumber = new Scanner(System.in).next();
        Matcher matchPhoneNumber = validPhoneNumber.matcher(phoneNumber);
        while (!matchPhoneNumber.matches()) {
            System.out.println("This is not a valid phone number");
            System.out.println("Try again");
            phoneNumber = new Scanner(System.in).next();
            matchPhoneNumber = validPhoneNumber.matcher(phoneNumber);
        }
        return validationPhoneNumber(phoneNumber, currentPhoneNumber);
    }

    private String validationPhoneNumber(String phoneNumber, String number) {
        while (true) {
            try {
                Random random = new Random();
                int validationCode = random.nextInt(1000000);
                System.out.println("Please wait, we are sending a validation code to " + phoneNumber);
                for (int waiting = 0; waiting <= 5; waiting++) {
                    Thread.sleep(1000);
                    System.out.print("" + "🟩");
                }
                System.out.println("\nThis is your validation code : " + validationCode);
                System.out.print("Write your validation code : ");
                int validate = new Scanner(System.in).nextInt();
                if (validate == validationCode) {
                    System.out.println("Your phone is valid");
                    return phoneNumber;
                } else {
                    System.out.println("Invalid code");
                    System.out.println("1.Send another code       2.back to main menu");
                    int choice = new Scanner(System.in).nextInt();
                    if (choice == 2) {
                        return number;
                    }
                }
            } catch (InputMismatchException | InterruptedException exception) {
                System.out.println("Something went wrong");
                System.out.println("Try again");
            }
        }
    }

    private LocalDate birthday() {
        System.out.println("Birthday");
        LocalDate date;
        while (true) {
            try {
                System.out.print("Year : ");
                int year = new Scanner(System.in).nextInt();
                int month = month();
                int day = day();
                date = LocalDate.of(year, month, day);
                if (LocalDate.now().isAfter(date)) {
                    break;
                } else {
                    System.out.println("This is not a valid date for your birthday");
                    System.out.println("Try again");
                }
            } catch (InputMismatchException exception) {
                System.out.println("You should enter number");
                System.out.println("Try again");
            }
        }
        return date;
    }

    private int day() {
        while (true) {
            try {
                System.out.print("Day : ");
                int day = new Scanner(System.in).nextInt();
                while (day < 1 || day > 31) {
                    System.out.println("This is not a valid number for day");
                    System.out.println("Try again");
                    day = new Scanner(System.in).nextInt();
                }
                return day;
            } catch (InputMismatchException exception) {
                System.out.println("You should enter number");
                System.out.println("Try again");
            }
        }
    }

    private int month() {
        while (true) {
            try {
                System.out.print("Month : ");
                int month = new Scanner(System.in).nextInt();
                while (month < 1 || month > 12) {
                    System.out.println("This is not a valid number for month");
                    System.out.println("Try again");
                    month = new Scanner(System.in).nextInt();
                }
                return month;
            } catch (InputMismatchException exception) {
                System.out.println("You should enter number");
                System.out.println("Try again");
            }
        }
    }

    @Override
    public int logOut() {
        while(true){
            try{
                System.out.println("Are you sure");
                System.out.println("1.Yes   2.NO");
                int choice = new Scanner(System.in).nextInt();
                if(choice == 1){
                    delete(SecurityUser.getCustomer());
                    return 1;
                }else if(choice == 2){
                    return 2;
                }else{
                    System.out.println("Choose between options");
                }
            }catch (InputMismatchException exception){
                System.out.println("Invalid entry");
            }
        }
    }

    @Override
    public void yourCards() {
        while(true){
            List<Account> accounts = ApplicationContext.getAccountRepositoryImpl().findCustomerAccounts();
            if(accounts.size() == 0){
                System.out.println("You don't have any account yet");
                break;
            }else{
                try{
                    ApplicationContext.getDemonstrateInfos().printUserAccounts(accounts);
                    ApplicationContext.getDemonstrationMenus().customerCardsMenu();
                    int choice = new Scanner(System.in).nextInt();
                    if(choice == 1){
                        ApplicationContext.getCreditCardService().cardToCard();
                    }else if (choice == 2){
                        //TODO create a method for customer to close his/her account
                    }else if (choice == 3){
                        //TODO create a method for customer to change his/her first password;
                    }else if (choice == 4){
                        //TODO create a method for customer to change or set his/her second password
                    }else if(choice == 5){
                        break;
                    }else{
                        System.out.println("Wrong input");
                    }
                }catch (InputMismatchException exception){
                    System.out.println("Wrong input");
                }
            }
        }
    }


}
