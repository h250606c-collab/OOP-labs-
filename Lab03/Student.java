public class Student {

    private String name;
    private int marks;

    public Student(String name, int marks) {
        setName(name);       // reuse validation
        setMarks(marks);     // reuse validation
    }

    public String getName() { return name; }
    public int getMarks()   { return marks; }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name required");
        }
        this.name = name.trim();
    }

    public void setMarks(int marks) {
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be 0-100, got: " + marks);
        }
        this.marks = marks;
    }
    public char getGrade() {
    if (marks >= 80) return 'A';
    if (marks >= 70) return 'B';
    if (marks >= 60) return 'C';
    return 'F';
}

    @Override
    public String toString() {
        return name + " (" + marks + ")";
    }
}
