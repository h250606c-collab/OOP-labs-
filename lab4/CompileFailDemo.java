class Animal {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() { return name; }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);            // ✅ correct
    }
}

public class CompileFailDemo {
    public static void main(String[] args) {
        Dog d = new Dog("Rex");
        System.out.println("Dog name: " + d.getName());
    }
}
