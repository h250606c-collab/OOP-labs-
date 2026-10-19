public class FinallyReturnPuzzle {

    static int mystery() {
        try {
            System.out.println("inside try");
            return 1;
        } finally {
            System.out.println("inside finally");
        }
    }

    public static void main(String[] args) {
        int result = mystery();
        System.out.println("result = " + result);
    }
}