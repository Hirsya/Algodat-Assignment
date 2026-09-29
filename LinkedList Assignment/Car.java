class Car extends Entity {

    private int topSpeed;
    private int weight;

    Car(String name) {
        super(name);
        this.topSpeed = 0;
        this.weight = 0;    
    }

    Car(String name , int topSpeed, int weight) {
        super(name);
        this.topSpeed = topSpeed;
        this.weight = weight;
    }

    int getTopSpeed() { return topSpeed; }
    int getWeight() { return weight; }

    @Override
    public String toString() {
        return "Car: " + getName();
    }
}
