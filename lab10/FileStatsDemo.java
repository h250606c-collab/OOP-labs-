import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileStatsDemo {
    public static void main(String[] args) {
        Path file = Path.of("sample.txt");

        // Ensure the file exists; create a sample if not
        if (!Files.exists(file)) {
            try {
                Files.write(file, List.of(
                    "The quick brown fox",
                    "jumps over the lazy dog.",
                    "Java file I/O is fun!"
                ));
                System.out.println("Created sample.txt for you.\n");
            } catch (IOException e) {
                System.out.println("Could not create sample file: " + e.getMessage());
                return;
            }
        }

        // --- METHOD 1: loop through lines ---
        System.out.println("--- Method 1: manual loop ---");
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        try {
            List<String> lines = Files.readAllLines(file);
            for (String line : lines) {
                lineCount++;
                charCount += line.length();          // all chars, no newline

                String trimmed = line.trim();
                if (!trimmed.isEmpty()) {
                    String[] words = trimmed.split("\\s+");
                    wordCount += words.length;
                }
            }
        } catch (IOException e) {
            System.out.println("Read failed: " + e.getMessage());
            return;
        }

        System.out.println("Lines:      " + lineCount);
        System.out.println("Words:      " + wordCount);
        System.out.println("Characters: " + charCount);

        // --- METHOD 2: streams (modern approach) ---
        System.out.println("\n--- Method 2: streams ---");
        try {
            long streamLines = Files.lines(file).count();

            long streamWords = Files.lines(file)
                .flatMap(l -> java.util.Arrays.stream(l.trim().split("\\s+")))
                .filter(w -> !w.isEmpty())
                .count();

            long streamChars = Files.lines(file)
                .mapToLong(String::length)
                .sum();

            System.out.println("Lines:      " + streamLines);
            System.out.println("Words:      " + streamWords);
            System.out.println("Characters: " + streamChars);
        } catch (IOException e) {
            System.out.println("Read failed: " + e.getMessage());
        }
    }
}