public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.addLast("Alice");
        list.addLast("Bob");
        list.addLast("Cara");
        list.addFirst("Zodwa");      // goes to the front

        System.out.println("Size: " + list.size());
        System.out.println("Empty? " + list.isEmpty());

        // for-each loop uses our iterator
        System.out.println("\n--- for-each ---");
        for (String name : list) {
            System.out.println("  " + name);
        }

        // Explicit iterator usage
        System.out.println("\n--- explicit iterator ---");
        var it = list.iterator();
        while (it.hasNext()) {
            System.out.println("  " + it.next());
        }

        // Empty list behaviour
        LinkedList<Integer> empty = new LinkedList<>();
        System.out.println("\n--- empty list ---");
        System.out.println("Empty? " + empty.isEmpty());
        System.out.println("Size: " + empty.size());
        for (Integer n : empty) {
            System.out.println("never printed: " + n);
        }
        System.out.println("(loop skipped for empty list)");

        // Exception on next() past the end
        System.out.println("\n--- next() past end ---");
        try {
            empty.iterator().next();
        } catch (java.util.NoSuchElementException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}