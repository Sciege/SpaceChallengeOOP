import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class Simulation {
    private boolean landed;
    private ArrayList<Item> items;
    private ArrayList<Rocket> rocketU1;
    private ArrayList<Rocket> rocketU2;
    private File phase1 = new File("phase-1.txt");
    private File phase2 = new File("phase-2.txt");

    // load items from the text file
    // wala pa nawala ang =
    public ArrayList<Item> loadItems(int phase) throws FileNotFoundException {
        if (phase == 1) {
            System.out.println("Loading phase 1");
            loadItem2(phase1);
            System.out.println("Loading Successfully");
        } else {
            System.out.println("Loading phase 2");
            loadItem2(phase2);
            System.out.println("Loading Successfully");
        }
        return items;
    }

    // this method loads all items from a
    // text file and returns an ArrayList of Items:
    // separate the string and integer and adds it to the array list item
    // loads item whether it is u1 rocket or u2
    public void loadItem2(File file) throws FileNotFoundException {
        items = new ArrayList<>();
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String stringOfItems = scanner.nextLine();
            String[] separator = stringOfItems.split("=");
            Item item = new Item(separator[0], Integer.parseInt(separator[1]));
            items.add(item);
        }
    }

    // create a method that will make Rocket to U1 and iterates the items if it can carry or not
    // if done iterating it will return
    public ArrayList<Rocket> loadU1(List<Item> itemsU1) {
        rocketU1 = new ArrayList<>();
        Rocket rocket = new U1();
        Iterator iterator = itemsU1.iterator();

        while (iterator.hasNext()) {
            Item item = (Item) iterator.next();
            if (rocket.canCarry(item)) {
                rocket.carry(item);
            } else {
                //adds new rocket if it is full
                rocketU1.add(rocket);
                rocket = new U1();
                rocket.carry(item);
            }
            if (!iterator.hasNext()) {
                rocketU1.add(rocket);
            }
        }
        return rocketU1;
    }

    // create a method that will make Rocket to U2 and iterates the items if it can carry or not
    // if done iterating it will return
    public ArrayList<Rocket> loadU2(List<Item> itemsU2) {
        rocketU2 = new ArrayList<>();
        Rocket rocket = new U2();
        Iterator iterator = itemsU2.iterator();

        while (iterator.hasNext()) {
            Item item = (Item) iterator.next();
            if (rocket.canCarry(item)) {
                rocket.carry(item);
            } else {
                // adds new rocket if rocket is full
                rocketU2.add(rocket);
                rocket = new U2();
                rocket.carry(item);
            }
            if(!iterator.hasNext()){
                rocketU2.add(rocket);
            }
        }
        return rocketU2;
    }

    public int runSimulation(ArrayList<Rocket> rockets) {
        int cost = 0;
        for (Rocket rocket : rockets) {
            cost += rocket.getCost();
            while (!rocket.launch() || !rocket.land()) {
                cost += rocket.getCost();
            }
        }
        return cost;
    }
}
