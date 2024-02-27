import java.util.ArrayList;

public interface BorrowableInterface {

    void borrowBook(Book book, int numCopies);
    void returnBook(Book book, int numCopies);

}
