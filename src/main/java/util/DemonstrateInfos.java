package util;

import domain.Account;
import domain.BankBranch;

import java.util.List;

public class DemonstrateInfos {
    public void demonstrateBanks(List<BankBranch> banks){
        int bankNameSize = 0;
        for(BankBranch bankBranch : banks){
            if(bankBranch.getBankName().length() > bankNameSize){
                bankNameSize = bankBranch.getBankName().length();
            }
        }
        int bankCodeSize = 4;
        int cover = printBankInfoHeader(bankNameSize, bankCodeSize);

        printBankInfoFooter(banks, bankNameSize, bankCodeSize, cover);
    }

    private int printBankInfoHeader(int bankNameSize, int bankCodeSize) {
        int cover = bankCodeSize + bankNameSize + 7;
        System.out.print("+");
        for(int i = 0 ; i < cover ; i++){
            System.out.print("-");
        }
        System.out.println("+");

        System.out.format("| %" + (-(bankNameSize + 2)) + "s" , "name");
        System.out.format("| %" + (-(bankCodeSize + 2)) + "s|\n" , "code");

        System.out.print("+");
        for(int i = 0 ; i < cover ; i++){
            System.out.print("-");
        }
        System.out.println("+");
        return cover;
    }

    private void printBankInfoFooter(List<BankBranch> banks, int bankNameSize, int bankCodeSize, int cover) {
        for(BankBranch bankBranch : banks){
            System.out.format("| %" + (-(bankNameSize + 2)) + "s" , bankBranch.getBankName());
            System.out.format("| %" + (-(bankCodeSize + 2)) + "s|\n" , bankBranch.getBranchCode());
        }
        System.out.print("+");
        for(int i = 0; i < cover; i++){
            System.out.print("-");
        }
        System.out.println("+");
    }

    public void printInActiveAccounts(List<Account> activeAccount) {
        int idSize = 10;
        int birthDaySize = 10;
        int firstNameSize = 0;
        int lastNameSize = 0;
        int natinalCodeSize = 10;
        int fatherNameSize = 0;
        for(Account account : activeAccount){
            if(account.getFirstName().length() > firstNameSize){
                firstNameSize = account.getFirstName().length();
            }
            if(account.getLastName().length() > lastNameSize){
                lastNameSize = account.getLastName().length();
            }
            if(account.getFatherName().length() > fatherNameSize){
                fatherNameSize = account.getFatherName().length();
            }
        }
        int cover = idSize + birthDaySize + firstNameSize + lastNameSize + natinalCodeSize + fatherNameSize + 42;

        System.out.print("+");
        for(int i = 0 ; i < cover ; i++){
            System.out.print("-");
        }
        System.out.println("+");

        System.out.format("| %" + (-(idSize)) + "s" ,"id");
        System.out.format("| %" + (-(firstNameSize + 8)) + "s" ,"firstname");
        System.out.format("| %" + (-(lastNameSize + 4)) + "s" ,"lastname");
        System.out.format("| %" + (-(fatherNameSize + 9)) + "s" ,"fathername");
        System.out.format("| %" + (-(birthDaySize + 4)) + "s" ,"birthday");
        System.out.format("| %" + (-(natinalCodeSize + 6)) + "s|\n" ,"nationalcode");


        System.out.print("+");
        for(int i = 0 ; i < cover ; i++){
            System.out.print("-");
        }
        System.out.println("+");

        for(Account account : activeAccount){
            System.out.format("| %" + (-(idSize)) + "s" ,account.getId());
            System.out.format("| %" + (-(firstNameSize + 8)) + "s" ,account.getFirstName());
            System.out.format("| %" + (-(lastNameSize + 4)) + "s" ,account.getLastName());
            System.out.format("| %" + (-(fatherNameSize + 9)) + "s" ,account.getFatherName());
            System.out.format("| %" + (-(birthDaySize + 4)) + "s" ,account.getBirthDate());
            System.out.format("| %" + (-(natinalCodeSize + 6)) + "s|\n" ,account.getNationalCode());
        }


        System.out.print("+");
        for(int i = 0 ; i < cover ; i++){
            System.out.print("-");
        }
        System.out.println("+");
    }
}
