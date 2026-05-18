package min
public class Book {

    private int bookId;
    private String bookName;
    private String author;
    private boolean issued;

    public Book(int bookId, String bookName, String author) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.issued = false;
    }

    public int getId() {
        return bookId;
    }

    public String getName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return issued;
    }

    /**
     * Issues the book. Returns false if already issued.
     */
    public boolean issueBook() {
        if (issued) return false;
        issued = true;
        return true;
    }

    /**
     * Returns the book. Returns false if it wasn't issued.
     */
    public boolean returnBook() {
        if (!issued) return false;
        issued = false;
        return true;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId +
               " | Name: " + bookName +
               " | Author: " + author +
               " | Status: " + (issued ? "Issued" : "Available");
    }
}
