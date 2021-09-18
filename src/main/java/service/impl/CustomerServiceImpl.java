package service.impl;

import base.service.BaseServiceImpl;
import domain.Customer;
import repository.CustomerRepository;
import service.CustomerService;

public class CustomerServiceImpl extends BaseServiceImpl<Customer,Long, CustomerRepository> implements CustomerService {
    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);
    }
}
