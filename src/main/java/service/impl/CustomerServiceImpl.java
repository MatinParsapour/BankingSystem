package service.impl;

import base.service.BaseServiceImpl;
import domain.Customer;
import repository.CustomerRepository;
import service.CustomerService;
import util.ApplicationContext;

import java.util.InputMismatchException;
import java.util.Scanner;

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
                    //TODO create a method for customer to enter
                }else if(choice == 2){
                    //TODO create a method for customer to fill the form
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
}
