import java.util.ArrayList;

public class Patron {
    private String name;
    private String address;
    private String phoneNum;
    public ArrayList<Book> borrowedBookList;
    private ArrayList<Book> books;

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

    // Searching borrowed book by different characteristics.
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

    public Book searchBorrowedBookISBN(int ISBN) {
        for(int i = 0; i < borrowedBookList.size(); i++) {
            Book book = borrowedBookList.get(i);
            if (book.getISBN() == ISBN) {
                return book;
            }
        }
        return null;  // Book was not found.
    }

    public void borrowBook(Book book, int numCopies) {
        // // Checking if the book is already in the borrowed book list
        // boolean found = false;
        // for (int i = 0; i < borrowedBookList.size(); i++) {
        //     Book borrowedBook = borrowedBookList.get(i);
        //     if (borrowedBook.getTitle().equals(book.getTitle())) {
        //         borrowedBook.setCopiesNum(borrowedBook.getCopiesNum + numCopies);
        //         found = true;
        //         break;
        //     }
        // }

        // // adding the book if not already in the borrowed book list.
        // if (!found) {
            Book borrowedBook = new Book(book.getTitle(), book.getAuthor(), book.getISBN(), book.getPublisher(), numCopies);
            borrowedBookList.add(borrowedBook);
        // }
    }

    public void returnBook(Book book, int numCopies) {
        for(int i = 0; i < numCopies; i++) {
            borrowedBookList.remove(book);
        }
    }

    @Override
    public String toString() {
        return(this.name + ", " + this.address + ", " + this.phoneNum + ", \n List of Books Borrowed: " + this.borrowedBookList);
    }
}