package repository.impl;

import base.repository.BaseRepositoryImpl;
import domain.BankBranch;
import repository.BankBranchRepository;

import javax.persistence.EntityManager;

public class BankBranchRepositoryImpl extends BaseRepositoryImpl<BankBranch, Long> implements BankBranchRepository {
    public BankBranchRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<BankBranch> getEntity() {
        return BankBranch.class;
    }
}
