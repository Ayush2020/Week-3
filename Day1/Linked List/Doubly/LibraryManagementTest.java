class Book {
    String bookTitle;
    String author;
    String genre;
    int bookId;
    boolean availabilityStatus;  // true for available, false for checked out
    Book next;
    Book prev;

    public Book(String bookTitle, String author, String genre, int bookId, boolean availabilityStatus) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.availabilityStatus = availabilityStatus;
        this.next = null;
        this.prev = null;
    }
}

class Library {
    Book head;  // Points to the first book in the library
    Book tail;  // Points to the last book in the library
    int bookCount;  // Keeps track of the number of books

    public Library() {
        head = null;
        tail = null;
        bookCount = 0;
    }

    // Add a new book at the beginning
    public void addAtBeginning(String bookTitle, String author, String genre, int bookId, boolean availabilityStatus) {
        Book newBook = new Book(bookTitle, author, genre, bookId, availabilityStatus);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        bookCount++;
    }

    // Add a new book at the end
    public void addAtEnd(String bookTitle, String author, String genre, int bookId, boolean availabilityStatus) {
        Book newBook = new Book(bookTitle, author, genre, bookId, availabilityStatus);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        bookCount++;
    }

    // Add a new book at a specific position
    public void addAtPosition(int position, String bookTitle, String author, String genre, int bookId, boolean availabilityStatus) {
        if (position < 0 || position > bookCount) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 0) {
            addAtBeginning(bookTitle, author, genre, bookId, availabilityStatus);
            return;
        }

        Book newBook = new Book(bookTitle, author, genre, bookId, availabilityStatus);
        Book temp = head;
        int currentPosition = 0;

        while (currentPosition < position - 1) {
            temp = temp.next;
            currentPosition++;
        }

        newBook.next = temp.next;
        newBook.prev = temp;
        if (temp.next != null) {
            temp.next.prev = newBook;
        }
        temp.next = newBook;

        if (newBook.next == null) {
            tail = newBook;  // Update the tail if the new book is added at the end
        }

        bookCount++;
    }

    // Remove a book by Book ID
    public void removeByBookId(int bookId) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        Book temp = head;

        // Check if the book to be removed is the head
        if (temp != null && temp.bookId == bookId) {
            head = temp.next;
            if (head != null) {
                head.prev = null;
            }
            temp = null;
            bookCount--;
            return;
        }

        // Traverse the list to find the book
        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }

        // If book is not found
        if (temp == null) {
            System.out.println("Book with ID " + bookId + " not found.");
            return;
        }

        // Book is found, update pointers
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }

        if (temp == tail) {
            tail = temp.prev;  // Update tail if the last book is removed
        }

        temp = null;
        bookCount--;
    }

    // Search for a book by Book Title
    public Book searchByBookTitle(String bookTitle) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookTitle.equals(bookTitle)) {
                return temp;
            }
            temp = temp.next;
        }
        System.out.println("Book with title '" + bookTitle + "' not found.");
        return null;
    }

    // Search for a book by Author
    public Book searchByAuthor(String author) {
        Book temp = head;
        while (temp != null) {
            if (temp.author.equals(author)) {
                return temp;
            }
            temp = temp.next;
        }
        System.out.println("Book by author '" + author + "' not found.");
        return null;
    }

    // Update a book’s Availability Status
    public void updateAvailabilityStatus(int bookId, boolean availabilityStatus) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.availabilityStatus = availabilityStatus;
                System.out.println("Availability status of Book ID " + bookId + " updated to " + (availabilityStatus ? "Available" : "Checked Out"));
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    // Display all books in forward order
    public void displayBooksForward() {
        if (head == null) {
            System.out.println("No books in the library.");
            return;
        }

        Book temp = head;
        while (temp != null) {
            System.out.println("Book ID: " + temp.bookId + ", Title: " + temp.bookTitle + ", Author: " + temp.author +
                    ", Genre: " + temp.genre + ", Availability: " + (temp.availabilityStatus ? "Available" : "Checked Out"));
            temp = temp.next;
        }
    }

    // Display all books in reverse order
    public void displayBooksReverse() {
        if (tail == null) {
            System.out.println("No books in the library.");
            return;
        }

        Book temp = tail;
        while (temp != null) {
            System.out.println("Book ID: " + temp.bookId + ", Title: " + temp.bookTitle + ", Author: " + temp.author +
                    ", Genre: " + temp.genre + ", Availability: " + (temp.availabilityStatus ? "Available" : "Checked Out"));
            temp = temp.prev;
        }
    }

    // Count the total number of books in the library
    public int countBooks() {
        return bookCount;
    }
}

public class LibraryManagementTest {
    public static void main(String[] args) {
        Library library = new Library();

        // Add books to the library
        library.addAtEnd("The Catcher in the Rye", "J.D. Salinger", "Fiction", 1, true);
        library.addAtEnd("To Kill a Mockingbird", "Harper Lee", "Fiction", 2, true);
        library.addAtEnd("1984", "George Orwell", "Dystopian", 3, false);
        library.addAtBeginning("Moby Dick", "Herman Melville", "Fiction", 4, true);

        // Display books in forward order
        System.out.println("Books in Library (Forward):");
        library.displayBooksForward();

        // Display books in reverse order
        System.out.println("\nBooks in Library (Reverse):");
        library.displayBooksReverse();

        // Count total books
        System.out.println("\nTotal Books in Library: " + library.countBooks());

        // Search for a book by title
        Book foundBook = library.searchByBookTitle("1984");
        if (foundBook != null) {
            System.out.println("\nFound Book: " + foundBook.bookTitle);
        }

        // Search for a book by author
        foundBook = library.searchByAuthor("Harper Lee");
        if (foundBook != null) {
            System.out.println("\nFound Book by Author: " + foundBook.bookTitle);
        }

        // Update availability status of a book
        library.updateAvailabilityStatus(3, true);

        // Remove a book by Book ID
        library.removeByBookId(2);

        // Display books after removal
        System.out.println("\nBooks in Library (After Removal):");
        library.displayBooksForward();
    }
}
