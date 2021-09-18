package repository.impl;

import base.repository.BaseRepositoryImpl;
import domain.CEO;
import repository.CEORepository;

import javax.persistence.EntityManager;

public class CEORepositoryImpl extends BaseRepositoryImpl<CEO, Long> implements CEORepository {
    public CEORepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<CEO> getEntity() {
        return CEO.class;
    }
}
