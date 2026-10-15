public class Rectangle {

    double width;
    double height;

    double area() {
        return width * height;
    }

    double perimeter() {
        return 2 * (width + height);
    }

    void display() {
        System.out.println("Rectangle " + width + " x " + height
            + " -> area=" + area() + ", perimeter=" + perimeter());
    }

    public static void main(String[] args) {
        // Create an array of 5 rectangles
        Rectangle[] rectangles = new Rectangle[5];

        // Each slot is null until we create an object for it
        rectangles[0] = new Rectangle();
        rectangles[0].width = 4;
        rectangles[0].height = 5;

        rectangles[1] = new Rectangle();
        rectangles[1].width = 10;
        rectangles[1].height = 3;

        rectangles[2] = new Rectangle();
        rectangles[2].width = 7;
        rectangles[2].height = 7;

        rectangles[3] = new Rectangle();
        rectangles[3].width = 2;
        rectangles[3].height = 8;

        rectangles[4] = new Rectangle();
        rectangles[4].width = 6;
        rectangles[4].height = 6;

        // Print all of them
        System.out.println("--- All rectangles ---");
        for (Rectangle r : rectangles) {
            r.display();
        }

        // Find the one with the largest area
        Rectangle largest = rectangles[0];
        for (Rectangle r : rectangles) {
            if (r.area() > largest.area()) {
                largest = r;
            }
        }

        System.out.println("--- Largest area ---");
        largest.display();
    }
}
