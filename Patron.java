import java.util.ArrayList;

/**
 * The Patron class represents a library patron who can borrow and return books.
 */
public class Patron {
    private String name;
    private String address;
    private String phoneNum;
    private ArrayList<Book> borrowedBookList;

    // Static array to hold patrons.
    private static ArrayList<Patron> patrons = new ArrayList<>();

    /**
     * Constructs a new Patron object with the specified name, address, and phone number.
     * @param name The name of the patron.
     * @param address The address of the patron.
     * @param phoneNum The phone number of the patron.
     */
    public Patron(String name, String address, String phoneNum){
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.borrowedBookList = new ArrayList<>();
    }

    // Getter methods.
    /**
     * Retrieves the address of the patron.
     * @return The address of the patron.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Retrieves the list of books borrowed by the patron.
     * @return The list of books borrowed by the patron.
     */
    public ArrayList<Book> getBorrowedBookList() {
        return borrowedBookList;
    }

    /**
     * Retrieves the name of the patron.
     * @return The name of the patron.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the phone number of the patron.
     * @return The phone number of the patron.
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    // Setter methods.
    /**
     * Sets the address of the patron.
     * @param address The new address of the patron.
     */
    public void setAddress(String address) {
        this.address = address;
    }

     /**
     * Sets the list of books borrowed by the patron.
     * @param borrowedBookList The new list of books borrowed by the patron.
     */
    public void setBorrowedBookList(ArrayList<Book> borrowedBookList) {
        this.borrowedBookList = borrowedBookList;
    }

    /**
     * Sets the name of the patron.
     * @param name The new name of the patron.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the phone number of the patron.
     * @param phoneNum The new phone number of the patron.
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    // Method to add a new patron to the patrons list.
    public static void addPatron(Patron patron){
        patrons.add(patron);
    }

    // Method to edit an existing patron in patron list.
    public static void editPatron(int index, Patron patron) {
        if (index >= 0 && index < patrons.size()) {
        patrons.set(index, patron);
        } else {
            System.out.println("Invalid index. Patron cannot be edited.");
        }
    }

    // Method to delete a patron from the patrons list.
    public static void deletePatron(Patron patron) {
        patrons.remove(patron);
    }

    // Method to get the list of all the patrons.
    public static ArrayList<Patron> getPatrons() {
        return patrons;
    }
    
    /**
     * Searches the list of borrowed books by title.
     * @param title The title of the book to search for.
     * @return An ArrayList of books matching the title.
     */
    public ArrayList<Book> searchBorrowedBookTitle(String title) {
        ArrayList<Book> titleBorrowResults = new ArrayList<>();
        for (int i = 0; i < borrowedBookList.size(); i++) {
            Book book = borrowedBookList.get(i);
            if (book.getTitle().equalsIgnoreCase(title)) {
                titleBorrowResults.add(book);
            }
        }
        return titleBorrowResults;
    }

    /**
     * Searches the list of borrowed books by author name.
     * @param authorName The name of the author to search for.
     * @return An ArrayList of books by the specified author.
     */
    public ArrayList<Book> searchBorrowedBookAuthor(String authorName) {
        ArrayList<Book> authorBorrowResults = new ArrayList<>();
        for(int i = 0; i < borrowedBookList.size(); i++) {
            Book book = borrowedBookList.get(i);
            if (book.getAuthor().getName().equalsIgnoreCase(authorName)) {
                authorBorrowResults.add(book);
            }
        }
        return authorBorrowResults;
    }

    /**
     * Searches the list of borrowed books by ISBN.
     * @param ISBN The ISBN of the book to search for.
     * @return The book matching the specified ISBN, or null if not found.
     */
    public Book searchBorrowedBookISBN(long ISBN) {
        for(int i = 0; i < borrowedBookList.size(); i++) {
            Book book = borrowedBookList.get(i);
            if (book.getISBN() == ISBN) {
                return book;
            }
        }
        return null;  // Book was not found.
    }

    /**
     * Borrows a specified number of copies of a book.
     * @param book The book to be borrowed.
     * @param numCopies The number of copies to borrow.
     */
    public void borrowBook(Book book, int numCopies) {
           for (int i = 0; i < numCopies; i++) {
            borrowedBookList.add(book);
           }
        // }
    }

    /**
     * Returns a specified number of copies of a book.
     * @param book The book to be returned.
     * @param numCopies The number of copies to return.
     */
    public void returnBook(Book book, int numCopies) {
        for(int i = 0; i < numCopies; i++) {
            borrowedBookList.remove(book);
        }
    }

    /**
     * Returns a string representation of the Patron object, including the name, address,
     * phone number, and list of borrowed books.
     * @return A string containing the name, address, phone number, and list of borrowed books.
     */
    @Override
    public String toString() {
        return(this.name + ", " + this.address + ", " + this.phoneNum + ", \n List of Books Borrowed: " + this.borrowedBookList + "\n");
    }
}