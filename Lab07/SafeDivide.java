import java.util.InputMismatchException;
import java.util.Scanner;

public class SafeDivide {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter first number:  ");
            int a = scanner.nextInt();

            System.out.print("Enter second number: ");
            int b = scanner.nextInt();

            int result = a / b;
            System.out.println(a + " / " + b + " = " + result);

        } catch (InputMismatchException e) {
            System.out.println("Error: you must enter whole numbers (e.g. 10, -3)");
        } catch (ArithmeticException e) {
            System.out.println("Error: cannot divide by zero");
        } finally {
            scanner.close();
            System.out.println("(scanner closed)");
        }
    }
}