public class Rocket implements SpaceShip {
    private int cargoWeight;
    /// 0 tonnes
    private int rocketWeight;
    // mao ni ang 10 tonnes
    private int maxWeight;
    // mao ni ang 18 tonnes
    private int cost;

    public void setCost(int rocketCost) {
        this.cost = rocketCost;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    //tells if the weight can carry on the spaceship
    public boolean canCarry(Item item) {
        if (maxWeight >= (rocketWeight + item.getWeight())) {
            System.out.println("Can't carry item: " + item.getName() + " Weight : " + item.getWeight());
            return true;
        } else {
            System.out.println();
            return false;
        }
    }

    @Override
    //gets weight of the items
    public void carry(Item item) {
        cargoWeight += item.getWeight();
        System.out.println("Carrying item: " + item.getName() + " Weight: " + item.getWeight());
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void setCargoWeight(int rocketWeight) {
        this.cargoWeight = rocketWeight;
    }

    public void setRocketWeight(int rocketWeight) {
        this.rocketWeight = rocketWeight;
    }

    public int getTotalWeightOfRocket() {
        return rocketWeight + cargoWeight;
    }
}
