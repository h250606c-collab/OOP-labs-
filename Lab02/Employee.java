public class Employee {

    // static: shared counter for auto-incrementing IDs
    private static int nextId = 1;

    private final int employeeId;
    private String name;
    private String department;
    private double salary;

    // Constructor 1: full
    public Employee(String name, String department, double salary) {
        this.employeeId = nextId++;   // assign current, then bump
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Constructor 2: name + department (salary defaults to 0)
    public Employee(String name, String department) {
        this(name, department, 0.0);   // chain to constructor 1
    }

    // Constructor 3: name only
    public Employee(String name) {
        this(name, "Unassigned", 0.0); // chain to constructor 1
    }

    // Copy constructor: same data, but a NEW id (independent employee)
    public Employee(Employee other) {
        this(other.name, other.department, other.salary);  // gets a new ID
    }

    public int getEmployeeId()   { return employeeId; }
    public String getName()      { return name; }
    public String getDepartment(){ return department; }
    public double getSalary()    { return salary; }

    public void display() {
        System.out.printf("ID=%d | %s | %s | $%.2f%n",
            employeeId, name, department, salary);
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Tariro", "IT", 4200);
        Employee e2 = new Employee("Farai", "HR");
        Employee e3 = new Employee("Rudo");

        Employee e4 = new Employee(e1);   // copy of e1

        System.out.println("--- Employees ---");
        e1.display();
        e2.display();
        e3.display();
        e4.display();

        System.out.println("\ne1 and e4 same object? " + (e1 == e4));
        System.out.println("e1 id = " + e1.getEmployeeId()
            + ", e4 id = " + e4.getEmployeeId());
    }
}
