enum Level {
    LOW, MEDIUM, HIGH
}

public class LevelDemo {

    // Switch expression: every enum constant is covered
    static String adviceFor(Level level) {
        return switch (level) {
            case LOW    -> "Take it easy — you have plenty of time";
            case MEDIUM -> "Stay focused — you're on track";
            case HIGH   -> "Take a break — don't burn out!";
        };
    }

    public static void main(String[] args) {
        Level[] levels = { Level.LOW, Level.MEDIUM, Level.HIGH };

        for (Level l : levels) {
            System.out.printf("%-7s (%d): %s%n",
                l.name(), l.ordinal(), adviceFor(l));
        }

        // Bonus: switch statement (older style, still common)
        System.out.println("\n--- switch statement style ---");
        for (Level l : levels) {
            switch (l) {
                case LOW:    System.out.println("LOW: no priority"); break;
                case MEDIUM: System.out.println("MEDIUM: normal priority"); break;
                case HIGH:   System.out.println("HIGH: urgent"); break;
            }
        }
    }
}