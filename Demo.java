import java.util.ArrayList;
import java.time.LocalDate;

/**
 * A class to demonstrate the functionality of the Library system.
 */
public class Demo {

    /**
     * The main method to execute the demonstration.
     * 
     * @param args The command-line arguments (not used in this demonstration).
     */
    public static void main(String[] args) {
    // Creating mock data for testing

        // Creating authors
        Author author1 = new Author("John Doe", LocalDate.of(1980, 5, 15), new ArrayList<>());
        Author author2 = new Author("Jane Smith", LocalDate.of(1999, 2, 25), new ArrayList<>());

        // Creating books
        Book book1 = new Book("Book 1", author1, 1234567890L, "Publisher 1", 5);
        Book book2 = new Book("Book 2", author2, 2345678901L, "Publisher 2", 3);

        // Creating patrons
        Patron patron1 = new Patron("Alice", "123 Main St", "555-123-4567");
        Patron patron2 = new Patron("Bob", "456 Elm St", "555-987-6543");

        // Creating library
        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);

        ArrayList<Author> authors = new ArrayList<>();
        authors.add(author1);
        authors.add(author2);

        ArrayList<Patron> patrons = new ArrayList<>();
        patrons.add(patron1);
        patrons.add(patron2);

        Library library = new Library(books, patrons, authors);

        // Testing borrowing and returning books
        library.borrowBook(patron1, book1, "title", "Book 1", 2);
        library.borrowBook(patron2, book2, "title", "Book 2", 2);

        for (Book book : library.getBooks()) {
            book.updateStatus();
        }

        library.returnBook(patron1, book1, "title", "Book 1", 2);
        library.returnBook(patron2, book2, "title", "Book 2", 2);

        for (Book book : library.getBooks()) {
            book.updateStatus();
        }

        System.out.println("Library data:");

// Print books
System.out.println("\nBooks:");
for (Book book : library.getBooks()) {
    System.out.println("Title: " + book.getTitle());
    System.out.println("Author: " + book.getAuthor().getName());
    System.out.println("ISBN: " + book.getISBN());
    System.out.println("Publisher: " + book.getPublisher());
    System.out.println("Copies number: " + book.getCopiesNum());
    System.out.println("Status: " + book.getStatus());
    System.out.println();
}

// Print authors
System.out.println("\nAuthors:");
for (Author author : library.getAuthors()) {
    System.out.println("Name: " + author.getName());
    System.out.println("Date of Birth: " + author.getDOB());
    // Print other attributes of the author if needed
    System.out.println();
}

// Print patrons
System.out.println("\nPatrons:");
for (Patron patron : library.getPatrons()) {
    System.out.println("Name: " + patron.getName());
    System.out.println("Address: " + patron.getAddress());
    System.out.println("Phone: " + patron.getPhoneNum());
    // Print list of borrowed books if needed
    System.out.println("List of Books Borrowed: " + patron.getBorrowedBookList());
    System.out.println();
}
    }
}
