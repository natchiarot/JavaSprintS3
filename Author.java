import java.sql.Date;
import java.util.ArrayList;

public class Author{
    private String name;
    private Date DOB;
    private ArrayList<Book> bookList;

    public Author(String name, Date DOB, ArrayList<Book> bookList) {
        this.name = name;
        this.DOB = DOB;
        this.bookList = (bookList != null) ? bookList : new ArrayList<>();
    }

    public Author(String name) {
        this.name = name;
    }

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

    public Date getDOB() {
        return DOB;
    }
    public String getName() {
        return name;
    }
    
    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }
    public void setDOB(Date dOB) {
        DOB = dOB;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return(this.name + ", " + this.DOB + ", \n List of Books: " + this.bookList);
    }
}
