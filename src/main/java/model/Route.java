package main.java.model;

import java.util.ArrayList;
import java.util.List;
import java.math.*;

public class Route {
    private List<Customer> customers;
    private Vehicle vehicle;
    private double cost;

    public Route() {
        this.customers = new ArrayList<>();
        this.vehicle = null;
        this.cost = calculateCost(this.customers);
    }

    private double calculateDistance(Customer customer1, Customer customer2) {
        double x_dist = customer1.getLocation().getxCoordinate() - customer2.getLocation().getxCoordinate();
        double y_dist = customer1.getLocation().getyCoordinate() - customer2.getLocation().getyCoordinate();

        double distance = Math.sqrt(Math.pow(x_dist, 2) + Math.pow(y_dist, 2));
        return distance;
    }

    private double calculateCost(List<Customer> customers) {
        double cost = 0.0;
        for (int i = 0; i < this.customers.size() - 1; i++) {
            cost += calculateDistance(this.customers.get(i), this.customers.get(i+1));
        }
        return cost;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
        calculateCost(this.customers);
    }

    public double getCost() {
        return this.cost;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Route{" +
                "customers=" + customers +
                '}';
    }
}

