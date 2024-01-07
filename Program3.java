
import java.util.*;

class Book {

    private static int idCounter = 1;

    private int bookId;
    private String title;
    private String author;
    private String publisher;
    private double price;

    public Book(String title, String author, String publisher, double price) {
        this.bookId = idCounter++;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "bookId=" + bookId + '\n'
                + "title='" + title + '\n'
                + "author='" + author + '\n'
                + "publisher='" + publisher + '\n'
                + "price=" + price + '\n';
    }
}

public class Program3 {

    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();
        Book book1 = new Book("Java", "Shashidhar", "McGraw", 255.5);
        Book book2 = new Book("Spring Security", "Chad Darby", "McGraw", 499.99);
        Book book3 = new Book("Spring MVC", "Chad Darby", "McGraw", 1299.9);
        Book book4 = new Book("OCJP", "Martin Lara", "McGraw", 255.5);

        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);

        // Sorting books by price in ascending order
        Collections.sort(bookList, (bookA, bookB) -> Double.compare(bookA.getPrice(), bookB.getPrice()));

        System.out.println("Sorted Books by Price:");
        for (Book book : bookList) {
            System.out.println(book);
        }

        // Prompt for an author name ,list all books with the author's name
        String authorToSearch = "Chad Darby";
        for (Book book : bookList) {
            if (book.getAuthor().equals(authorToSearch)) {
                System.out.println(book);
            }
        }

        // Create a new list with books above a user-specified price
        double userSpecifiedPrice = 300.0;
        List<Book> expensiveBooks = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getPrice() > userSpecifiedPrice) {
                expensiveBooks.add(book);
            }
        }
        //displaying expensve books
        for (Book book : expensiveBooks) {
            System.out.println(book);
        }
    }
}
