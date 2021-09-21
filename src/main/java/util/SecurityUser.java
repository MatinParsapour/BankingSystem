package util;

import domain.Customer;
import domain.Employee;

public class SecurityUser {
    
    private static Customer customer;
    private static Employee employee;

    public static Employee getEmployee() {
        return employee;
    }

    public static void setEmployee(Employee employee) {
        SecurityUser.employee = employee;
    }

    public static Customer getCustomer() {
        return customer;
    }

    public static void setCustomer(Customer customer) {
        SecurityUser.customer = customer;
    }
}
