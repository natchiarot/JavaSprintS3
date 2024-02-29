import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Represents an author with their name, date of birth, and a list of books authored.
 */
public class Author{
    private String name; 
    private LocalDate DOB; 
    private ArrayList<Book> bookList; 
    
    /**
     * Constructs an Author object with the specified name, date of birth, and list of books authored.
     * 
     * @param name The name of the author.
     * @param DOB The date of birth of the author.
     * @param bookList The list of books authored by the author.
     */
    public Author(String name, LocalDate DOB, ArrayList<Book> bookList) {
        this.name = name;
        this.DOB = DOB;
        this.bookList = bookList;
    }

    /**
     * Constructs an Author object with the specified name.
     * @param name The name of the author.
     */
    public Author(String name) {
        this.name = name;
    }

    /**
     * Gets the list of books authored by the author.
     * @return The list of books authored by the author.
     */
    public ArrayList<Book> getBookList() {
        return new ArrayList<>(bookList);
    }

    /**
     * Adds a book to the list of books authored by the author.
     * 
     * @param book The book to add.
     */
    public void addBook(Book book) {
        bookList.add(book);
    }

    /**
     * Removes a book from the list of books authored by the author.
     * 
     * @param book The book to remove.
     */
    public void removeBook(Book book) {
        bookList.remove(book);
    }

    /**
     * Gets the date of birth of the author.
     * 
     * @return The date of birth of the author.
     */
    public LocalDate getDOB() {
        return DOB;
    }

    /**
     * Gets the name of the author.
     * @return The name of the author.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets the list of books authored by the author.
     * @param bookList The list of books authored by the author.
     */
    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    /**
     * Sets the date of birth of the author.
     * @param DOB The date of birth of the author.
     */
    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    /**
     * Sets the name of the author.
     * @param name The name of the author.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
    * Returns a string representation of the Author object.
    * 
    * @return A string containing the author's name, date of birth, and list of books authored.
    */
    @Override
    public String toString() {
        return(this.name + ", " + this.DOB + ", \n List of Books: " + this.bookList);
    }
}
