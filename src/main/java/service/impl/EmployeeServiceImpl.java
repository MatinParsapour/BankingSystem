package service.impl;

import base.service.BaseServiceImpl;
import domain.Employee;
import repository.EmployeeRepository;

public class EmployeeServiceImpl extends BaseServiceImpl<Employee,Long, EmployeeRepository> {
    public EmployeeServiceImpl(EmployeeRepository repository) {
        super(repository);
    }
}
