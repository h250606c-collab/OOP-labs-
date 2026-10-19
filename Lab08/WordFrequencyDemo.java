import java.util.*;

public class WordFrequencyDemo {
    public static void main(String[] args) {
        String text =
            "the quick brown fox jumps over the lazy dog " +
            "the dog barks and the fox runs away " +
            "the quick fox is quick and the lazy dog sleeps";

        // Normalise: lowercase + split on non-letters
        String[] words = text.toLowerCase().split("\\W+");

        // 1) Count
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                freq.merge(word, 1, Integer::sum);
            }
        }

        // 2) Convert entries to a list, sort by value descending,
        //    then alphabetically for ties (deterministic output)
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(freq.entrySet());
        entries.sort(
            Map.Entry.<String, Integer>comparingByValue().reversed()
                .thenComparing(Map.Entry.comparingByKey())
        );

        // 3) Print
        System.out.println("Word frequencies (descending):");
        for (Map.Entry<String, Integer> e : entries) {
            System.out.printf("  %-8s %d%n", e.getKey(), e.getValue());
        }

        System.out.println("\nTotal distinct words: " + freq.size());
        System.out.println("Total word occurrences: " + words.length);
    }
}