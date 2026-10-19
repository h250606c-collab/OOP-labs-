class Animal {
    String type = "Animal";                              // field
    void speak() { System.out.println("..."); }          // method
    static void info() { System.out.println("Animal info"); }
}

class Dog extends Animal {
    String type = "Dog";                                 // HIDES the field
    @Override void speak() { System.out.println("Woof"); }
    void fetch() { System.out.println("Fetching..."); }
    static void info() { System.out.println("Dog info"); } // HIDES
}

public class CastingDemo {
    public static void main(String[] args) {
        Animal a = new Dog();            // upcast (implicit, always safe)

        a.speak();                       // Woof -> method IS polymorphic
        System.out.println(a.type);      // Animal -> field follows DECLARED type
        a.info();                        // Animal info -> static follows DECLARED type

        // a.fetch();                    // COMPILE ERROR: Animal has no fetch()

        if (a instanceof Dog d) {        // pattern matching (Java 16+)
            d.fetch();
        }

        Animal plain = new Animal();
        if (!(plain instanceof Dog)) {
            System.out.println("plain is not a Dog; downcast avoided");
        }
    }
}