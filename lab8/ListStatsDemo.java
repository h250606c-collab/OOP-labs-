import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListStatsDemo {
    public static void main(String[] args) {
        // 1) Build the list
        List<Integer> numbers = new ArrayList<>();
        numbers.add(42);
        numbers.add(7);
        numbers.add(95);
        numbers.add(13);
        numbers.add(58);
        numbers.add(21);
        numbers.add(76);
        numbers.add(3);
        numbers.add(88);
        numbers.add(31);

        System.out.println("Original list: " + numbers);

        // 2) Sum
        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }
        System.out.println("Sum: " + sum);

        // 3) Maximum — classic "find the max" pattern
        int max = numbers.get(0);
        for (int n : numbers) {
            if (n > max) {
                max = n;
            }
        }
        System.out.println("Maximum: " + max);

        // 4a) Reverse with Collections.reverse() — modifies the list
        List<Integer> reversed = new ArrayList<>(numbers); // copy first
        Collections.reverse(reversed);
        System.out.println("Reversed (copy): " + reversed);

        // 4b) Reverse by looping backwards — does NOT modify the list
        System.out.print("Reversed (loop): [");
        for (int i = numbers.size() - 1; i >= 0; i--) {
            System.out.print(numbers.get(i));
            if (i > 0) System.out.print(", ");
        }
        System.out.println("]");

        System.out.println("Original still intact: " + numbers);
    }
}