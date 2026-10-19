import java.util.EnumMap;
import java.util.Map;

enum Coin {
    // Declared highest to lowest so the greedy loop is clean
    QUARTER(25),
    DIME(10),
    NICKEL(5),
    PENNY(1);

    private final int value;

    Coin(int value) { this.value = value; }

    public int getValue() { return value; }
}

public class CoinChangeDemo {

    // Returns the fewest coins that sum to 'cents'
    static Map<Coin, Integer> fewestCoins(int cents) {
        if (cents < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }

        Map<Coin, Integer> result = new EnumMap<>(Coin.class);

        for (Coin coin : Coin.values()) {          // QUARTER -> DIME -> NICKEL -> PENNY
            int count = cents / coin.getValue();   // how many of this coin fit?
            if (count > 0) {
                result.put(coin, count);
                cents -= count * coin.getValue();  // subtract and continue
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] amounts = { 87, 30, 99, 5, 1, 0, 100 };

        for (int amount : amounts) {
            System.out.printf("%3d cents: ", amount);
            Map<Coin, Integer> coins = fewestCoins(amount);

            if (coins.isEmpty()) {
                System.out.print("(no coins)");
            } else {
                coins.forEach((coin, count) ->
                    System.out.printf("%d x %s ", count, coin));
                int total = coins.entrySet().stream()
                    .mapToInt(e -> e.getKey().getValue() * e.getValue())
                    .sum();
                System.out.printf("= %d cents", total);
            }
            System.out.println();
        }

        // Negative amount rejected
        System.out.println();
        try {
            fewestCoins(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}