package repository;

import base.repository.BaseRepository;
import domain.Customer;
import domain.User;

public interface CustomerRepository extends BaseRepository<Customer, Long> {

    Customer findUserByUserName(String userName);

    Customer findUserByUserNameAndPassword(String userName, String password);

    Customer findCustomerByNationalCode(String nationalCode);
}
