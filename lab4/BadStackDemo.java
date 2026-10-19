public class BadStackDemo {
    public static void main(String[] args) {
        BadStack s = new BadStack();
        s.push("a");
        s.push("b");
        s.push("c");

        System.out.println("After pushes: " + s);   // [a, b, c]

        // Illegal for a stack, but perfectly legal because Stack IS-A ArrayList
        s.add(0, "sneaky");
        System.out.println("After sneaky add: " + s); // [sneaky, a, b, c]

        s.remove(0);
        System.out.println("After removing bottom: " + s); // [a, b, c]

        s.clear();
        System.out.println("After clear: " + s);    // []
    }
}
