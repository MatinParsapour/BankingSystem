package repository.impl;

import base.repository.BaseRepositoryImpl;
import domain.Employee;
import repository.EmployeeRepository;
import util.SecurityUser;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class EmployeeRepositoryImpl extends BaseRepositoryImpl<Employee, Long> implements EmployeeRepository {
    public EmployeeRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Employee> getEntity() {
        return Employee.class;
    }

    @Override
    public Employee findEmployeeByEmployeeCode(long employeeCode) {
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

    @Override
    public Employee findEmployeeByNationalCode(String nationalCode) {
        try{
            return entityManager.createQuery("SELECT e " +
                    "FROM Employee e " +
                    "WHERE e.nationalCode = :nationalCode",Employee.class).
                    setParameter("nationalCode",nationalCode).
                    getSingleResult();
        }catch (NoResultException exception){
            return null;
        }
    }

    @Override
    public List<Employee> findRequestsForCEO() {
        try{
            return entityManager.createQuery("SELECT e " +
                    "FROM Employee e " +
                    "JOIN e.bankBranch b " +
                    "WHERE b.id = :id " +
                    "AND e.isEmployee = null ",Employee.class).
                    setParameter("id", SecurityUser.getCeo().getBankBranch().getId()).
                    getResultList();
        }catch (NoResultException exception){
            return null;
        }
    }

    @Override
    public Employee findEmployeeByIdForCEO(long id) {
        try{
            return entityManager.createQuery("SELECT e " +
                    "FROM Employee e " +
                    "JOIN e.bankBranch b " +
                    "WHERE b.id = :id " +
                    "AND e.id = :employeeId " +
                    "AND e.isEmployee = null ",Employee.class).
                    setParameter("id", SecurityUser.getCeo().getBankBranch().getId()).setParameter("employeeId",id).getSingleResult();
        }catch (NoResultException exception){
            return null;
        }
    }
}
