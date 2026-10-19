import java.util.*;

class Student implements Comparable<Student> {
    private final String name;
    private final int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName()  { return name; }
    public int getMarks()    { return marks; }

    // Natural ordering: by name (alphabetical)
    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return name + "(" + marks + ")";
    }
}

public class StudentCompareDemo {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(List.of(
            new Student("Kuda", 65),
            new Student("Ada", 88),
            new Student("Lynn", 72),
            new Student("Ben", 88)
        ));

        // 1) Natural ordering (by name) using Collections.sort
        Collections.sort(students);
        System.out.println("By name (natural):  " + students);

        // 2) Comparator: by marks ascending
        students.sort(Comparator.comparingInt(Student::getMarks));
        System.out.println("By marks asc:       " + students);

        // 3) Comparator: by marks descending, ties broken by name
        students.sort(
            Comparator.comparingInt(Student::getMarks).reversed()
                      .thenComparing(Student::getName)
        );
        System.out.println("By marks desc, then name: " + students);

        // 4) Comparator: by name length, then alphabetical
        students.sort(
            Comparator.comparingInt((Student s) -> s.getName().length())
                      .thenComparing(Student::getName)
        );
        System.out.println("By name length:     " + students);
    }
}
