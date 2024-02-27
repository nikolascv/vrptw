package main.java.solver;

import main.java.model.Customer;
import main.java.model.Route;
import main.java.model.Vehicle;
import main.java.model.Location;
import java.util.List;
import java.util.ArrayList;


public class GreedySolver implements VRPSolver {

    @Override
    public List<Route> solve(List<Customer> customers, List<Vehicle> vehicles) {
        List<Route> routes = new ArrayList<>();
        
        Location depot_location = new Location(0.0, 0.0, 0);
        Customer depot = new Customer(depot_location, 0, 0, 0, 100000);

        for (Vehicle vehicle : vehicles) {
            Route route = new Route();
            int remainingCapacity = vehicle.getCapacity();
            int currentTime = 0;
            route.addCustomer(depot);
            
            for (Customer customer : customers) {
                if (remainingCapacity >= customer.getDemand() && currentTime + customer.getServiceTime() <= customer.getEndTimeWindow()) {
                    route.addCustomer(customer);
                    currentTime += customer.getServiceTime();
                    remainingCapacity -= customer.getDemand();
                }
            }
            
            route.addCustomer(depot);
            routes.add(route);
        }
        return routes;
    }
}


