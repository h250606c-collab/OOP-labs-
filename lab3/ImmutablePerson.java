public final class ImmutablePerson {

    private final String name;
    private final int age;

    public ImmutablePerson(String name, int age) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name required");
        }
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Age must be 0-150, got: " + age);
        }
        this.name = name.trim();
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge()     { return age; }

    // "With-er" methods: return a NEW object with one changed value
    // (the original stays untouched)
    public ImmutablePerson withName(String newName) {
        return new ImmutablePerson(newName, this.age);
    }

    public ImmutablePerson withAge(int newAge) {
        return new ImmutablePerson(this.name, newAge);
    }

    @Override
    public String toString() {
        return "ImmutablePerson(" + name + ", " + age + ")";
    }
}
