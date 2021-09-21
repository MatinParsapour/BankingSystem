package util;

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

        for(BankBranch bankBranch : banks){
            System.out.format("| %" + (-(bankNameSize + 2)) + "s" , bankBranch.getBankName());
            System.out.format("| %" + (-(bankCodeSize + 2)) + "s|\n" , bankBranch.getBranchCode());
        }
        System.out.print("+");
        for(int i = 0 ; i < cover ; i++){
            System.out.print("-");
        }
        System.out.println("+");
    }
}
