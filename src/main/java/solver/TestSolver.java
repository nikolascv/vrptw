package main.java.solver;

import main.java.model.Customer;
import main.java.model.Vehicle;

import java.util.List;

import com.google.ortools.linearsolver.MPConstraint;
import com.google.ortools.linearsolver.MPObjective;
import com.google.ortools.linearsolver.MPSolver;
import com.google.ortools.linearsolver.MPVariable;


public class TestSolver implements VRPSolver {
    private List<Customer> customers;
    private List<Vehicle> vehicles;
    private int[] earliest;
    private int[] latest;
    private double[][] costs;

    public TestSolver(List<Customer> customers, List<Vehicle> vehicles) {
        this.customers = customers;
        this.vehicles = vehicles;
        this.earliest = make_earliest(customers);
        this.latest = make_latest(customers);
        this.costs = calculateCosts(customers);
    }

    @Override
    public MPSolver.ResultStatus solve(double[][] costs, int[] earliest, int[] latest, List<Vehicle> vehicles, List<Customer> customers) {
        int n_customers = this.customers.size();
        int n_vehicles = vehicles.size();
        double error = Math.exp(-5);

        // Choose solver
        MPSolver solver = MPSolver.createSolver("SCIP");

        // Does vehicle k use edge i,j
        MPVariable[][][] x = new MPVariable[n_customers][n_customers][n_vehicles];
        for (int i = 0; i < n_customers; i++) {
            for (int j = 0; j < n_customers; j++) {
                for (int k = 0; k < n_vehicles; k++) {
                    x[i][j][k] = solver.makeIntVar(0,1,"");
                }
            }
        }

        // Time at which vehicle k visits customer i
        MPVariable[][] s = new MPVariable[n_customers][n_vehicles];
        for (int i = 0; i < n_customers; i++) {
            for (int k = 0; k < n_vehicles; k++) {
                s[i][k] = solver.makeIntVar(0,1,"");
            }
        }

        MPObjective obj = solver.objective();
        for (int i = 0; i < n_customers; i++) {
            for (int j = 0; j < n_customers; j++) {
                for (int k = 0; k < n_vehicles; k++) {
                    obj.setCoefficient(x[i][j][k], costs[i][j]);
                }
            }
        }

        for (int i = 0; i < n_customers; i++) {
            MPConstraint customer_assignment = solver.makeConstraint(1 - error, 1 + error, " ");
            for (int j = 0; j < n_customers; j++) {
                for(int k = 0; k < n_vehicles; k++) {
                    customer_assignment.setCoefficient(x[i][j][j], 1);
                }
            }
        }

        MPSolver.ResultStatus resultStatus = solver.solve();

        return resultStatus;
    }

    public double[][] calculateCosts(List<Customer> customers) {
        int numCustomers = customers.size();
        double[][] costs = new double[numCustomers][numCustomers];

        for (int i = 0; i < numCustomers; i++) {
            Customer c1 = customers.get(i);
            for (int j = 0; j < numCustomers; j++) {
                Customer c2 = customers.get(j);
                if (c1 == c2) {
                    costs[i][j] = 1000;
                }
                costs[i][j] = c1.calculateDistance(c2); // Calculate distance between customers
            }
        }
        return costs;
    }

    public int[] make_earliest(List<Customer> customers) {
        int numCustomers = customers.size();
        int[] earliest = new int[numCustomers];

        for (int i = 0; i < numCustomers; i++) {
            Customer cust = customers.get(i);
            earliest[i] = cust.getStartTimeWindow();
        }

        return earliest;
    }

    public int[] make_latest(List<Customer> customers) {
        int numCustomers = customers.size();
        int[] latest = new int[numCustomers];

        for (int i = 0; i < numCustomers; i++) {
            Customer cust = customers.get(i);
            latest[i] = cust.getEndTimeWindow();
        }

        return latest;
    }

    public int[] getEarliest() {
        return this.earliest;
    }

    public int[] getLatest() {
        return this.latest;
    }

    public double[][] getCosts() {
        return this.costs;
    }
}