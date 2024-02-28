package main.java.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Vehicle {
    private UUID id;
    private int capacity;
    private List<Customer> route;

    public Vehicle(int capacity) {
        this.id = UUID.randomUUID();
        this.capacity = capacity;
        this.route = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Customer> getRoute() {
        return route;
    }

    public void setRoute(List<Customer> route) {
        this.route = route;
    }

    public void addCustomer(Customer customer) {
        route.add(customer);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", capacity=" + capacity +
                ", route=" + route +
                '}';
    }
}

