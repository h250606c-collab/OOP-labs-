public class Car extends Vehicle {
    private final int numDoors;

    public Car(String make, int year, int numDoors) {
        super(make, year);                          // calls Vehicle's constructor
        this.numDoors = numDoors;
        System.out.println("Car constructor: " + numDoors + " doors");
    }

    public int getNumDoors() { return numDoors; }

    @Override
    public void describe() {
        super.describe();                            // reuse parent line
        System.out.println("  -> " + numDoors + " doors");
    }
}
