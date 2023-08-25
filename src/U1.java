import java.util.Random;

public class U1 extends Rocket {
    /*Rocket cost = $100 Million
    Rocket weight = 10 Tonnes
    Max weight (with cargo) = 18 Tonnes
    Chance of launch explosion = 5% * (cargo carried / cargo limit)
    Chance of landing crash = 1% * (cargo carried / cargo limit)
    */
    public U1() {
        this(0);
    }

    public U1(int lastWeightOfU1) {
        setCargoWeight(lastWeightOfU1);
        int cargoLimit = 18_000;
        setMaxWeight(cargoLimit);
        int cost = 100_000_000;
        setCost(cost);
        int rocketWeight = 10_000;
        setRocketWeight(rocketWeight);
    }

    @Override
    public boolean land() {
        double chanceLanding_Crash = 0.01 * ((double) getTotalWeightOfRocket() / getMaxWeight());
        if (Math.random() >= chanceLanding_Crash) {
            System.out.println("Rocket U1 successfully landed");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean launch() {
        double chanceLaunch_Explosion = 0.05 * ((double) getTotalWeightOfRocket() / getMaxWeight());
        if (Math.random() >= chanceLaunch_Explosion) {
            System.out.println("Rocket U1 successfully launch");
            return true;
        } else {
            return false;
        }
    }

}
