interface Flyable {
    void fly();                                   // implicitly public abstract

    default void describeFlight() {               // free for implementers
        System.out.println("I can fly!");
    }
}

class Bird implements Flyable {
    private final String species;
    private final double wingSpan;

    Bird(String species, double wingSpan) {
        this.species = species;
        this.wingSpan = wingSpan;
    }

    @Override
    public void fly() {
        System.out.printf("%s (wingspan %.1f m) is flapping its wings%n",
            species, wingSpan);
    }
}

class Aeroplane implements Flyable {
    private final String model;
    private final int maxAltitude;

    Aeroplane(String model, int maxAltitude) {
        this.model = model;
        this.maxAltitude = maxAltitude;
    }

    @Override
    public void fly() {
        System.out.printf("%s is cruising at %d m%n",
            model, maxAltitude);
    }

    @Override
    public void describeFlight() {                // override the default
        System.out.println("Engines roaring at 30,000 feet");
    }
}

public class FlyableDemo {
    public static void main(String[] args) {
        Flyable[] flyers = {
            new Bird("Eagle", 2.2),
            new Aeroplane("Boeing 737", 11_000),
            new Bird("Sparrow", 0.25)
        };

        for (Flyable f : flyers) {
            f.fly();
            f.describeFlight();
            System.out.println();
        }
    }
}
