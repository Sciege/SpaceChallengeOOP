import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        final int phase1 = 1;
        final int phase2 = 2;
        ArrayList<Item> phase1Items;
        ArrayList<Item> phase2Items;
        Simulation simulation = new Simulation();
        //load fleet of U1
        phase1Items = simulation.loadItems(phase1);
        phase2Items = simulation.loadItems(phase2);
        //nilupad na
        //gi load ang phase 1 and phase 2 items sa U1
        simulation.runSimulation(simulation.loadU1(phase1Items));
        simulation.runSimulation(simulation.loadU1(phase2Items));
        // U2
        simulation.runSimulation(simulation.loadU2(phase1Items));
        simulation.runSimulation(simulation.loadU2(phase2Items));

        // kwaon ang rocket then i load
        ArrayList<Rocket> U1 = simulation.loadU1(phase1Items);
        ArrayList<Rocket> u1 = simulation.loadU1(phase1Items);
        ArrayList<Rocket> U2 = simulation.loadU2(phase2Items);
        ArrayList<Rocket> u2 = simulation.loadU2(phase2Items);
        // get total cost
        long totalCostU1 = simulation.runSimulation(U1);
        long totalCostu1 = simulation.runSimulation(u1);
        long totalCostU2 = simulation.runSimulation(U2);
        long totalCostu2 = simulation.runSimulation(u2);

        long totalBudget1 = totalCostU1 + totalCostu1;
        long totalBudget2 = totalCostU2 + totalCostu2;
        //     int totalCostU1phase2 = simulation.runSimulation()
        //      int totalCostU2 = simulation.runSimulation(phase2U2Rocket);
        System.out.println(("The total budget for U1 rockets is: ") + totalBudget1);
        System.out.println(("The total budget for U2 rockets is: ") + totalBudget2);
        if (totalBudget1 > totalBudget2) {
            System.out.println("U2 rocket is cheaper than U1 rocket");
        }else {
            System.out.println("U1 rocket is cheaper than U2 rocket");
        }
    }
}
