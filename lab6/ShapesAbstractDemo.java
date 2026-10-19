abstract class Shape {
    private final String name;

    Shape(String name) { this.name = name; }

    public String getName() { return name; }

    // Abstract — every concrete subclass MUST provide these
    public abstract double area();
    public abstract double perimeter();

    // Concrete — written once, reused by all subclasses
    public String describe() {
        return String.format("%s -> area=%.2f, perimeter=%.2f",
            name, area(), perimeter());
    }
}

class Circle extends Shape {
    private final double radius;
    Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }
    @Override public double area()      { return Math.PI * radius * radius; }
    @Override public double perimeter() { return 2 * Math.PI * radius; }
}

class Rectangle extends Shape {
    private final double width, height;
    Rectangle(double width, double height) {
        super("Rectangle");
        this.width = width;
        this.height = height;
    }
    @Override public double area()      { return width * height; }
    @Override public double perimeter() { return 2 * (width + height); }
}

class Square extends Shape {
    private final double side;
    Square(double side) {
        super("Square");
        this.side = side;
    }
    @Override public double area()      { return side * side; }
    @Override public double perimeter() { return 4 * side; }
}

public class ShapesAbstractDemo {
    public static void main(String[] args) {
        // Shape s = new Shape("X");   // ❌ COMPILE ERROR: Shape is abstract

        Shape[] shapes = {
            new Circle(5),
            new Rectangle(4, 6),
            new Square(3)
        };

        for (Shape s : shapes) {
            System.out.println(s.describe());   // describe() calls area() and perimeter()
        }
    }
}