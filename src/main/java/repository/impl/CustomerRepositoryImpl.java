package repository.impl;

import base.repository.BaseRepositoryImpl;
import domain.Customer;
import domain.Employee;
import domain.User;
import repository.CustomerRepository;
import util.CriteriaCustom;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer, Long> implements CustomerRepository {
    public CustomerRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Customer> getEntity() {
        return Customer.class;
    }

    @Override
    public Customer findUserByUserName(String userName) {
        try{
            CriteriaQuery<Customer> criteriaQuery = CriteriaCustom.getCriteriaBuilderCutom().createQuery(Customer.class);
            Root<Customer> customerRoot = criteriaQuery.from(Customer.class);
            criteriaQuery.select(customerRoot).where(CriteriaCustom.getCriteriaBuilderCutom().equal(customerRoot.get("userName"), userName));
            Customer customer = entityManager.createQuery(criteriaQuery).getSingleResult();
            return customer;
        }catch (NoResultException exception){
            return null;
        }
    }

    @Override
    public Customer findUserByUserNameAndPassword(String userName, String password) {
        try{
            CriteriaQuery<Customer> criteriaQuery = CriteriaCustom.getCriteriaBuilderCutom().createQuery(Customer.class);
            Root<Customer> customerRoot = criteriaQuery.from(Customer.class);
            criteriaQuery.select(customerRoot)
                    .where(CriteriaCustom.getCriteriaBuilderCutom().and(
                            CriteriaCustom.getCriteriaBuilderCutom().equal(
                                    customerRoot.get("userName"), userName),
                            CriteriaCustom.getCriteriaBuilderCutom().equal(
                                    customerRoot.get("password"),password)));
            Customer customer = entityManager.createQuery(criteriaQuery).getSingleResult();
            return customer;
        }catch (NoResultException exception){
            return null;
        }
    }

    @Override
    public Customer findCustomerByNationalCode(String nationalCode) {
        try{
            return entityManager.createQuery("SELECT c " +
                    "FROM Customer c " +
                    "WHERE c.nationalCode = :nationalCode",Customer.class).
                    setParameter("nationalCode",nationalCode).
                    getSingleResult();
        }catch (NoResultException exception){
            return null;
        }
    }
}
