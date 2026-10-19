public class InitOrder2 {

    // --- STATIC parts (run once, at class load) ---
    static int a = show("static field 1");
    static { show("static block 1"); }
    static int b = show("static field 2");
    static { show("static block 2"); }

    // --- INSTANCE parts (run every time an object is made) ---
    int c = show("instance field 1");
    { show("instance block 1"); }
    int d = show("instance field 2");
    { show("instance block 2"); }

    InitOrder2() {
        show("constructor");
    }

    static int show(String msg) {
        System.out.println(msg);
        return 1;
    }

    public static void main(String[] args) {
        System.out.println("--- creating first object ---");
        new InitOrder2();

        System.out.println("--- creating second object ---");
        new InitOrder2();
    }
}
