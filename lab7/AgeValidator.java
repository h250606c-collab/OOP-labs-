public class AgeValidator {

    public static final int MIN_AGE = 0;
    public static final int MAX_AGE = 120;

    public static void validateAge(int age) throws InvalidAgeException {
        if (age < MIN_AGE || age > MAX_AGE) {
            throw new InvalidAgeException(age, MIN_AGE, MAX_AGE);
        }
        // If we get here, age is valid
        System.out.println("Age " + age + " is valid");
    }

    public static void main(String[] args) {
        int[] testAges = { 25, 0, 120, 121, -1, 200 };

        for (int age : testAges) {
            try {
                validateAge(age);
            } catch (InvalidAgeException e) {
                System.out.printf("REJECTED: %s (age=%d, allowed=%d..%d)%n",
                    e.getMessage(), e.getInvalidAge(), e.getMin(), e.getMax());
            }
        }
    }
}