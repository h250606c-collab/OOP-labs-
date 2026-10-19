public class StackDemo {
    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        s.push("a");
        s.push("b");
        s.push("c");

        System.out.println("Stack: " + s);
        System.out.println("peek: " + s.peek());
        System.out.println("pop:  " + s.pop());
        System.out.println("Stack: " + s);
        System.out.println("size: " + s.size());

        // These lines do NOT compile — the methods don't exist:
        // s.add(0, "sneaky");
        // s.remove(0);
        // s.clear();
        // s.set(0, "x");
    }
}
