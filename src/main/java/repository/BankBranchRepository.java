package repository;

import base.repository.BaseRepository;
import domain.BankBranch;

public interface BankBranchRepository extends BaseRepository<BankBranch, Long> {

    BankBranch findBankByName(String bankName);
}
