import java.util.ArrayList;
import java.util.Scanner;

public class Book implements BorrowableInterface{
    private String title;
    private Author author;
    private int ISBN;
    private String publisher;
    private int copiesNum;
    private Status status;

    public Book(String title, Author author, int ISBN, String publisher, int copiesNum) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.copiesNum = copiesNum;
    }
    
    // public static Author createAuthor(String name) {
    //     return new Author(name);
    // }

    // Note** will have to create a new Author in demo file but this is so all information about the author is available?
    // public static Book addNewBook(String title, Author author, int ISBN, String publisher, int copiesNum) {
    //     return new Book(title, author, ISBN, publisher, copiesNum);
    // }

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

    // From borrowable interface.
    @Override
    public void borrowBook() {

    }

    @Override
    public void returnBook() {

    }
    
    @Override
    public String toString(){
        return(this.title + "Author: " + this.author + ", (ISBN: " + this.ISBN + ") Published by: " + this.publisher + ", Copies number: " + this.copiesNum);
    }
}