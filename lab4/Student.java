public class Student extends Person {

    private final String course;

    public Student(String name, int age, String course) {
        super(name, age);       // MUST be the first statement
        this.course = course;
    }

    public String getCourse() { return course; }

    @Override
    public void display() {
        super.display();        // reuse the parent's output
        System.out.println("Course: " + course);
    }
}