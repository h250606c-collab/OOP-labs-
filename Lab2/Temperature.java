public class Temperature {

    // EXPLAIN: store everything internally in kelvin (one canonical unit)
    private final double kelvin;

    // EXPLAIN: private constructor -> outsiders MUST go through a factory
    private Temperature(double kelvin) {
        if (kelvin < 0) {
            throw new IllegalArgumentException("Below absolute zero: " + kelvin);
        }
        this.kelvin = kelvin;
    }

    // Factory 1: build from Celsius
    public static Temperature fromCelsius(double celsius) {
        return new Temperature(celsius + 273.15);
    }

    // Factory 2: build from Fahrenheit
    public static Temperature fromFahrenheit(double fahrenheit) {
        return new Temperature((fahrenheit - 32) * 5.0 / 9.0 + 273.15);
    }

    // Factory 3: build from kelvin directly (bonus, for symmetry)
    public static Temperature fromKelvin(double kelvin) {
        return new Temperature(kelvin);
    }

    // Getters: convert out of the internal unit on demand
    public double getKelvin()    { return kelvin; }
    public double getCelsius()   { return kelvin - 273.15; }
    public double getFahrenheit(){ return (kelvin - 273.15) * 9.0 / 5.0 + 32; }

    @Override
    public String toString() {
        return String.format("%.2f K / %.2f C / %.2f F",
            getKelvin(), getCelsius(), getFahrenheit());
    }

    public static void main(String[] args) {
        Temperature t1 = Temperature.fromCelsius(25);
        Temperature t2 = Temperature.fromFahrenheit(77);
        Temperature t3 = Temperature.fromKelvin(300);

        System.out.println("25 C     -> " + t1);
        System.out.println("77 F     -> " + t2);
        System.out.println("300 K    -> " + t3);

        System.out.println("\nt1 and t2 equal? " +
            (Math.abs(t1.getKelvin() - t2.getKelvin()) < 0.0001));

        // Test the guard
        try {
            Temperature.fromCelsius(-300);   // below absolute zero
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}
