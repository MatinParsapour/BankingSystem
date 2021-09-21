package service.impl;

import base.service.BaseServiceImpl;
import domain.Account;
import domain.BankBranch;
import repository.BankBranchRepository;
import service.BankBranchService;
import util.ApplicationContext;

import java.util.Scanner;

public class BankBranchServiceImpl extends BaseServiceImpl<BankBranch,Long, BankBranchRepository> implements BankBranchService {
    public BankBranchServiceImpl(BankBranchRepository repository) {
        super(repository);
    }

    @Override
    public BankBranch chooseBank() {
        ApplicationContext.getDemonstrateInfos().demonstrateBanks(findAll());
        String bankName = new Scanner(System.in).next();
        BankBranch bankBranch = repository.findBankByName(bankName);
        return bankBranch;
    }
}
