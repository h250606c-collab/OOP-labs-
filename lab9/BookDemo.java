import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Book {
    private final String isbn;
    private final String title;
    private final String author;

    Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String getIsbn()   { return isbn; }
    public String getTitle()  { return title; }
    public String getAuthor() { return author; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                         // same reference
        if (!(o instanceof Book other)) return false;       // null or wrong type
        return Objects.equals(isbn, other.isbn);            // identity = isbn only
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);                          // MUST match equals
    }

    @Override
    public String toString() {
        return title + " by " + author + " (ISBN: " + isbn + ")";
    }
}

public class BookDemo {
    public static void main(String[] args) {
        Book b1 = new Book("978-0134685991", "Effective Java", "Joshua Bloch");
        Book b2 = new Book("978-0134685991", "Effective Java", "Joshua Bloch");
        Book b3 = new Book("978-0134685991", "Different Title", "Different Author");
        Book b4 = new Book("978-0596009205", "Head First Java", "Kathy Sierra");

        System.out.println("--- equals checks ---");
        System.out.println("b1.equals(b2)? " + b1.equals(b2));   // true (same ISBN)
        System.out.println("b1.equals(b3)? " + b1.equals(b3));   // true (same ISBN!)
        System.out.println("b1.equals(b4)? " + b1.equals(b4));   // false
        System.out.println("b1 == b2?       " + (b1 == b2));     // false

        System.out.println("\n--- HashSet deduplication ---");
        Set<Book> books = new HashSet<>();
        books.add(b1);
        books.add(b2);   // duplicate by ISBN -> rejected
        books.add(b3);   // same ISBN as b1 -> rejected
        books.add(b4);   // different ISBN -> added

        System.out.println("Set size: " + books.size());        // 2
        System.out.println("Set contents:");
        for (Book b : books) {
            System.out.println("  " + b);
        }
    }
}