package main.java.solver;

import main.java.model.Depot;
import main.java.model.Route;
import main.java.model.Vehicle;
import java.util.List;

public interface VRPSolver {
    List<Route> solve(List<Depot> depots, List<Vehicle> vehicles);
}
