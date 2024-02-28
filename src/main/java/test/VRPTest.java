package main.java.test;

import main.java.model.Customer;
import main.java.model.Location;
import main.java.model.Route;
import main.java.model.Vehicle;
import main.java.solver.GreedySolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VRPTest {

    public static void main(String[] args) {
        // Step 1: Create sample data
        List<Customer> customers = createCustomers("5");
        List<Vehicle> vehicles = createVehicles("1");
        
        // Step 2: Instantiate solver
        GreedySolver solver = new GreedySolver();
        
        // Step 3: Run solver
        List<Route> solution = solver.solve(customers, vehicles);
        
        // Step 4: Output results
        displaySolution(solution);
    }

    // Helper method to create sample depots
    private static List<Customer> createCustomers(String n_customers) {
        int n = Integer.parseInt(n_customers);
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Customer customer = VRPTest.create_random_customer();
            customers.add(customer);
        }

        return customers;
    }

    private static Customer create_random_customer() {
        Random random = new Random();
        
        double minX = 0.0;
        double maxX = 100.0;
        double minY = 0.0;
        double maxY = 100.0;

        int minService = 1;
        int maxService = 5;

        int minDemand = 1;
        int maxDemand = 5;

        Location randomLocation = Location.generateRandomLocation(minX, maxX, minY, maxY);
        int service = minService + random.nextInt(maxService - minService);
        int demand = minDemand + random.nextInt(maxDemand - minDemand);
        
        Customer customer = new Customer(randomLocation, service, demand, 0, 24*60*60);
        
        return customer;
    }
    
    // Helper method to create sample vehicles
    private static List<Vehicle> createVehicles(String n_vehicles) {
        int n = Integer.parseInt(n_vehicles);
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Vehicle vehicle = VRPTest.create_random_vehicle();
            vehicles.add(vehicle);
        }
        return vehicles;
    }

    private static Vehicle create_random_vehicle() {
        int capacity = 4;
        Vehicle vehicle = new Vehicle(capacity);

        return vehicle;
    }
    
    // Helper method to display solution
    private static void displaySolution(List<Route> solution) {
        // Display routes and associated information
        // Example:
        for (Route route : solution) {
            System.out.println("Route:");
            for (Customer c : route.getCustomers()) {
                System.out.println(c.getId());
            }
            // System.out.println(route);
        }
    }
}