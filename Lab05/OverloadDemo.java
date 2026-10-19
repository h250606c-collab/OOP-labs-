import java.util.Arrays;

public class OverloadDemo {

    void print(int x) {
        System.out.println("int: " + x);
    }

    void print(double x) {
        System.out.println("double: " + x);
    }

    void print(String x) {
        System.out.println("String: " + x);
    }

    void print(int[] x) {
        System.out.println("int[]: " + Arrays.toString(x));
    }

    public static void main(String[] args) {
        OverloadDemo d = new OverloadDemo();

        d.print(42);
        d.print(3.14);
        d.print("hello");
        d.print(new int[]{1, 2, 3, 4, 5});

        // Compiler picks the BEST match:
        d.print(100);       // int overload
        d.print(100.0);     // double overload (not int, despite being a whole number)
        d.print('A');       // 'A' is a char -> widens to int -> int overload
    }
}
