public class RecordDemo {

    record Student(String name, int age) {

        // Compact constructor: validation runs before fields are set
        Student {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("Name required");
            }
            if (age < 0 || age > 150) {
                throw new IllegalArgumentException("Age must be 0-150, got: " + age);
            }
        }

        // Extra method (not a component)
        boolean isAdult() {
            return age >= 18;
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("Tariro", 21);
        Student s2 = new Student("Tariro", 21);
        Student s3 = new Student("Farai", 19);

        // toString is generated
        System.out.println("s1 = " + s1);
        System.out.println("s3 = " + s3);

        // equals is generated — compares by VALUE
        System.out.println("s1.equals(s2)? " + s1.equals(s2));   // true
        System.out.println("s1.equals(s3)? " + s1.equals(s3));   // false
        System.out.println("s1 == s2?       " + (s1 == s2));     // false (different objects)

        // Accessors — note the names match the components
        System.out.println("Name: " + s1.name());
        System.out.println("Age:  " + s1.age());

        // Extra method works
        System.out.println("s1 adult? " + s1.isAdult());
        System.out.println("s3 adult? " + s3.isAdult());

        // Validation is enforced in the constructor
        try {
            new Student("", 20);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }

        try {
            new Student("Rudo", 200);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}