package service;

import base.service.BaseService;
import domain.Account;
import domain.BankBranch;

public interface BankBranchService extends BaseService<BankBranch, Long> {

    BankBranch chooseBank();
}
