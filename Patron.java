import java.util.ArrayList;

public class Patron {
    private String name;
    private String address;
    private String phoneNum;
    private ArrayList<Book> borrowedBookList;

    // Static array to hold patrons.
    private static ArrayList<Patron> patrons = new ArrayList<>();

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
}