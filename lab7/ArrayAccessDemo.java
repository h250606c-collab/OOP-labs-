public class ArrayAccessDemo {

    // Returns the element at index, or -1 if the index is invalid
    static int safeGet(int[] arr, int index) {
        try {
            return arr[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught: " + e.getMessage());
            return -1;   // sentinel value meaning "no valid element"
        } catch (NullPointerException e) {
            System.out.println("Caught: array is null");
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println("Index 0:  " + safeGet(numbers, 0));    // 10
        System.out.println("Index 4:  " + safeGet(numbers, 4));    // 50
        System.out.println("Index 5:  " + safeGet(numbers, 5));    // caught
        System.out.println("Index -1: " + safeGet(numbers, -1));   // caught
        System.out.println("Null:     " + safeGet(null, 0));       // caught
    }
}