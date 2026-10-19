public class VehicleDemo {
    public static void main(String[] args) {
        System.out.println("--- Creating ElectricCar ---");
        ElectricCar ev = new ElectricCar("Tesla Model 3", 2024, 4, 75.0);

        System.out.println("\n--- describe() ---");
        ev.describe();

        System.out.println("\n--- Through a Vehicle reference ---");
        Vehicle v = ev;                // upcast: ElectricCar IS-A Vehicle
        v.describe();                  // still uses ElectricCar's describe()
    }
}
