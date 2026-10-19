import java.util.*;

public class RemoveDuplicatesDemo {
    public static void main(String[] args) {
        // 1) Original list with duplicates
        List<String> names = new ArrayList<>(List.of(
            "Zodwa", "Alice", "Moyo", "Alice",
            "Tariro", "Moyo", "Farai", "Alice"
        ));

        System.out.println("Original list (" + names.size() + "): " + names);

        // 2) LinkedHashSet: keeps insertion order, drops duplicates
        Set<String> uniqueInOrder = new LinkedHashSet<>(names);
        System.out.println("Unique (insertion order): " + uniqueInOrder);

        // 3) TreeSet: sorted alphabetically, drops duplicates
        Set<String> uniqueSorted = new TreeSet<>(names);
        System.out.println("Unique (sorted):          " + uniqueSorted);

        // 4) Optional: convert back to a List if needed
        List<String> uniqueList = new ArrayList<>(uniqueInOrder);
        System.out.println("Back to List:             " + uniqueList);

        // 5) Count check
        System.out.println("Original count: " + names.size());
        System.out.println("Unique count:   " + uniqueSorted.size());
    }
}