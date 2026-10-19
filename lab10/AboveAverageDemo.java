import java.util.List;

public class AboveAverageDemo {

    record Student(String name, double marks) {}

    public static void main(String[] args) {
        List<Student> students = List.of(
            new Student("Tariro",  78.0),
            new Student("Farai",   62.5),
            new Student("Rudo",    91.0),
            new Student("Kudzai",  55.0),
            new Student("Nyasha",  84.5),
            new Student("Chipo",   70.0),
            new Student("Tendai",  88.0)
        );

        // 1) Compute the class average — one pass over the list
        double average = students.stream()
            .mapToDouble(Student::marks)     // convert to a DoubleStream
            .average()
            .orElse(0);                      // avoid Optional issue on empty list

        System.out.printf("Class average: %.2f%n%n", average);

        // 2) Filter for students above the average, sort by name, print
        System.out.println("Students above average (alphabetical):");
        students.stream()
            .filter(s -> s.marks() > average)      // above average
            .map(Student::name)                    // we only need names
            .sorted()                              // alphabetical (natural order)
            .forEach(name -> System.out.println("  " + name));

        // 3) Bonus: also print how many were above average
        long count = students.stream()
            .filter(s -> s.marks() > average)
            .count();
        System.out.println("\nTotal above average: " + count + " out of " + students.size());
    }
}