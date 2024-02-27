import java.util.ArrayList;
import java.util.Scanner;

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

    public Book searchByISBN(int ISBN) {
        for(int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getISBN() == ISBN) {
                return book;
            }
        }
        return null;  // Book was not found.
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

    // Note** need to handle logic for searching for the books by specific type.
    public void borrowBook(Patron patron, Book book, String searchType, String searchTerm, int numCopies) {
        ArrayList<Book> searchResults = null;
        switch(searchType.toLowerCase()) {
            case "title":
                searchResults = searchByTitle(searchTerm);
                break;
            case "author":
                searchResults = searchByAuthor(searchTerm);
                break;
            // ISBN although should* always only return a single book i used an ArrayList so it remains consistent with the other search methods.
            case "isbn":
            searchResults = new ArrayList<>();  // New ArrayList to hold search results.
                book = searchByISBN(Integer.parseInt(searchTerm));
                if(book != null) {
                    searchResults.add(book);
                }
                break;
            default:
                System.out.println("Invalid search type.");
                break;
        }

        if(searchResults != null && !searchResults.isEmpty()) {
            // Display search results
            System.out.println("Search results: ");
            for (int i = 0; i < numCopies; i++) {
                System.out.println(book.toString());
            }
            Scanner scanner = new Scanner(System.in);

            // Assumes first book*
            Book selectedBook = searchResults.get(0);
            System.out.println("Enter the amount of copies of " + selectedBook.getTitle() + " you would like to borrow: ");

            numCopies = Integer.parseInt(scanner.nextLine());
            scanner.close();
            
            selectedBook.borrowBook(selectedBook, numCopies);
            patron.borrowBook(selectedBook, numCopies);
        } else {
            System.out.println("No books found matching search criteria.");
        }

    }

    // Note** need to allow patrons to search through borrowed books*.
    public void returnBook(Patron patron, Book book, String searchType, String searchTerm, int numCopies) {
            ArrayList<Book> searchResults = null;
            switch(searchType.toLowerCase()) {
                case "title":
                    searchResults = searchByTitle(searchTerm);
                    break;
                case "author":
                    searchResults = searchByAuthor(searchTerm);
                    break;
                // ISBN although should* always only return a single book i used an ArrayList so it remains consistent with the other search methods.
                case "isbn":
                searchResults = new ArrayList<>();  // New ArrayList to hold search results.
                    Book resultBook = searchByISBN(Integer.parseInt(searchTerm));
                    if(resultBook != null) {
                        searchResults.add(resultBook);
                    }
                    break;
                default:
                    System.out.println("Invalid search type.");
                    break;
            }
    
            if(searchResults != null && !searchResults.isEmpty()) {
                // Display search results
                System.out.println("Search results: ");
                for (int i = 0; i < searchResults.size(); i++) {
                    Book resultBook = searchResults.get(i);
                    System.out.println(resultBook.toString());
                }
                
                Scanner scanner = new Scanner(System.in);
    
                // Assumes first book*
                Book selectedBook = searchResults.get(0);
                System.out.println("Enter the amount of copies of " + selectedBook.getTitle() + " you would like to return: ");

                int copiesToReturn = Integer.parseInt(scanner.nextLine());
    
                scanner.close();

                for (int i = 0; i < searchResults.size(); i++) {
                    Book resultBook = searchResults.get(i);
                    resultBook.returnBook(resultBook, copiesToReturn);
                    patron.returnBook(resultBook, copiesToReturn);
                }
                
            } else {
                System.out.println("No books found matching search criteria.");
            }
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
