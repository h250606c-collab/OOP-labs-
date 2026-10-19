interface Greeter {
    default void hello() {
        System.out.println("Hello from Greeter");
    }
}

interface Welcomer {
    default void hello() {
        System.out.println("Hello from Welcomer");
    }
}

// Option A: delegate to one interface
class PersonA implements Greeter, Welcomer {
    @Override
    public void hello() {
        Greeter.super.hello();      // pick Greeter's version
    }
}

// Option B: call BOTH
class PersonB implements Greeter, Welcomer {
    @Override
    public void hello() {
        Greeter.super.hello();
        Welcomer.super.hello();
    }
}

// Option C: fully custom
class PersonC implements Greeter, Welcomer {
    @Override
    public void hello() {
        System.out.println("Hello from PersonC");
    }
}

public class DiamondDemo {
    public static void main(String[] args) {
        System.out.println("--- PersonA (delegates to Greeter) ---");
        new PersonA().hello();

        System.out.println("--- PersonB (calls both) ---");
        new PersonB().hello();

        System.out.println("--- PersonC (fully custom) ---");
        new PersonC().hello();
    }
}