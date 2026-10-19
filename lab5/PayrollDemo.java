public class PayrollDemo {
    public static void main(String[] args) {
        Employee[] staff = {
            new Employee("Kudzai", 2000),
            new Manager("Nyasha", 3500, 800),
            new Developer("Tatenda", 3000, 10),
            new Intern("Rudo")
        };

        System.out.println("--- Payroll ---");
        double total = 0;
        for (Employee e : staff) {
            double pay = e.calculatePay();       // dynamic dispatch
            System.out.printf("%-10s %10.2f%n", e.getName(), pay);
            total += pay;
        }

        System.out.println("---------------------");
        System.out.printf("TOTAL     %10.2f%n", total);
    }
}
