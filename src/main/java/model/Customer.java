package main.java.model;

import java.util.UUID;

public class Customer {
    private UUID id;
    private Location location;
    private int demand;
    private int serviceTime;
    private int startTimeWindow;
    private int endTimeWindow;

    public Customer(Location location, int demand, int serviceTime, int startTimeWindow, int endTimeWindow) {
        this.id = UUID.randomUUID();
        this.location = location;
        this.demand = demand;
        this.serviceTime = serviceTime;
        this.startTimeWindow = startTimeWindow;
        this.endTimeWindow = endTimeWindow;
    }

    // Getters and setters
    public UUID getId() {
        return id;
    }

    public int getDemand() {
        return demand;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    } 

    public int getServiceTime() {
        return this.serviceTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public int getStartTimeWindow() {
        return this.startTimeWindow;
    }

    public void setStartTimeWindow(int startTimeWindow) {
        this.startTimeWindow = startTimeWindow;
    }

    public int getEndTimeWindow() {
        return this.endTimeWindow;
    }

    public void setEndTimeWindow(int endTimeWindow) {
        this.endTimeWindow = endTimeWindow;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public double calculateDistance(Customer customer) {
        double x_dist = this.getLocation().getxCoordinate() - customer.getLocation().getxCoordinate();
        double y_dist = this.getLocation().getyCoordinate() - customer.getLocation().getyCoordinate();

        return Math.sqrt(Math.pow(x_dist, 2) + Math.pow(y_dist, 2));
    }
}