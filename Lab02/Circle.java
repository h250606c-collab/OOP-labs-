public class Circle {

    // static field -> shared by all Circle objects
    private static int count = 0;

    private double radius;

    // Constructor 1: takes a radius
    public Circle(double radius) {
        this.radius = radius;
        count++;   // every new Circle bumps the shared count
    }

    // Constructor 2: no-arg -> chains to the first with a default
    public Circle() {
        this(1.0);   // count++ happens in the first constructor
    }

    // static getter: callable as Circle.getCount(), no object needed
    public static int getCount() {
        return count;
    }

    public double getRadius() {
        return radius;
    }

    public static void main(String[] args) {
        System.out.println("Count before: " + Circle.getCount());

        Circle c1 = new Circle(5.0);
        Circle c2 = new Circle();
        Circle c3 = new Circle(3.5);

        System.out.println("c1 radius: " + c1.getRadius());
        System.out.println("c2 radius: " + c2.getRadius());
        System.out.println("c3 radius: " + c3.getRadius());
        System.out.println("Total circles created: " + Circle.getCount());
    }
}