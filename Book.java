import java.util.ArrayList;
import java.util.Scanner;

public class Book implements BorrowableInterface{
    private String title;
    private Author author;
    private int ISBN;
    private String publisher;
    private int copiesNum;
    private Status status;

    public enum Status {
        AVAILABLE,
        CHECKED_OUT,
        OVERDUE
    }

    public Book(String title, Author author, int ISBN, String publisher, int copiesNum) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.copiesNum = copiesNum;
    }
    
    public static Author createAuthor(String name) {
        return new Author(name);
    }

    public static Book userInputBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter the author: ");
        String authorName = scanner.nextLine();

        Author author = createAuthor(authorName);

        System.out.print("Enter the ISBN: ");
        int ISBN = scanner.nextInt();

        System.out.print("Enter the pubilsher: ");
        scanner.nextLine();  // This is done because the nextInt can be unpredictable and there can be leftover newline character. Ensures the input is read correctly.
        String publisher = scanner.nextLine();

        System.out.print("Enter the number of copies: ");
        int copiesNum = scanner.nextInt();

        scanner.close();

        // Creating a new book with the details input by the user.
        return new Book(title, author, ISBN, publisher, copiesNum);  // Note** will have to do .add in demo due to class type?
    }

    public Author getAuthor() {
        return author;
    }
    public int getCopiesNum() {
        return copiesNum;
    }
    public int getISBN() {
        return ISBN;
    }
    public String getPublisher() {
        return publisher;
    }
    public String getTitle() {
        return title;
    }
    public Status getStatus() {
        return status;
    }
    
    public void setAuthor(Author author) {
        this.author = author;
    }
    public void setCopiesNum(int copiesNum) {
        this.copiesNum = copiesNum;
    }
    public void setISBN(int iSBN) {
        ISBN = iSBN;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    
    public String toString(){
        return(this.title + "Author: " + this.author + ", (ISBN: " + this.ISBN + ") Published by: " + this.publisher + ", Copies number: " + this.copiesNum);
    }
}