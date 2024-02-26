package main.java.model;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    private int id;
    private int capacity;
    private int maxRouteDuration;
    private List<Customer> route;

    public Vehicle(int id, int capacity, int maxRouteDuration) {
        this.id = id;
        this.capacity = capacity;
        this.maxRouteDuration = maxRouteDuration;
        this.route = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getMaxRouteDuration() {
        return maxRouteDuration;
    }

    public void setMaxRouteDuration(int maxRouteDuration) {
        this.maxRouteDuration = maxRouteDuration;
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
                ", maxRouteDuration=" + maxRouteDuration +
                ", route=" + route +
                '}';
    }
}

