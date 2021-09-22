package util;

import domain.Account;
import domain.BankBranch;
import domain.Employee;
import domain.Transaction;

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


        printUserAccountsHeader(idSize, cardNumberSize, bankNameSize, bankCodeSize, cVV2Size, expirationDateSize, accountNumberSize, firstPasswordSize, secondPasswordSize, balanceSize, cover);

        printUserAccountsFooter(accounts, idSize, cardNumberSize, bankNameSize, bankCodeSize, cVV2Size, expirationDateSize, accountNumberSize, firstPasswordSize, secondPasswordSize, balanceSize, cover);
    }

    private void printUserAccountsFooter(List<Account> accounts, int idSize, int cardNumberSize, int bankNameSize, int bankCodeSize, int cVV2Size, int expirationDateSize, int accountNumberSize, int firstPasswordSize, int secondPasswordSize, int balanceSize, int cover) {
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
        for(int i = 0; i < cover; i++){
            System.out.print("-");
        }
        System.out.println("+");
    }

    private void printUserAccountsHeader(int idSize, int cardNumberSize, int bankNameSize, int bankCodeSize, int cVV2Size, int expirationDateSize, int accountNumberSize, int firstPasswordSize, int secondPasswordSize, int balanceSize, int cover) {
        System.out.print("+");
        for(int i = 0; i < cover; i++){
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
        for(int i = 0; i < cover; i++){
            System.out.print("-");
        }
        System.out.println("+");
    }

    public void printTransactionsHistory(List<Transaction> transactions){
        int bankNameSize = 0;
        int sourceCardNumberSize =16;
        int destinationCardNumberSize = 16;
        int amountSize = 0;
        int dateSize = 26;
        int balanceSize = 0;
        int trackingNoSize = 8;
        int referenceNoSize = 14;
        for(Transaction transaction : transactions){
            if (transaction.getBankName().length() > bankNameSize) {
                bankNameSize = transaction.getBankName().length();
            }
            if(String.valueOf(transaction.getAmount()).length() > amountSize){
                amountSize = String.valueOf(transaction.getAmount()).length();
            }
            if(String.valueOf(transaction.getBalanceAfterTransaction()).length() > balanceSize){
                bankNameSize = String.valueOf(transaction.getBalanceAfterTransaction()).length();
            }
        }

        int cover = bankNameSize + sourceCardNumberSize + destinationCardNumberSize + amountSize + dateSize + balanceSize + trackingNoSize + referenceNoSize + 78;
        System.out.print("+");
        for(int i = 0 ; i < cover ; i++){
            System.out.print("-");
        }
        System.out.println("+");

        System.out.format("| %" + (-(bankNameSize + 5)) + "s" , "bankName");
        System.out.format("| %" + (-(sourceCardNumberSize + 5)) + "s" , "source card number");
        System.out.format("| %" + (-(destinationCardNumberSize + 5)) + "s" , "destination card number");
        System.out.format("| %" + (-(amountSize + 5)) + "s" , "amount");
        System.out.format("| %" + (-(dateSize + 5)) + "s" , "date");
        System.out.format("| %" + (-(balanceSize + 20)) + "s" , "balance after transaction");
        System.out.format("| %" + (-(trackingNoSize + 5)) + "s" , "tracking No");
        System.out.format("| %" + (-(referenceNoSize + 5)) + "s |\n" , "reference No");

        System.out.print("+");
        for(int i = 0 ; i < cover ; i++){
            System.out.print("-");
        }
        System.out.println("+");

        for(Transaction transaction : transactions){
            System.out.format("| %" + (-(bankNameSize + 5)) + "s" , transaction.getBankName());
            System.out.format("| %" + (-(sourceCardNumberSize + 5)) + "s" , transaction.getSourceCardNumber());
            System.out.format("| %" + (-(destinationCardNumberSize + 7)) + "s" , transaction.getDestinationCardNumber());
            System.out.format("| %" + (-(amountSize + 5)) + "s" , transaction.getAmount());
            System.out.format("| %" + (-(dateSize + 5)) + "s" , transaction.getDate());
            System.out.format("| %" + (-(balanceSize + 25)) + "s" , transaction.getBalanceAfterTransaction());
            System.out.format("| %" + (-(trackingNoSize + 5)) + "s" , transaction.getTrackingNo());
            System.out.format("| %" + (-(referenceNoSize + 5)) + "s | \n" , transaction.getTrackingNo());
        }

        System.out.print("+");
        for(int i = 0 ; i < cover ; i++){
            System.out.print("-");
        }
        System.out.println("+");
    }

    public void printRequestsForBank(List<Employee> employeeList) {
        int idSize = 10;
        int firstNameSize = 0;
        int lastNameSize = 0;
        int emailSize = 0;
        int phoneNumberSize = 0;
        int nationalCodeSize = 10;
        int birthdaySize = 10;
        for(Employee employee : employeeList){
            if(employee.getFirstName().length() > firstNameSize){
                firstNameSize = employee.getFirstName().length();
            }
            if(employee.getLastName().length() > lastNameSize){
                lastNameSize = employee.getLastName().length();
            }
            if(employee.getEmail().length() > emailSize){
                emailSize = employee.getEmail().length();
            }
            if(employee.getPhoneNumber().length() > phoneNumberSize){
                phoneNumberSize = employee.getPhoneNumber().length();
            }
        }

        int cover = idSize + firstNameSize + lastNameSize + emailSize + phoneNumberSize + nationalCodeSize + birthdaySize + 44;

        System.out.print("+");
        for(int i = 0 ; i < cover ; i++){
            System.out.print("-");
        }
        System.out.println("+");

        System.out.format("| %" + (-(idSize)) + "s" , "id");
        System.out.format("| %" + (-(firstNameSize + 5)) + "s" , "firstname");
        System.out.format("| %" + (-(lastNameSize + 5)) + "s" , "lastname");
        System.out.format("| %" + (-(emailSize + 5)) + "s" , "email");
        System.out.format("| %" + (-(phoneNumberSize + 5)) + "s" , "phoneNumber");
        System.out.format("| %" + (-(nationalCodeSize + 5)) + "s" , "nationalcode");
        System.out.format("| %" + (-(birthdaySize + 5)) + "s | \n" , "birthday");

        System.out.print("+");
        for(int i = 0 ; i < cover ; i++){
            System.out.print("-");
        }
        System.out.println("+");

        for(Employee employee : employeeList){
            System.out.format("| %" + (-(idSize)) + "s" , employee.getId());
            System.out.format("| %" + (-(firstNameSize + 5)) + "s" , employee.getFirstName());
            System.out.format("| %" + (-(lastNameSize + 5)) + "s" , employee.getLastName());
            System.out.format("| %" + (-(emailSize + 5)) + "s" , employee.getEmail());
            System.out.format("| %" + (-(phoneNumberSize + 5)) + "s" , employee.getPhoneNumber());
            System.out.format("| %" + (-(nationalCodeSize + 5)) + "s" , employee.getNationalCode());
            System.out.format("| %" + (-(birthdaySize + 5)) + "s | \n" , employee.getBirthDate());
        }


        System.out.print("+");
        for(int i = 0 ; i < cover ; i++){
            System.out.print("-");
        }
        System.out.println("+");
    }
}
