package main.java.solver;

import main.java.model.Route;
import main.java.model.Vehicle;
import main.java.model.Customer;
import java.util.List;

public interface VRPSolver {
    List<Route> solve(List<Customer> customers, List<Vehicle> vehicles);
}
