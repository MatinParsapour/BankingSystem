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

        printHeaderOfInActiveAccounts(idSize, birthDaySize, firstNameSize, lastNameSize, natinalCodeSize, fatherNameSize, cover);

        printInformationOfActiveAccounts(activeAccount, idSize, birthDaySize, firstNameSize, lastNameSize, natinalCodeSize, fatherNameSize, cover);
    }

    private void printInformationOfActiveAccounts(List<Account> activeAccount, int idSize, int birthDaySize, int firstNameSize, int lastNameSize, int natinalCodeSize, int fatherNameSize, int cover) {
        for(Account account : activeAccount){
            System.out.format("| %" + (-idSize) + "s" ,account.getId());
            System.out.format("| %" + (-(firstNameSize + 8)) + "s" ,account.getFirstName());
            System.out.format("| %" + (-(lastNameSize + 4)) + "s" ,account.getLastName());
            System.out.format("| %" + (-(fatherNameSize + 9)) + "s" ,account.getFatherName());
            System.out.format("| %" + (-(birthDaySize + 4)) + "s" ,account.getBirthDate());
            System.out.format("| %" + (-(natinalCodeSize + 6)) + "s|\n" ,account.getNationalCode());
        }


        System.out.print("+");
        for(int i = 0; i < cover; i++){
            System.out.print("-");
        }
        System.out.println("+");
    }

    private void printHeaderOfInActiveAccounts(int idSize, int birthDaySize, int firstNameSize, int lastNameSize, int natinalCodeSize, int fatherNameSize, int cover) {
        System.out.print("+");
        for(int i = 0; i < cover; i++){
            System.out.print("-");
        }
        System.out.println("+");

        System.out.format("| %" + (-idSize) + "s" ,"id");
        System.out.format("| %" + (-(firstNameSize + 8)) + "s" ,"firstname");
        System.out.format("| %" + (-(lastNameSize + 4)) + "s" ,"lastname");
        System.out.format("| %" + (-(fatherNameSize + 9)) + "s" ,"fathername");
        System.out.format("| %" + (-(birthDaySize + 4)) + "s" ,"birthday");
        System.out.format("| %" + (-(natinalCodeSize + 6)) + "s|\n" ,"nationalcode");


        System.out.print("+");
        for(int i = 0; i < cover; i++){
            System.out.print("-");
        }
        System.out.println("+");
    }

    public void printUserAccounts(List<Account> accounts){
        int idSize = 5;
        int cardNumberSize = 16;
        int bankNameSize = 0;
        int bankCodeSize = 4;
        int cVV2Size = 4;
        int expirationDateSize = 10;
        int accountNumberSize = 9;
        int firstPasswordSize = 4;
        int secondPasswordSize = 6;
        int balanceSize = 15;

        for(Account account : accounts){
            if(account.getBankBranch().getBankName().length() > balanceSize){
                bankNameSize = account.getBankBranch().getBankName().length();
            }
        }

        int cover = idSize + cardNumberSize + bankNameSize + bankCodeSize + cVV2Size + expirationDateSize + accountNumberSize + firstPasswordSize + secondPasswordSize + balanceSize + 99;

        System.out.print("+");
        for(int i = 0 ; i < cover ; i++){
            System.out.print("-");
        }
        System.out.println("+");

        System.out.format("| %" + (-(idSize + 5)) + "s" , "id");
        System.out.format("| %" + (-(cardNumberSize + 5)) + "s" , "cardnumber");
        System.out.format("| %" + (-(bankNameSize + 15)) + "s" , "bankname");
        System.out.format("| %" + (-(bankCodeSize + 5)) + "s" , "brankcode");
        System.out.format("| %" + (-(cVV2Size + 5)) + "s" , "cvv2");
        System.out.format("| %" + (-(expirationDateSize + 5)) + "s" , "expirationdate");
        System.out.format("| %" + (-(accountNumberSize + 15)) + "s" , "accountnumber");
        System.out.format("| %" + (-(firstPasswordSize + 10)) + "s" , "firstpassword");
        System.out.format("| %" + (-(secondPasswordSize + 10)) + "s" , "secondpassword");
        System.out.format("| %" + (-(balanceSize + 5)) + "s| \n" , "balance");


        System.out.print("+");
        for(int i = 0 ; i < cover ; i++){
            System.out.print("-");
        }
        System.out.println("+");

        for(Account account : accounts){
            System.out.format("| %" + (-(idSize + 5)) + "s" , account.getCreditCard().getId());
            System.out.format("| %" + (-(cardNumberSize + 5)) + "s" , account.getCreditCard().getCardNumber());
            System.out.format("| %" + (-(bankNameSize + 15)) + "s" , account.getBankBranch().getBankName());
            System.out.format("| %" + (-(bankCodeSize + 5)) + "s" , account.getBankBranch().getBranchCode());
            System.out.format("| %" + (-(cVV2Size + 5)) + "s" , account.getCreditCard().getCVV2());
            System.out.format("| %" + (-(expirationDateSize + 5)) + "s" , account.getCreditCard().getExpirationDate());
            System.out.format("| %" + (-(accountNumberSize + 15)) + "s" , account.getAccountNumber());
            System.out.format("| %" + (-(firstPasswordSize + 10)) + "s" , account.getCreditCard().getFirstPassword());
            System.out.format("| %" + (-(secondPasswordSize + 10)) + "s" , account.getCreditCard().getSecondPassword());
            System.out.format("| %" + (-(balanceSize + 5)) + "s|\n" , account.getCreditCard().getBalance());
        }


        System.out.print("+");
        for(int i = 0 ; i < cover ; i++){
            System.out.print("-");
        }
        System.out.println("+");
    }

}
