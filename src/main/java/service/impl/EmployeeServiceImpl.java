package service.impl;

import base.service.BaseServiceImpl;
import domain.Employee;
import repository.EmployeeRepository;
import service.EmployeeService;
import util.ApplicationContext;

import java.util.InputMismatchException;
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
                    //TODO create a method for employee to do his tasks
                }
            }catch (InputMismatchException exception){
                System.out.println("Wrong input");
            }
        }
    }


}
