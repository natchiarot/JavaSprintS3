import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Represents an author with their name, date of birth, and a list of books authored.
 */
public class Author{
    private String name; 
    private LocalDate DOB; 
    private ArrayList<Book> bookList; 

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

    // Note** methods to add and remove books from the author's book list.
    public void addBook(Book book) {
        bookList.add(book);
    }

    public void removeBook(Book book) {
        bookList.remove(book);
    }

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

    @Override
    public String toString() {
        return(this.name + ", " + this.DOB + ", \n List of Books: " + this.bookList);
    }
}
