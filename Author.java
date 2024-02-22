import java.sql.Date;
import java.util.ArrayList;

public class Author{
    private String name;
    private Date DOB;
    private ArrayList<Book> bookList;

    public Author(String name, Date DOB, ArrayList bookList) {
        this.name = name;
        this.DOB = DOB;
        this.bookList = bookList;
    }

    public Author(String name) {
        this.name = name;
    }

    public ArrayList<Book> getBookList() {
        return bookList;
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
}
