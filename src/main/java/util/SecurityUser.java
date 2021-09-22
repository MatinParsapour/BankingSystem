package util;

import domain.CEO;
import domain.Customer;
import domain.Employee;

public class SecurityUser {
    
    private static Customer customer;
    private static Employee employee;
    private static CEO ceo;

    public static CEO getCeo() {
        return ceo;
    }

    public static void setCeo(CEO ceo) {
        SecurityUser.ceo = ceo;
    }

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
