package repository.impl;

import base.repository.BaseRepositoryImpl;
import domain.Customer;
import repository.CustomerRepository;

import javax.persistence.EntityManager;

public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer, Long> implements CustomerRepository {
    public CustomerRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Customer> getEntity() {
        return Customer.class;
    }
}
