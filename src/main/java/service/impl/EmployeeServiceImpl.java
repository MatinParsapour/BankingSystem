package service.impl;

import base.service.BaseServiceImpl;
import domain.Employee;
import repository.EmployeeRepository;
import service.EmployeeService;

public class EmployeeServiceImpl extends BaseServiceImpl<Employee,Long, EmployeeRepository> implements EmployeeService {
    public EmployeeServiceImpl(EmployeeRepository repository) {
        super(repository);
    }
}
