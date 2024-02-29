import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import com.opencsv.CSVReader;

/**
 * A class to demonstrate the functionality of the Library system.
 */
public class Demo {

    /**
     * The main method to execute the demonstration.
     * 
     * @param args The command-line arguments (not used in this demonstration).
     */
    public static void main(String [] args) {
        final String CSV_FILE_PATH = "MockLibraryData.csv";

        // Initialize the library with data from the CSV file
        Scanner scanner = new Scanner(System.in);
        Library library = initialLibraryFromCSV(CSV_FILE_PATH);

        // displayLibraryData(library);

        // Interactive menu for user actions
        displayMenu(scanner, library);
        
}

    /**
     * Displays the main menu for user actions.
     * 
     * @param scanner The scanner object to read user input.
     * @param library The library object representing the library system.
     */
    private static void displayMenu(Scanner scanner, Library library) {
            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Borrow a book");
                System.out.println("2. Return a book");
                System.out.println("3. Add/Edit/Remove Book");
                System.out.println("4. Add/Edit/Remove Author");
                System.out.println("5. Add/Edit/Remove Patron");
                System.out.println("6. Exit");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        borrowBook(scanner, library);
                        break;
                    case 2:
                        returnBook(scanner, library);
                        break;
                        case 3:
                        manageBooksMenu(scanner, library);
                        break;
                    case 4:
                        manageAuthorsMenu(scanner, library);
                        break;
                    case 5:
                        managePatronsMenu(scanner, library);
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            }
        }
    
    /**
     * Displays the menu for managing books.
     * 
     * @param scanner The scanner object to read user input.
     * @param library The library object representing the library system.
     */
    private static void manageBooksMenu(Scanner scanner, Library library) {
        while (true) {
            System.out.println("\nManage Books:");
            System.out.println("1. Add New Book");
            System.out.println("2. Edit Book");
            System.out.println("3. Remove Book");
            System.out.println("4. Back to Main Menu");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addNewBook(scanner, library);
                    break;
                case 2:
                    editBook(scanner, library);
                    break;
                case 3:
                    removeBook(scanner, library);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    /**
     * Adds a new book to the library.
     * 
     * @param scanner The scanner object to read user input.
     * @param library The library object representing the library system.
     */
    private static void addNewBook(Scanner scanner, Library library) {
        // Input details for a new book
        System.out.println("Adding a New Book:");
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author name: ");
        String authorName = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        long ISBN = Long.parseLong(scanner.nextLine());
        System.out.print("Enter publisher: ");
        String publisher = scanner.nextLine();
        System.out.print("Enter number of copies: ");
        int copiesNum = Integer.parseInt(scanner.nextLine());
    
        // Create a new Book object
        Book newBook = new Book(title, new Author(authorName), ISBN, publisher, copiesNum);
    
        // Add the new book to the library
        library.addBook(newBook);
        System.out.println("New book added successfully!");
    }
    
    /**
     * Edits an existing book in the library.
     * 
     * @param scanner The scanner object to read user input.
     * @param library The library object representing the library system.
     */
    private static void editBook(Scanner scanner, Library library) {
        // Input details for editing a book
        System.out.println("Editing a Book:");
        System.out.print("Enter ISBN of the book to edit: ");
        long ISBN = Long.parseLong(scanner.nextLine());
    
        // Find the book in the library
        Book bookToEdit = library.searchByISBN(ISBN);
        if (bookToEdit == null) {
            System.out.println("Book not found in the library.");
            return;
        }
    
        // Input new details for the book
        System.out.print("Enter new title (leave blank to keep current): ");
        String newTitle = scanner.nextLine();
        if (!newTitle.isEmpty()) {
            bookToEdit.setTitle(newTitle);
        }
    
        System.out.print("Enter new author name (leave blank to keep current): ");
        String newAuthorName = scanner.nextLine();
        if (!newAuthorName.isEmpty()) {
            bookToEdit.setAuthor(new Author(newAuthorName));
        }
    
        System.out.print("Enter new publisher (leave blank to keep current): ");
        String newPublisher = scanner.nextLine();
        if (!newPublisher.isEmpty()) {
            bookToEdit.setPublisher(newPublisher);
        }
    
        System.out.print("Enter new number of copies (leave blank to keep current): ");
        String newCopiesNumStr = scanner.nextLine();
        if (!newCopiesNumStr.isEmpty()) {
            int newCopiesNum = Integer.parseInt(newCopiesNumStr);
            bookToEdit.setCopiesNum(newCopiesNum);
        }
    
        // Pass the updated book to the library to perform the edit
        library.editBook(ISBN, bookToEdit);
    
        System.out.println("Book details updated successfully!");
    }
    
    /**
     * Removes a book from the library.
     * 
     * @param scanner The scanner object to read user input.
     * @param library The library object representing the library system.
     */
    private static void removeBook(Scanner scanner, Library library) {
        // Input ISBN of the book to remove
        System.out.println("Removing a Book:");
        System.out.print("Enter ISBN of the book to remove: ");
        long ISBN = Long.parseLong(scanner.nextLine());
    
        // Find the book in the library
        Book bookToRemove = library.searchByISBN(ISBN);
        if (bookToRemove == null) {
            System.out.println("Book not found in the library.");
            return;
        }
    
        // Remove the book from the library
        library.removeBook(bookToRemove);
        System.out.println("Book removed successfully!");
    }

    /**
     * Displays the menu for managing authors.
     * 
     * @param scanner The scanner object to read user input.
     * @param library The library object representing the library system.
     */
    private static void manageAuthorsMenu(Scanner scanner, Library library) {
        while (true) {
            System.out.println("\nManage Authors Menu:");
            System.out.println("1. Add new author");
            System.out.println("2. Edit author details");
            System.out.println("3. Remove author");
            System.out.println("4. Back to main menu");
    
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            
            switch (choice) {
                case 1:
                    addNewAuthor(scanner, library);
                    break;
                case 2:
                    editAuthor(scanner, library);
                    break;
                case 3:
                    removeAuthor(scanner, library);
                    break;
                case 4:
                    System.out.println("Returning to main menu...");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
    
    /**
     * Adds a new author to the library.
     * 
     * @param scanner The scanner object to read user input.
     * @param library The library object representing the library system.
     */
    private static void addNewAuthor(Scanner scanner, Library library) {
        // Input details for a new author
        System.out.println("Adding a New Author:");
        System.out.print("Enter author name: ");
        String authorName = scanner.nextLine();
        System.out.print("Enter author's date of birth (yyyy-MM-dd): ");
        LocalDate DOB = LocalDate.parse(scanner.nextLine());
    
        // Create a new Author object
        Author newAuthor = new Author(authorName, DOB, new ArrayList<>());
    
        // Add the new author to the library
        library.addAuthor(newAuthor);
        System.out.println("New author added successfully!");
    }
    
    /**
     * Edits the details of an existing author in the library.
     * 
     * @param scanner The scanner object to read user input.
     * @param library The library object representing the library system.
     */
    private static void editAuthor(Scanner scanner, Library library) {
        // Input details for editing an author
        System.out.println("Editing an Author:");
        System.out.print("Enter name of the author to edit: ");
        String authorName = scanner.nextLine();
    
        // Find the author in the library
        Author authorToEdit = null;
        for (Author author : library.getAuthors()) {
            if (author.getName().equalsIgnoreCase(authorName)) {
                authorToEdit = author;
                break;
            }
        }
    
        if (authorToEdit != null) {
            // Input new details for the author
            System.out.print("Enter new name (leave blank to keep current): ");
            String newAuthorName = scanner.nextLine();
            if (!newAuthorName.isEmpty()) {
                authorToEdit.setName(newAuthorName);
            }
    
            System.out.print("Enter new date of birth (yyyy-MM-dd, leave blank to keep current): ");
            String newDOBStr = scanner.nextLine();
            if (!newDOBStr.isEmpty()) {
                LocalDate newDOB = LocalDate.parse(newDOBStr);
                authorToEdit.setDOB(newDOB);
            }
    
            System.out.println("Author details updated successfully!");
        } else {
            System.out.println("Author not found in the library.");
        }
    }
    
    /**
     * Removes an existing author from the library.
     * 
     * @param scanner The scanner object to read user input.
     * @param library The library object representing the library system.
     */
    private static void removeAuthor(Scanner scanner, Library library) {
        // Input details for removing an author
        System.out.println("Removing an Author:");
        System.out.print("Enter name of the author to remove: ");
        String authorName = scanner.nextLine();
    
        // Find the author in the library
        Author authorToRemove = null;
        for (Author author : library.getAuthors()) {
            if (author.getName().equalsIgnoreCase(authorName)) {
                authorToRemove = author;
                break;
            }
        }
    
        if (authorToRemove != null) {
            // Remove the author from the library
            library.removeAuthor(authorToRemove);
            System.out.println("Author removed successfully!");
        } else {
            System.out.println("Author not found in the library.");
        }
    }
    
    /**
     * Displays the menu for managing patrons.
     * 
     * @param scanner The scanner object to read user input.
     * @param library The library object representing the library system.
     */
    private static void managePatronsMenu(Scanner scanner, Library library) {
        while (true) {
            System.out.println("\nManage Patrons Menu:");
            System.out.println("1. Add new patron");
            System.out.println("2. Edit patron details");
            System.out.println("3. Remove patron");
            System.out.println("4. Back to main menu");
    
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            
            switch (choice) {
                case 1:
                    addNewPatron(scanner, library);
                    break;
                case 2:
                    editPatron(scanner, library);
                    break;
                case 3:
                    removePatron(scanner, library);
                    break;
                case 4:
                    System.out.println("Returning to main menu...");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
    
    /**
     * Adds a new patron to the library.
     * 
     * @param scanner The scanner object to read user input.
     * @param library The library object representing the library system.
     */
    private static void addNewPatron(Scanner scanner, Library library) {
        // Input details for a new patron
        System.out.println("Adding a New Patron:");
        System.out.print("Enter patron name: ");
        String patronName = scanner.nextLine();
        System.out.print("Enter patron address: ");
        String address = scanner.nextLine();
        System.out.print("Enter patron phone number: ");
        String phoneNum = scanner.nextLine();
    
        // Create a new Patron object
        Patron newPatron = new Patron(patronName, address, phoneNum);
    
        // Add the new patron to the library
        library.addPatron(newPatron);
        System.out.println("New patron added successfully!");
    }
    
    /**
     * Edits the details of an existing patron in the library.
     * 
     * @param scanner The scanner object to read user input.
     * @param library The library object representing the library system.
     */
    private static void editPatron(Scanner scanner, Library library) {
        // Input details for editing a patron
    System.out.println("Editing a Patron:");
    System.out.print("Enter name of the patron to edit: ");
    String patronName = scanner.nextLine();

    // Find the patron in the library
    Patron patronToEdit = null;
    for (Patron patron : library.getPatrons()) {
        if (patron.getName().equalsIgnoreCase(patronName)) {
            patronToEdit = patron;
            break;
        }
    }

    if (patronToEdit != null) {
        // Input new details for the patron
        System.out.print("Enter new name (leave blank to keep current): ");
        String newPatronName = scanner.nextLine();
        if (!newPatronName.isEmpty()) {
            patronToEdit.setName(newPatronName);
        }

        System.out.print("Enter new address (leave blank to keep current): ");
        String newAddress = scanner.nextLine();
        if (!newAddress.isEmpty()) {
            patronToEdit.setAddress(newAddress);
        }

        System.out.print("Enter new phone number (leave blank to keep current): ");
        String newPhoneNumber = scanner.nextLine();
        if (!newPhoneNumber.isEmpty()) {
            patronToEdit.setPhoneNum(newPhoneNumber);
        }

        System.out.println("Patron details updated successfully!");
    } else {
        System.out.println("Patron not found in the library.");
    }
    }
    
    /**
     * Removes an existing patron from the library.
     * 
     * @param scanner The scanner object to read user input.
     * @param library The library object representing the library system.
     */
    private static void removePatron(Scanner scanner, Library library) {
        // Input details for removing a patron
        System.out.println("Removing a Patron:");
        System.out.print("Enter name of the patron to remove: ");
        String patronName = scanner.nextLine();

        // Find the patron in the library
        Patron patronToRemove = null;
        for (Patron patron : library.getPatrons()) {
            if (patron.getName().equalsIgnoreCase(patronName)) {
                patronToRemove = patron;
                break;
            }
        }

        if (patronToRemove != null) {
            // Remove the patron from the library
            library.removePatron(patronToRemove);
            System.out.println("Patron removed successfully!");
        } else {
            System.out.println("Patron not found in the library.");
        }
    }

    /**
     * Allows a patron to borrow a book from the library.
     * 
     * @param scanner The scanner object to read user input.
     * @param library The library object representing the library system.
     */
    private static void borrowBook(Scanner scanner, Library library) {
        System.out.print("Enter patron name: ");
        String patronName = scanner.nextLine();
    
        System.out.print("Enter search type (title/author/ISBN): ");
        String searchType = scanner.nextLine();
    
        System.out.print("Enter search term: ");
        String searchTerm = scanner.nextLine();
    
        System.out.print("Enter number of copies to borrow: ");
        int numCopies = scanner.nextInt();
    
        // Borrow book logic
        library.borrowBook(new Patron(patronName, searchTerm, searchTerm), null, searchType, searchTerm, numCopies);
    }
    
    /**
     * Allows a patron to return a book to the library.
     * 
     * @param scanner The scanner object to read user input.
     * @param library The library object representing the library system.
     */
    private static void returnBook(Scanner scanner, Library library) {
        System.out.print("Enter patron name: ");
        String patronName = scanner.nextLine();
    
        System.out.print("Enter search type (title/author/ISBN): ");
        String searchType = scanner.nextLine();
    
        System.out.print("Enter search term: ");
        String searchTerm = scanner.nextLine();
    
        System.out.print("Enter number of copies to return: ");
        int numCopies = scanner.nextInt();
    
        // Return book logic
        library.returnBook(new Patron(patronName, searchTerm, searchTerm), null, searchType, searchTerm, numCopies);
    }

 /**
 * Initializes the library with data from a CSV file.
 * 
 * @param csvFilePath The file path of the CSV file containing library data.
 * @return The initialized Library object.
 */
private static Library initialLibraryFromCSV(String csvFilePath) {
    ArrayList<Book> books = new ArrayList<>();  
    ArrayList<Patron> patrons = new ArrayList<>();
    ArrayList<Author> authors = new ArrayList<>();
    Library library = new Library(books, patrons, authors);

            try (FileReader fileReader = new FileReader(csvFilePath);
             CSVReader csvReader = new CSVReader(fileReader)) {

            String[] nextRecord;

            while ((nextRecord = csvReader.readNext()) != null) {
                // CSV structure is as follows:
                // "book", title, author, ISBN, publisher, copiesNum, status
                // "author", name, DOB
                // "patron", name, address, phoneNum
                String type = nextRecord[0];

                switch (type) {
                    case "book":
                        String title = nextRecord[1];
                        String authorName = nextRecord[2];
                        long ISBN = Long.parseLong(nextRecord[3]);
                        String publisher = nextRecord[4];
                        int copiesNum = Integer.parseInt(nextRecord[5]);
                        String status = nextRecord[6];

                        // Create book object and add it to the library
                        Book book = new Book(title, new Author(authorName), ISBN, publisher, copiesNum);
                        book.setStatus(Status.valueOf(status.toUpperCase()));
                        library.addBook(book);
                        break;
                    case "author":
                        String name = nextRecord[1];
                        LocalDate DOB = LocalDate.parse(nextRecord[2]);

                        // Create author object and add it to the library
                        Author author = new Author(name, DOB, new ArrayList<>());
                        library.addAuthor(author);
                        break;
                    case "patron":
                        String patronName = nextRecord[1];
                        String address = nextRecord[2];
                        String phoneNum = nextRecord[3];

                        // Create patron object and add it to the library
                        Patron patron = new Patron(patronName, address, phoneNum);
                        library.addPatron(patron);
                        break;
                    default:
                        // Handle unrecognized type
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return library;
    }
}