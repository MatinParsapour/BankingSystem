package service.impl;

import base.service.BaseServiceImpl;
import domain.CEO;
import domain.Employee;
import repository.CEORepository;
import service.CEOService;
import util.ApplicationContext;
import util.SecurityUser;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CEOServiceImpl extends BaseServiceImpl<CEO,Long, CEORepository> implements CEOService {
    public CEOServiceImpl(CEORepository repository) {
        super(repository);
    }

    @Override
    public void firstMenu() {
        try{
            System.out.print("CEO id : ");
            int cEOid = new Scanner(System.in).nextInt();
            CEO ceo = repository.findCEOByCEOId(cEOid);
            if(ceo == null){
                System.out.println("The code is wrong");
            }else{
                SecurityUser.setCeo(ceo);
                mainMenu();
            }
        }catch (InputMismatchException exception){
            System.out.println("Wrong input");
        }
    }

    private void mainMenu() {
        while(true){
            try{
                ApplicationContext.getDemonstrationMenus().cEOMainMenu();
                int choice = new Scanner(System.in).nextInt();
                if(choice == 1){
                    requests();
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

    private void requests() {
        List<Employee> employeeList = ApplicationContext.getEmployeeService().requests();
        if(employeeList.size() == 0){
            System.out.println("You don't have any request");
        }else{
            ApplicationContext.getDemonstrateInfos().printRequestsForBank(employeeList);
            ApplicationContext.getDemonstrationMenus().requestMenu();
            int choice = new Scanner(System.in).nextInt();
            if(choice == 1){
                acceptRequest();
            }else if(choice == 2){
                rejectRequest();
            }else{
                System.out.println("Wrong input");
            }
        }
    }

    private void rejectRequest() {
        try{
            System.out.println("id : ");
            long id = new Scanner(System.in).nextInt();
            Employee employee = ApplicationContext.getEmployeeService().returnEmployee(id);
            if(employee == null){
                System.out.println("Wrong id");
            }else{
                employee.setIsEmployee(false);
                ApplicationContext.getEmployeeService().createOrUpdate(employee);
                System.out.println("Employee rejected");
            }
        }catch (InputMismatchException exception){
            System.out.println("Wrong input");
        }
    }

    private void acceptRequest() {
        try{
            System.out.println("id : ");
            long id = new Scanner(System.in).nextInt();
            Employee employee = ApplicationContext.getEmployeeService().returnEmployee(id);
            if(employee == null){
                System.out.println("Wrong id");
            }else{
                employee.setEmployeeCode(ApplicationContext.getEmployeeService().generateEmployeeCode());
                employee.setIsEmployee(true);
                ApplicationContext.getEmployeeService().createOrUpdate(employee);
                System.out.println("Employee accepted");
            }
        }catch (InputMismatchException exception){
            System.out.println("Wrong input");
        }
    }
}
