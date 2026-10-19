public final class TemperatureSafe {

    // Internal representation: KELVIN only (never exposed as a field)
    private final double kelvin;

    public TemperatureSafe(double kelvin) {
        if (kelvin < 0) {
            throw new IllegalArgumentException(
                "Below absolute zero: " + kelvin + " K");
        }
        this.kelvin = kelvin;
    }

    // Convert out of the internal unit on demand
    public double getKelvin()     { return kelvin; }
    public double getCelsius()    { return kelvin - 273.15; }
    public double getFahrenheit() { return (kelvin - 273.15) * 9.0 / 5.0 + 32; }

    @Override
    public String toString() {
        return String.format("%.2f K / %.2f C / %.2f F",
            getKelvin(), getCelsius(), getFahrenheit());
    }
}
