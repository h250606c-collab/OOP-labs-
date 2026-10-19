public class AliasingDemo {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        r1.width = 5;
        r1.height = 10;

        System.out.println("Before aliasing:");
        System.out.println("r1.width = " + r1.width);

        // r2 copies the REFERENCE, not the object
        Rectangle r2 = r1;

        r2.width = 99;

        System.out.println("\nAfter r2.width = 99:");
        System.out.println("r1.width = " + r1.width);   // 99, not 5!
        System.out.println("r2.width = " + r2.width);   // 99
        System.out.println("r1 == r2? " + (r1 == r2));  // true
    }
}
