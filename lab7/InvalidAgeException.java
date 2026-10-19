public class InvalidAgeException extends Exception {

    private final int invalidAge;
    private final int min;
    private final int max;

    public InvalidAgeException(int invalidAge, int min, int max) {
        super(String.format(
            "Age %d is out of range [%d, %d]", invalidAge, min, max));
        this.invalidAge = invalidAge;
        this.min = min;
        this.max = max;
    }

    public int getInvalidAge() { return invalidAge; }
    public int getMin()        { return min; }
    public int getMax()        { return max; }
}