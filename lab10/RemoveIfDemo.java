import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class RemoveIfDemo {
    public static void main(String[] args) {

        // 1) Build a list with mixed numbers
        List<Integer> numbers = new ArrayList<>(
            List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 15, 18, 21)
        );
        System.out.println("Before: " + numbers);

        // 2) Define the predicate separately — useful if it's reused
        Predicate<Integer> isEven = n -> n % 2 == 0;

        // 3) Remove every element that matches
        numbers.removeIf(isEven);
        System.out.println("After:  " + numbers);

        // 4) Inline lambda version (equivalent)
        List<Integer> more = new ArrayList<>(
            List.of(11, 22, 33, 44, 55, 66)
        );
        System.out.println("\nBefore: " + more);
        more.removeIf(n -> n % 2 == 0);          // inline predicate
        System.out.println("After:  " + more);

        // 5) Chained: remove numbers greater than 50 AND even
        List<Integer> big = new ArrayList<>(
            List.of(10, 60, 71, 80, 99, 100, 5)
        );
        System.out.println("\nBefore: " + big);
        big.removeIf(n -> n > 50 && n % 2 == 0);
        System.out.println("After:  " + big);

        // 6) Remove strings starting with a letter
        List<String> words = new ArrayList<>(
            List.of("Apple", "banana", "Avocado", "cherry", "apricot")
        );
        System.out.println("\nBefore: " + words);
        words.removeIf(s -> s.startsWith("A") || s.startsWith("a"));
        System.out.println("After:  " + words);
    }
}