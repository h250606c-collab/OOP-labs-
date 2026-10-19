public class Teacher extends Person {

    private final String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);       // reuse Person's constructor
        this.subject = subject;
    }

    public String getSubject() { return subject; }

    @Override
    public void display() {
        super.display();        // reuse Person's output
        System.out.println("Subject: " + subject);
    }
}
