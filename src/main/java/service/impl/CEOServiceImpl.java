package service.impl;

import base.service.BaseServiceImpl;
import domain.CEO;
import repository.CEORepository;
import service.CEOService;
import util.ApplicationContext;

import java.util.InputMismatchException;
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
                    //TODO create a method for ceo to see requests
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
}
