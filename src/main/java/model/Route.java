package main.java.model;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private List<Customer> customers;

    public Route() {
        this.customers = new ArrayList<>();
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public String toString() {
        return "Route{" +
                "customers=" + customers +
                '}';
    }
}

