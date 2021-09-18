package util;

import domain.Customer;

public class Security {
    
    private static Customer customer;

    public static Customer getCustomer() {
        return customer;
    }

    public static void setCustomer(Customer customer) {
        Security.customer = customer;
    }
}
