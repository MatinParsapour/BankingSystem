package repository;

import base.repository.BaseRepository;
import domain.Customer;
import domain.User;

public interface CustomerRepository extends BaseRepository<Customer, Long> {

    Customer findUserByUserName(String userName);
}
