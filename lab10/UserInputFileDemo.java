import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInputFileDemo {
    public static void main(String[] args) {
        Path file = Path.of("user-lines.txt");
        List<String> lines = new ArrayList<>();

        // 1) Read 5 lines from the user
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter 5 lines:");
            for (int i = 1; i <= 5; i++) {
                System.out.print("  Line " + i + ": ");
                lines.add(scanner.nextLine());
            }
        }

        // 2) Write to file
        try {
            Files.write(file, lines);
            System.out.println("\nSaved " + lines.size() + " lines to " + file.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("Write failed: " + e.getMessage());
            return;
        }

        // 3) Read back
        System.out.println("\n--- Read from file ---");
        try {
            List<String> readBack = Files.readAllLines(file);
            for (int i = 0; i < readBack.size(); i++) {
                System.out.printf("  %d: %s%n", i + 1, readBack.get(i));
            }
        } catch (IOException e) {
            System.out.println("Read failed: " + e.getMessage());
        }
    }
}