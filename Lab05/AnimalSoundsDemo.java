class Animal {
    public void sound() {
        System.out.println("Some generic animal sound");
    }
}

class Cat extends Animal {
    @Override
    public void sound() { System.out.println("Meow"); }
}

class Cow extends Animal {
    @Override
    public void sound() { System.out.println("Moo"); }
}

class Duck extends Animal {
    @Override
    public void sound() { System.out.println("Quack"); }
}

public class AnimalSoundsDemo {
    public static void main(String[] args) {
        Animal[] animals = {
            new Cat(),
            new Cow(),
            new Duck()
        };

        for (Animal a : animals) {
            a.sound();     // dynamic dispatch: picks Cat / Cow / Duck version
        }

        System.out.println();
        System.out.println("--- Also works with an extra animal ---");
        Animal[] more = { new Cat(), new Duck(), new Cow(), new Cat() };
        for (Animal a : more) {
            a.sound();
        }
    }
}
