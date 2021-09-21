package repository.impl;

import base.repository.BaseRepositoryImpl;
import domain.BankBranch;
import repository.BankBranchRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class BankBranchRepositoryImpl extends BaseRepositoryImpl<BankBranch, Long> implements BankBranchRepository {
    public BankBranchRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<BankBranch> getEntity() {
        return BankBranch.class;
    }

    @Override
    public BankBranch findBankByName(String bankName) {
        try{
            BankBranch bankBranch = entityManager.createQuery("SELECT b " +
                            "FROM BankBranch b " +
                            "WHERE b.bankName = :bankName ",
                    BankBranch.class).
                    setParameter("bankName",bankName).
                    getSingleResult();
            return bankBranch;
        }catch (NoResultException exception){
            return null;
        }
    }
}
