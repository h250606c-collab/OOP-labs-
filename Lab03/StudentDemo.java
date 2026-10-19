public class StudentDemo {
    public static void main(String[] args) {
        Student s = new Student("Tariro", 78);
        System.out.println(s);

        s.setMarks(95);
        System.out.println("Updated: " + s);
System.out.println(s.getName() + " grade: " + s.getGrade());

s.setMarks(65);
System.out.println("After 65: grade = " + s.getGrade());

s.setMarks(45);
System.out.println("After 45: grade = " + s.getGrade());
        // Try an invalid mark
        try {
            s.setMarks(150);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }

        // Try an invalid mark in the constructor
        try {
            new Student("Farai", -5);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected at construction: " + e.getMessage());
        }

        // Try a blank name
        try {
            new Student("   ", 50);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected blank name: " + e.getMessage());
        }
    }
}
