package main.java.model;

public class Customer {
    private int id;
    private double xCoordinate;
    private double yCoordinate;
    private int demand;
    private int serviceTime;
    private int startTimeWindow;
    private int endTimeWindow;

    public Customer(int id, double xCoordinate, double yCoordinate, int demand, int serviceTime, int startTimeWindow, int endTimeWindow) {
        this.id = id;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.demand = demand;
        this.serviceTime = serviceTime;
        this.startTimeWindow = startTimeWindow;
        this.endTimeWindow = endTimeWindow;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public double getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
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
}