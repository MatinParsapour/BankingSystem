package service.impl;

import base.service.BaseServiceImpl;
import domain.BankBranch;
import repository.BankBranchRepository;

public class BankBranchServiceImpl extends BaseServiceImpl<BankBranch,Long, BankBranchRepository> {
    public BankBranchServiceImpl(BankBranchRepository repository) {
        super(repository);
    }
}
