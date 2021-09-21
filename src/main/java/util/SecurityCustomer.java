package util;

import domain.Customer;

public class SecurityCustomer {
    
    private static Customer customer;

    public static Customer getCustomer() {
        return customer;
    }

    public static void setCustomer(Customer customer) {
        SecurityCustomer.customer = customer;
    }
}
