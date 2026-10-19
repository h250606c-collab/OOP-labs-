public class TemperatureSafeDemo {
    public static void main(String[] args) {
        TemperatureSafe t = new TemperatureSafe(298.15);
        System.out.println("t = " + t);

        System.out.println("\nAccessors give the SAME physical value in different units:");
        System.out.printf("  %.2f K%n", t.getKelvin());
        System.out.printf("  %.2f C%n", t.getCelsius());
        System.out.printf("  %.2f F%n", t.getFahrenheit());

        System.out.println("\nGuard against invalid state:");
        try {
            new TemperatureSafe(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }

        // There is NO setter, and 'kelvin' is private and final.
        // No outside code can break the invariant "kelvin >= 0".
    }
}
