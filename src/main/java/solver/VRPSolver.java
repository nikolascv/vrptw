package main.java.solver;

import com.google.ortools.linearsolver.MPSolver;
import main.java.model.Vehicle;
import main.java.model.Customer;
import java.util.List;

public interface VRPSolver {
    MPSolver.ResultStatus solve(double[][] costs, int[] earliest, int[] latest, List<Vehicle> vehicles, List<Customer> customers);
}
