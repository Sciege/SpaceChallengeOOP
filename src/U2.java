import java.util.Random;

public class U2 extends Rocket {
    /*Rocket cost = $120 Million
    Rocket weight = 18 Tonnes
    Max weight (with cargo) = 29 Tonnes
    Chance of launch explosion = 4% * (cargo carried / cargo limit)
    Chance of landing crash = 8% * (cargo carried / cargo limit)
    */
    U2() {
        this(0);
    }

    U2(int lastWeightOfU2) {
        setCargoWeight(lastWeightOfU2);
        int cargoLimit = 11_000;
        setMaxWeight(cargoLimit);
        int cost = 120_000_000;
        setCost(cost);
        int rocketWeight = 18_000;
        setRocketWeight(rocketWeight);
    }

    @Override
    public boolean land() {
        double chanceLanding_Crash = 0.04 * ((double) (getTotalWeightOfRocket() / getMaxWeight()));
        if (Math.random() >= chanceLanding_Crash) {
            System.out.println("U2 successfully landed");
            return true;
        } else {
            System.out.println("U2 exploded");
            return false;
        }
    }

    @Override
    public boolean launch() {
        double chanceLaunch_Explosion = 0.08 * ((double) (getTotalWeightOfRocket() / getMaxWeight()));
        if (Math.random() >= chanceLaunch_Explosion) {
            System.out.println("U2 launched successfully");
            return true;
        } else {
            System.out.println("U2 exploded");
            return false;
        }
    }
}

