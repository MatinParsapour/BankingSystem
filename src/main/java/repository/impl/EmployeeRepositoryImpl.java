package repository.impl;

import base.repository.BaseRepositoryImpl;
import domain.Employee;
import repository.EmployeeRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class EmployeeRepositoryImpl extends BaseRepositoryImpl<Employee, Long> implements EmployeeRepository {
    public EmployeeRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Employee> getEntity() {
        return Employee.class;
    }

    @Override
    public Employee findEmployeeByEmployeeCode(int employeeCode) {
        try{
            return entityManager.createQuery("SELECT e " +
                    "FROM Employee e " +
                    "WHERE e.employeeCode = :employeeCode",Employee.class).
                    setParameter("employeeCode",employeeCode).
                    getSingleResult();
        }catch (NoResultException exception){
            return null;
        }
    }
}
