package repository.impl;

import base.repository.BaseRepositoryImpl;
import domain.CEO;
import domain.Employee;
import repository.CEORepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class CEORepositoryImpl extends BaseRepositoryImpl<CEO, Long> implements CEORepository {
    public CEORepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<CEO> getEntity() {
        return CEO.class;
    }

    @Override
    public CEO findCEOByCEOId(int cEOCode) {
        try{
            return entityManager.createQuery("SELECT c " +
                    "FROM CEO c " +
                    "WHERE c.cEOCode = :cEOCode", CEO.class).
                    setParameter("cEOCode",cEOCode).
                    getSingleResult();
        }catch (NoResultException exception){
            return null;
        }
    }
}
