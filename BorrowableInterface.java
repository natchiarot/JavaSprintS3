/**
 * The BorrowableInterface represents the behavior of an object that can be borrowed and returned.
 */
public interface BorrowableInterface {

    /**
     * Borrows a specified number of copies of a book.
     * @param book The book to be borrowed.
     * @param numCopies The number of copies to borrow.
     */
    void borrowBook(Book book, int numCopies);

    /**
     * Returns a specified number of copies of a book.
     * @param book The book to be returned.
     * @param numCopies The number of copies to return.
     */
    void returnBook(Book book, int numCopies);

}
