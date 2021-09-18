package service.impl;

import base.service.BaseServiceImpl;
import domain.BankBranch;
import repository.BankBranchRepository;
import service.BankBranchService;

public class BankBranchServiceImpl extends BaseServiceImpl<BankBranch,Long, BankBranchRepository> implements BankBranchService {
    public BankBranchServiceImpl(BankBranchRepository repository) {
        super(repository);
    }
}
