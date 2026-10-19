public class Vehicle {
    private final String make;
    private final int year;

    public Vehicle(String make, int year) {
        this.make = make;
        this.year = year;
        System.out.println("Vehicle constructor: " + make + " " + year);
    }

    public String getMake() { return make; }
    public int getYear()    { return year; }

    public void describe() {
        System.out.println("Vehicle: " + make + " (" + year + ")");
    }
}
