public class ElectricCar extends Car {
    private final double batteryKwh;

    public ElectricCar(String make, int year, int numDoors, double batteryKwh) {
        super(make, year, numDoors);                 // calls Car's constructor
        this.batteryKwh = batteryKwh;
        System.out.println("ElectricCar constructor: " + batteryKwh + " kWh battery");
    }

    public double getBatteryKwh() { return batteryKwh; }

    @Override
    public void describe() {
        super.describe();                            // reuse Car's output
        System.out.println("  -> " + batteryKwh + " kWh battery (electric)");
    }
}
