public class PersonStudentDemo {
    public static void main(String[] args) {
        Person p = new Person("Tariro", 40);
        Student s = new Student("Farai", 21, "Computer Science");

        System.out.println("--- Person ---");
        p.display();

        System.out.println("--- Student ---");
        s.display();

        // A Student IS-A Person, so this works:
        Person ref = s;
        ref.display();   // uses Student's overridden display()
    }
}