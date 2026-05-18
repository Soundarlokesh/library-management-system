package min;

import java.util.*
public class LibraryManagement {

    static Scanner sc = new Scanner(System.in);
    static HashMap<Integer, Book> books = new HashMap<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by ID");
            System.out.println("4. Update Book");
            System.out.println("5. Remove Book");
            System.out.println("6. Sort Books by Name");
            System.out.println("7. Issue Book");
            System.out.println("8. Return Book");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addBook();
                case 2 -> viewBooks();
                case 3 -> searchBook();
                case 4 -> updateBook();
                case 5 -> removeBook();
                case 6 -> sortBooks();
                case 7 -> issueBook();
                case 8 -> returnBook();
                case 0 -> System.out.println("Thank you for using the Library System. Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);
    }

    public static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (books.containsKey(id)) {
            System.out.println("A book with this ID already exists.");
            return;
        }

        System.out.print("Enter Book Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        books.put(id, new Book(id, name, author));
        System.out.println("Book added successfully.");
    }

    public static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        System.out.println("\n--- All Books ---");
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }

    public static void searchBook() {
        System.out.print("Enter Book ID to search: ");
        int id = sc.nextInt();
        if (books.containsKey(id)) {
            System.out.println(books.get(id));
        } else {
            System.out.println("No book found with ID: " + id);
        }
    }

    public static void updateBook() {
        System.out.print("Enter Book ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (!books.containsKey(id)) {
            System.out.println("No book found with ID: " + id);
            return;
        }

        System.out.print("Enter new Book Name: ");
        String name = sc.nextLine();
        System.out.print("Enter new Author Name: ");
        String author = sc.nextLine();

        books.put(id, new Book(id, name, author));
        System.out.println("Book updated successfully.");
    }

    public static void removeBook() {
        System.out.print("Enter Book ID to remove: ");
        int id = sc.nextInt();
        if (books.remove(id) != null) {
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("No book found with ID: " + id);
        }
    }

    public static void sortBooks() {
        if (books.isEmpty()) {
            System.out.println("No books to sort.");
            return;
        }
        ArrayList<Book> list = new ArrayList<>(books.values());
        list.sort(Comparator.comparing(Book::getName));
        System.out.println("\n--- Books Sorted by Name ---");
        for (Book book : list) {
            System.out.println(book);
        }
    }

    public static void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        int id = sc.nextInt();
        if (!books.containsKey(id)) {
            System.out.println("No book found with ID: " + id);
            return;
        }
        Book book = books.get(id);
        if (book.issueBook()) {
            System.out.println("Book issued successfully.");
        } else {
            System.out.println("Book is already issued and not available.");
        }
    }

    public static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int id = sc.nextInt();
        if (!books.containsKey(id)) {
            System.out.println("No book found with ID: " + id);
            return;
        }
        Book book = books.get(id);
        if (book.returnBook()) {
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("This book was not issued.");
        }
    }
}
