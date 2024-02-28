<<<<<<< Updated upstream
public class Library{
    
=======
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a library containing books, authors, and patrons.
 */

public class Library{

    // ArrayLists to hold books, patrons and authors.
    private ArrayList<Book> books;
    private ArrayList<Patron> patrons;
    private ArrayList<Author> authors;

     /**
     * Initializes the Library object with specified lists of books, patrons, and authors.
     * @param books List of books in the library.
     * @param patrons List of patrons of the library.
     * @param authors List of authors whose books are available in the library.
     */
    public Library(ArrayList<Book> books, ArrayList<Patron> patrons, ArrayList<Author> authors) {
        this.books = books;
        this.patrons = patrons;
        this.authors = authors;
    }

    // Getters to access respective lists from outside "Library" class.
    /**
     * Retrieves the list of books in the library.
     * @return ArrayList containing the books in the library.
     */
    public ArrayList<Book> getBooks() {
        return books;
    }

    /**
     * Retrieves the list of patrons of the library.
     * @return ArrayList containing the patrons of the library.
     */
    public ArrayList<Patron> getPatrons() {
        return patrons;
    }

    /**
     * Retrieves the list of authors whose books are available in the library.
     * @return ArrayList containing the authors whose books are available in the library.
     */
    public ArrayList<Author> getAuthors() {
        return authors;
    }

    /**
     * Searches for books in the library by title.
     * @param title The title of the book to search for.
     * @return ArrayList containing the books with matching titles.
     */
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

    /**
     * Searches for books in the library by author's name.
     * @param authorName The name of the author whose books to search for.
     * @return ArrayList containing the books written by the specified author.
     */
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

    /**
     * Searches for a book in the library by its ISBN.
     * @param ISBN The ISBN of the book to search for.
     * @return The book with the specified ISBN if found, otherwise null.
     */
    public Book searchByISBN(long ISBN) {
        for(int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getISBN() == ISBN) {
                return book;
            }
        }
        return null;  // Book was not found.
    }

    // BOOK HANDLING
    /**
     * Adds a new book to the library.
     * @param book The book to be added to the library.
     */
    public void addBook(Book book) {
        books.add(book);
    }

     /**
     * Edits an existing book in the library based on its ISBN.
     * @param ISBN The ISBN of the book to be edited.
     * @param updatedBook The updated information of the book.
     */
    public void editBook(int ISBN, Book updatedBook) {
        boolean found = false;
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getISBN() == (ISBN)) {
                books.set(i, updatedBook);
                found = true;
                break;  // Stop searching once the book is found and updated.
            }
        }
        if (!found) {
            System.out.println("Book not found. Cannot be edited.");
        }
    }

    /**
     * Deletes a book from the library.
     * @param book The book to be deleted from the library.
     */
    public void deleteBook(Book book) {
        books.remove(book);
    }

    // AUTHOR HANDLING
    /**
     * Adds a new author to the library.
     * @param author The author to be added to the library.
     */
    public void addAuthor(Author author) {
        authors.add(author);
    }

    /**
     * Edits an existing author in the library based on their name.
     * @param name The name of the author to be edited.
     * @param updatedAuthor The updated information of the author.
     */
    public void editAuthor(String name, Author updatedAuthor) {
        boolean found = false;
        for (int i = 0; i < authors.size(); i++) {
            Author author = authors.get(i);
            if (author.getName().equalsIgnoreCase(name)) {
                authors.set(i, updatedAuthor);
                found = true;
                break;  // Stop searching once the author is found and updated.
            }
        }
        if (!found) {
            System.out.println("Author not found. Cannot be edited.");
        }
    }

    /**
     * Deletes an author from the library.
     * @param author The author to be deleted from the library.
     */
    public void deleteAuthor(Author author) {
        authors.remove(author);
    }

    // PATRON HANDLING
    /**
     * Adds a new patron to the library.
     * @param patron The patron to be added to the library.
     */
    public void addPatron(Patron patron){
        patrons.add(patron);
    }

     /**
     * Edits an existing patron in the library based on their name.
     * @param name The name of the patron to be edited.
     * @param updatedPatron The updated information of the patron.
     */
    public void editPatron(String name, Patron updatedPatron) {
        boolean found = false;
        for (int i = 0; i < patrons.size(); i++) {
            Patron patron = patrons.get(i);
            if (patron.getName().equalsIgnoreCase(name)) {
                patrons.set(i, updatedPatron);
                found = true;
                break;  // Stop searching once the patron is found and updated.
            }
        }
        if (!found) {
            System.out.println("Patron not found. Cannot be edited.");
        }
    }

    /**
     * Deletes a patron from the library.
     * @param patron The patron to be deleted from the library.
     */
    public void deletePatron(Patron patron) {
        patrons.remove(patron);
    }

    /**
     * Allows a patron to borrow a book from the library based on the specified search criteria.
     * @param patron The patron borrowing the book.
     * @param book The book to be borrowed.
     * @param searchType The type of search criteria (title, author, ISBN).
     * @param searchTerm The search term used to find the book.
     * @param numCopies The number of copies to be borrowed.
     */
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
            for (int i = 0; i < searchResults.size(); i++) {
                System.out.println((i + 1) + ". " + searchResults.get(i).toString());
            }

            Scanner scanner = new Scanner(System.in);
            int selectedBookIndex = -1;
            
            System.out.println("Enter the index of the book you would like to borrow: ");

            try {
                selectedBookIndex = Integer.parseInt(scanner.nextLine())-1;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid index.");
                return;
            }

            if (selectedBookIndex < 0 || selectedBookIndex >= searchResults.size()) {
                System.out.println("Invalid index. Please enter a valid index within range.");
                return;
            }
            
            // Get the selected book from search results.
            Book selectedBook = searchResults.get(selectedBookIndex);

            // Borrowing the selected book
            selectedBook.borrowBook(selectedBook, numCopies);
            patron.borrowBook(selectedBook, numCopies);

    } else {
        System.out.println("No books found matching search criteria.");
    }
}

    /**
     * Allows a patron to return a borrowed book to the library based on the specified search criteria.
     * @param patron The patron returning the book.
     * @param book The book to be returned.
     * @param searchType The type of search criteria (title, author, ISBN).
     * @param searchTerm The search term used to find the book.
     * @param numCopies The number of copies to be returned.
     */
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
                    System.out.println((i + 1) + ". " + searchResults.get(i).toString());
                }
                
                // Prompt user to select a book.
                Scanner scanner = new Scanner(System.in);
                int selectedBookIndex = -1;
                
                System.out.println("Enter the index of the book you would like to return: ");
                try {
                    selectedBookIndex = Integer.parseInt(scanner.nextLine()) - 1;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid index.");                
                    return;
                }

                if (selectedBookIndex < 0 || selectedBookIndex >= searchResults.size()) {
                    System.out.println("Invalid index. Please enter a valid index within the range.");                  
                    return;
                }

            // Get the selected book from the search results
            Book selectedBook = searchResults.get(selectedBookIndex);

            // Return selected book.
            selectedBook.returnBook(selectedBook, numCopies);
            patron.returnBook(selectedBook, numCopies);
                
            } else {
                System.out.println("No books found matching search criteria.");
            }
    }
>>>>>>> Stashed changes
}
