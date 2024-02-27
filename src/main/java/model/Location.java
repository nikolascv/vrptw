package main.java.model;

public class Location {
    private double xCoordinate;
    private double yCoordinate;
    private int node;

    public Location(double xCoordinate, double yCoordinate, int node) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.node = node;
    }

    public double getxCoordinate() {
        return this.xCoordinate;
    }

    public double getyCoordinate() {
        return this.yCoordinate;
    }

    public void setxCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public void setyCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public int getNode() {
        return this.node;
    }

    public void setNode(int node) {
        this.node = node;
    }
}
