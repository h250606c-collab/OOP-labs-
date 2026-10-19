public class Intern extends Employee {

    private static final double STIPEND = 500.0;

    public Intern(String name) {
        super(name, 0);     // interns have no base salary
    }

    @Override
    public double calculatePay() {
        return STIPEND;     // fixed stipend regardless of the base salary
    }
}
