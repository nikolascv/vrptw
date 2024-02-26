package main.java.solver;

import main.java.model.Depot;
import main.java.model.Route;
import main.java.model.Vehicle;
import java.util.List;


public class GreedySolver implements VRPSolver {

    @Override
    public List<Route> solve(List<Depot> depots, List<Vehicle> vehicles) {
        List<Route> routes = new ArrayList<>();

        for (Depot depot : depots) {
            for (Vehicle vehicle : vehicles) {
                Route route = new Route();
                int remainingCapacity = vehicle.getCapacity();
                int currentTime = 0; // Current time initialized to 0

                for (Customer customer : depot.getCustomers()) {
                    // Check if the vehicle has enough capacity and if the customer can be served within its time window
                    if (remainingCapacity >= customer.getDemand() && currentTime + customer.getServiceTime() <= customer.getEndTimeWindow()) {
                        route.addCustomer(customer);
                        currentTime += customer.getServiceTime(); // Increment the current time
                        remainingCapacity -= customer.getDemand(); // Update remaining capacity
                    }
                }

                routes.add(route); // Add the route to the list of routes
            }
        }

        return routes;
    }
}


