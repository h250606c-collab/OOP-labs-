public class GenericStackDemo {
    public static void main(String[] args) {

        // --- Stack of Strings ---
        GenericStack<String> s = new GenericStack<>();
        System.out.println("empty? " + s.isEmpty());

        s.push("first");
        s.push("second");
        s.push("third");
        System.out.println("stack: " + s);           // [first, second, third]
        System.out.println("size: " + s.size());
        System.out.println("peek: " + s.peek());     // third
        System.out.println("pop:  " + s.pop());      // third
        System.out.println("stack after pop: " + s); // [first, second]
        System.out.println("size after pop: " + s.size());

        // --- Stack of Integers ---
        GenericStack<Integer> nums = new GenericStack<>();
        nums.push(10);
        nums.push(20);
        nums.push(30);
        System.out.println("\nint stack: " + nums);
        int total = 0;
        while (!nums.isEmpty()) {
            total += nums.pop();
        }
        System.out.println("sum = " + total);
        System.out.println("empty after draining? " + nums.isEmpty());

        // --- Error case: pop from empty stack ---
        System.out.println("\n--- error case ---");
        GenericStack<Double> empty = new GenericStack<>();
        try {
            empty.pop();
        } catch (IllegalStateException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        // --- Compile-time type safety ---
        GenericStack<String> onlyStrings = new GenericStack<>();
        onlyStrings.push("hello");
        // onlyStrings.push(42);   // ❌ COMPILE ERROR: Integer not allowed
    }
}