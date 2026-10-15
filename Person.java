public class Person {
    String name;
    Address address;   // a Person HAS an Address (composition)

    void display() {
        System.out.println("Name: " + name);
        if (address != null) {
            System.out.print("Address: ");
            address.display();
        } else {
            System.out.println("Address: (none on file)");
        }
    }

    public static void main(String[] args) {
        // --- Case 1: person WITH an address ---
        Address a = new Address();
        a.street = "12 Samora Machel Ave";
        a.city = "Harare";
        a.country = "Zimbabwe";

        Person p1 = new Person();
        p1.name = "Tariro";
        p1.address = a;

        System.out.println("--- Person with address ---");
        p1.display();

        // Chained dot expression: person -> address -> city
        System.out.println("City (chained): " + p1.address.city);

        // --- Case 2: person WITHOUT an address ---
        Person p2 = new Person();
        p2.name = "Farai";
        // p2.address stays null

        System.out.println("\n--- Person without address ---");
        p2.display();

        // Safely access the city only if address is not null
        if (p2.address != null) {
            System.out.println("City (chained): " + p2.address.city);
        } else {
            System.out.println("Cannot print city - no address on file");
        }

        // The dangerous version (uncomment to see NullPointerException):
        // System.out.println(p2.address.city);
    }
}
