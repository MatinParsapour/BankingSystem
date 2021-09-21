import util.ApplicationContext;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingSystem {
    public static void main(String[] args) {
        while(true){
            try{
                ApplicationContext.getDemonstrationMenus().mainMenu();
                int choice = new Scanner(System.in).nextInt();
                if(choice == 1){
                    //TODO create a method for CEO
                }else if (choice == 2){
                    ApplicationContext.getEmployeeService().firstMenu();
                }else if (choice == 3){
                    ApplicationContext.getCustomerService().firstMenu();
                }else if(choice == 4){
                    System.out.println("Hope to see you soon");
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
