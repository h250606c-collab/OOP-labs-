import java.util.Arrays;

public class GenericBubbleSort {

    // Generic method with a bounded type parameter
    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;              // optimisation: early exit
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    // swap arr[j] and arr[j+1]
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;                  // already sorted
        }
    }

    public static void main(String[] args) {
        // --- Integer[] ---
        Integer[] ints = { 5, 2, 9, 1, 5, 6, 3 };
        System.out.println("Before: " + Arrays.toString(ints));
        bubbleSort(ints);
        System.out.println("After:  " + Arrays.toString(ints));

        // --- String[] ---
        String[] words = { "pear", "apple", "zebra", "mango", "banana" };
        System.out.println("\nBefore: " + Arrays.toString(words));
        bubbleSort(words);
        System.out.println("After:  " + Arrays.toString(words));

        // --- The type bound in action ---
        // Object[] objs = { new Object(), new Object() };
        // bubbleSort(objs);   // ❌ COMPILE ERROR: Object is not Comparable
    }
}