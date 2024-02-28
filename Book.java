import java.util.ArrayList;
import java.time.LocalDate;

/**
 * Represents a book in the library.
 */
public class Book implements BorrowableInterface{
    private String title;            
    private Author author;           
    private long ISBN;               
    private String publisher;       
    private int copiesNum;          
    private Status status;         
    private LocalDate checkedOutDate; 
    private int gracePeriodDays;    
    private int totalCopies;       

    private ArrayList<Book> books = new ArrayList<>();  // List of all books in the library.

    /**
     * Constructs a book with the specified details.
     * @param title The title of the book.
     * @param author The author of the book.
     * @param ISBN The ISBN of the book.
     * @param publisher The publisher of the book.
     * @param copiesNum The number of copies of the book.
     */
    public Book(String title, Author author, long ISBN, String publisher, int copiesNum) {
        this(title, author, ISBN, publisher, copiesNum, Status.AVAILABLE, null, 56, copiesNum); // Call the main constructor with default values. Total copies initialized to copiesNum
    }

    /**
     * Constructs a book with the specified details.
     * @param title The title of the book.
     * @param author The author of the book.
     * @param ISBN The ISBN of the book.
     * @param publisher The publisher of the book.
     * @param copiesNum The number of copies of the book.
     * @param status The status of the book.
     * @param checkedOuDate The date when the book was checked out.
     * @param gracePeriodDays The grace period for returning the book.
     * @param totalCopies The total number of copies of the book.
     */
    public Book(String title, Author author, long ISBN, String publisher, int copiesNum, Status status, LocalDate checkedOuDate, int gracePeriodDays, int totalCopies) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.copiesNum = copiesNum;
        this.status = status;
        this.checkedOutDate = null;
        this.gracePeriodDays = 56;  // 8 weeks (around 2 months.)
        this.totalCopies = totalCopies;
    }

    /**
    * Gets the author of the book.
    * @return The author of the book.
    */
    public Author getAuthor() {
        return author;
    }
    
    /**
     * Gets the number of copies of the book.
    * @return The number of copies of the book.
    */
    public int getCopiesNum() {
        return copiesNum;
    }

    /**
    * Gets the ISBN of the book.
    * @return The ISBN of the book.
    */
    public long getISBN() {
        return ISBN;
    }

    /**
    * Gets the publisher of the book.
    * @return The publisher of the book.
    */
    public String getPublisher() {
        return publisher;
    }

    /**
    * Gets the title of the book.
    * @return The title of the book.
    */
    public String getTitle() {
        return title;
    }

    /**
    * Gets the status of the book.
    * @return The status of the book.
    */
    public Status getStatus() {
        return status;
    }

    /**
    * Gets the date the book was checked out.
    * @return The date the book was checked out.
    */
    public LocalDate getCheckedOutDate() {
        return checkedOutDate;
    }

    /**
    * Gets the grace period in days for the book.
    * @return The grace period in days for the book.
    */
    public int getGracePeriodDays() {
        return gracePeriodDays;
    }

    /**
    * Gets the total number of copies of the book.
    * @return The total number of copies of the book.
    */
    public int getTotalCopies() {
        return totalCopies;
    }
    
    /**
    * Sets the author of the book.
    * @param author The author of the book.
    */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
    * Sets the number of copies of the book.
    * @param copiesNum The number of copies of the book.
    */
    public void setCopiesNum(int copiesNum) {
        this.copiesNum = copiesNum;
    }

    /**
    * Sets the ISBN of the book.
    * @param ISBN The ISBN of the book.
    */
    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    /**
    * Sets the publisher of the book.
    * @param publisher The publisher of the book.
    */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
    * Sets the title of the book.
    * @param title The title of the book.
    */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
    * Sets the status of the book.
    * @param status The status of the book.
    */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
    * Sets the date the book was checked out.
    * @param checkedOutDate The date the book was checked out.
    */
    public void setCheckedOutDate(LocalDate checkedOutDate) {
        this.checkedOutDate = checkedOutDate;
    }

    /**
    * Sets the grace period in days for the book.
    * @param gracePeriodDays The grace period in days for the book.
    */
    public void setGracePeriodDays(int gracePeriodDays) {
        this.gracePeriodDays = gracePeriodDays;
    }

    /**
    * Sets the total number of copies of the book.
    * @param totalCopies The total number of copies of the book.
    */
    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    // From borrowable interface.

    /**
     * Allows a book to be borrowed from the library.
     * @param book The book to be borrowed.
     * @param numCopies The number of copies to be borrowed.
     */
    @Override
    public void borrowBook(Book book, int numCopies) {
        if (book.getCopiesNum() >= numCopies) {
            book.setCopiesNum(book.getCopiesNum() - numCopies);
            book.setStatus(Status.CHECKED_OUT);
            System.out.println(numCopies + " copies of " + book.getTitle() + " were borrowed successfully.");
        } else {
            System.out.println("Not enough copies available to borrow.");
        }
    }

    /**
     * Allows a book to be returned to the library.
     * @param book The book to be returned.
     * @param numCopies The number of copies to be returned.
     */
    @Override
    public void returnBook(Book book, int numCopies) {
        int remainingCopies = book.getCopiesNum() + numCopies;  // Calculate the remaining copies after returning.

        // Check if the remaining copies equals the total number of copies that were borrowed.
        if (remainingCopies <= book.getTotalCopies()) {
            book.setCopiesNum(remainingCopies);
            System.out.println(numCopies + " copies of " + book.getTitle() + " have been returned successfully.");

            // If all copies are returned, set the status to AVAILABLE.
            if (remainingCopies == book.getTotalCopies()) {
                book.setStatus(Status.AVAILABLE);
            } else {
                System.out.println("Number of copies to return exceeds the number of copies borrowed.");
            }
        }
        
    }

    /**
     * Updates the status of the book based on the current date.
     */
    public void updateStatus() {
        LocalDate currentDate = LocalDate.now();
        for(int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            LocalDate checkedOutDate = book.getCheckedOutDate();
            if (checkedOutDate != null) {
                // Calculating duration since book was checked out.
                long daysSinceCheckedOut = java.time.temporal.ChronoUnit.DAYS.between(checkedOutDate, currentDate);

                // Comparing with the "grace period".
                if (daysSinceCheckedOut > gracePeriodDays) {
                    book.setStatus(Status.OVERDUE);
                }
            }
        }
    }
    
    /**
     * Generates a string representation of the book.
     * @return A string representing the book.
     */
    @Override
    public String toString(){
        return(this.title + " Author: " + this.author.getName() + ", (ISBN: " + this.ISBN + ") Published by: " + this.publisher + ", Copies number: " + this.copiesNum + ". Book Status: " + this.status + "\n");
    }
}