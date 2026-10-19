public class ImmutablePersonDemo {
    public static void main(String[] args) {
        ImmutablePerson p1 = new ImmutablePerson("Tariro", 21);
        System.out.println("p1 = " + p1);

        // "Changing" p1 actually creates a new object
        ImmutablePerson p2 = p1.withAge(22);
        System.out.println("p1 = " + p1);   // unchanged
        System.out.println("p2 = " + p2);   // new object

        System.out.println("p1 == p2? " + (p1 == p2));   // false

        // No setter exists to break this:
        // p1.age = 99;   // COMPILE ERROR
    }
}
