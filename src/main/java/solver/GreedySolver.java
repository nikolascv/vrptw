package main.java.solver;

import main.java.model.Customer;
import main.java.model.Route;
import main.java.model.Vehicle;
import java.util.List;
import java.util.ArrayList;


public class GreedySolver implements VRPSolver {

    @Override
    public List<Route> solve(List<Customer> customers, List<Vehicle> vehicles) {
        List<Route> routes = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            Route route = new Route();
            int remainingCapacity = vehicle.getCapacity();
            int currentTime = 0;

            for (Customer customer : customers) {
                if (remainingCapacity >= customer.getDemand() && currentTime + customer.getServiceTime() <= customer.getEndTimeWindow()) {
                    route.addCustomer(customer);
                    currentTime += customer.getServiceTime();
                    remainingCapacity -= customer.getDemand();
                }
            }

            routes.add(route);
        }
        return routes;
    }
}


