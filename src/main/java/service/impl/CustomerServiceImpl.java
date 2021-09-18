package service.impl;

import base.service.BaseServiceImpl;
import domain.Customer;
import repository.CustomerRepository;

public class CustomerServiceImpl extends BaseServiceImpl<Customer,Long, CustomerRepository> {
    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);
    }
}
