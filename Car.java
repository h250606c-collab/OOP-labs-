public class Car {

    String brand;
    int year;
    double mileage;

    void display() {
        System.out.println(brand + " (" + year + ") - " + mileage + " km");
    }

    boolean isAntique() {
        return (2026 - year) > 25;
    }

    public static void main(String[] args) {
        Car c1 = new Car();
        c1.brand = "Toyota";
        c1.year = 2015;
        c1.mileage = 85000;

        Car c2 = new Car();
        c2.brand = "Honda";
        c2.year = 2020;
        c2.mileage = 32000;

        Car c3 = new Car();
        c3.brand = "Ford";
        c3.year = 1998;
        c3.mileage = 210000;

        c1.display();
        c2.display();
        c3.display();

        System.out.println(c1.brand + " antique? " + c1.isAntique());
        System.out.println(c2.brand + " antique? " + c2.isAntique());
        System.out.println(c3.brand + " antique? " + c3.isAntique());
    }
}

   