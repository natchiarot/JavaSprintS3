import java.util.ArrayList;

public class Library{

    private ArrayList<Book> books;
    
    // Array to hold patrons.
    private ArrayList<Patron> patrons;

    private ArrayList<Author> authors;

    // Initializing the Library object with a specific list of books.
    public Library(ArrayList<Book> books, ArrayList<Patron> patrons, ArrayList<Author> authors) {
        this.books = books;
        this.patrons = patrons;
        this.authors = authors;
    }

    public ArrayList<Book> searchByTitle(String title) {
        ArrayList<Book> titleResults = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getTitle().equalsIgnoreCase(title)) {
                titleResults.add(book);
            }
        }
        return titleResults;
    }

    public ArrayList<Book> searchByAuthor(String authorName) {
        ArrayList<Book> authorResults = new ArrayList<>();
        for(int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getAuthor().getName().equalsIgnoreCase(authorName)) {
                authorResults.add(book);
            }
        }
        return authorResults;
    }

    public ArrayList<Book> searchByISBN(int ISBN) {
        ArrayList<Book> ISBNResults = new ArrayList<>();
        for(int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getISBN() == ISBN) {
                ISBNResults.add(book);
            }
        }
        return ISBNResults;
    }

    // BOOK HANDLING
    // Method to add a new book to book list.
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to edit an existing book in book list.
    public void editBook(int index, Book book) {
        if (index >= 0 && index < books.size()) {
            books.set(index, book);
        } else {
            System.out.println("Invalid index. Book cannot be edited.");
        }
    }

    // Method to delete a book from book list.
    public void deleteBook(Book book) {
        books.remove(book);
    }

    // AUTHOR HANDLING
    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void editAuthor(int index, Author author) {
        if (index >= 0 && index < authors.size()) {
            authors.set(index, author);
        } else {
            System.out.println("Invalid index. Author cannot be edited.");
        }
    }

    public void deleteAuthor(Author author) {
        authors.remove(author);
    }

    // PATRON HANDLING
    // Method to add a new patron to the patrons list.
    public void addPatron(Patron patron){
        patrons.add(patron);
    }

    // Method to edit an existing patron in patron list.
    public void editPatron(int index, Patron patron) {
        if (index >= 0 && index < patrons.size()) {
        patrons.set(index, patron);
        } else {
            System.out.println("Invalid index. Patron cannot be edited.");
        }
    }

    // Method to delete a patron from the patrons list.
    public void deletePatron(Patron patron) {
        patrons.remove(patron);
    }

    // // Method to get the list of all the patrons.
    // public ArrayList<Patron> getPatrons() {
    //     return patrons;
    // }

    // // Alternative way to show a list of all patrons if I wanted to be able to see all the indexes to know which one to edit.
    // public ArrayList<String> patronsByIndex() {
    //     ArrayList<String> patronsListWithIndex = new ArrayList<>();
    //     for (int i = 0; i < patrons.size(); i++) {
    //         Patron patron = patrons.get(i);
    //         String patronInfo = "Index " + i + ", " + patron.toString();
    //         patronsListWithIndex.add(patronInfo);
    //     }
    //     return patronsListWithIndex;
    // }
}
