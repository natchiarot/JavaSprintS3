import java.util.ArrayList;

public class Patron {
    private String name;
    private String address;
    private String phoneNum;
    private ArrayList<Book> borrowedBookList;

    public Patron(String name, String address, String phoneNum){
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.borrowedBookList = new ArrayList<>();
    }

    // Getter methods.
    public String getAddress() {
        return address;
    }
    public ArrayList<Book> getBorrowedBookList() {
        return borrowedBookList;
    }
    public String getName() {
        return name;
    }
    public String getPhoneNum() {
        return phoneNum;
    }

    // Setter methods.
    public void setAddress(String address) {
        this.address = address;
    }
    public void setBorrowedBookList(ArrayList<Book> borrowedBookList) {
        this.borrowedBookList = borrowedBookList;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return(this.name + ", " + this.address + ", " + this.phoneNum + ", \n List of Books Borrowed: " + this.borrowedBookList);
    }
}