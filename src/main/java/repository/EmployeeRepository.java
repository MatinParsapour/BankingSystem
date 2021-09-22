package repository;

import base.repository.BaseRepository;
import domain.Employee;

public interface EmployeeRepository extends BaseRepository<Employee, Long> {
    Employee findEmployeeByEmployeeCode(int employeeCode);

    Employee findEmployeeByNationalCode(String nationalCode);
}
