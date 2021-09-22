package repository;

import base.repository.BaseRepository;
import domain.Employee;

import java.util.List;

public interface EmployeeRepository extends BaseRepository<Employee, Long> {
    Employee findEmployeeByEmployeeCode(long employeeCode);

    Employee findEmployeeByNationalCode(String nationalCode);

    List<Employee> findRequestsForCEO();

    Employee findEmployeeByIdForCEO(long id);
}
