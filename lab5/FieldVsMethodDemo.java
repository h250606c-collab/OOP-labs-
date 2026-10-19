class Parent {
    String value = "Parent's field";
    String getValue() { return "Parent's method"; }
}

class Child extends Parent {
    String value = "Child's field";             // HIDES Parent's field
    @Override
    String getValue() { return "Child's method"; }
}

public class FieldVsMethodDemo {
    public static void main(String[] args) {
        Parent ref = new Child();                // upcast

        System.out.println("ref.value    = " + ref.value);
        System.out.println("ref.getValue = " + ref.getValue());
    }
}
