import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class GradeBandReport {

    record Learner(String name, int roll, double gpa) {
        static Learner fromCsv(String line) {
            String[] p = line.split(",");
            return new Learner(p[0], Integer.parseInt(p[1]), Double.parseDouble(p[2]));
        }

        String band() {
            if (gpa >= 3.5) return "A";
            if (gpa >= 3.0) return "B";
            return "C";
        }

        @Override
        public String toString() {
            return String.format("%-8s (roll %d, GPA %.2f)", name, roll, gpa);
        }
    }

    public static void main(String[] args) throws IOException {
        Path source = Path.of("learners.csv");
        if (!Files.exists(source)) {
            System.out.println("Missing learners.csv — run Program 10.2 first.");
            return;
        }

        // 1) Load
        List<Learner> learners = Files.readAllLines(source).stream()
            .filter(line -> !line.isBlank())
            .map(Learner::fromCsv)
            .collect(Collectors.toList());

        System.out.println("Loaded " + learners.size() + " learners.\n");

        // 2) Group by grade band — TreeMap keeps bands sorted A, B, C
        Map<String, List<Learner>> byBand = learners.stream()
            .collect(Collectors.groupingBy(
                Learner::band,
                TreeMap::new,
                Collectors.toList()
            ));

        // 3) Write one file per band
        for (Map.Entry<String, List<Learner>> entry : byBand.entrySet()) {
            String band = entry.getKey();
            List<Learner> members = entry.getValue();

            // Sort within the band by GPA descending (top students first)
            List<String> lines = members.stream()
                .sorted((a, b) -> Double.compare(b.gpa(), a.gpa()))
                .map(Object::toString)
                .collect(Collectors.toList());

            Path out = Path.of("band-" + band + ".txt");
            Files.write(out, lines);

            System.out.printf("Band %s: %d learners -> %s%n",
                band, members.size(), out.toAbsolutePath());
        }
    }
}