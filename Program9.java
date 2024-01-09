import java.util.*;

class Book {
	String title;
	String author;
	String publisher;
	double price;

	public Book(String title, String author, String publisher, double price) {
		super();
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", publisher=" + publisher + ", price=" + price + "]";
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

}

public class Program9 {

	public static void main(String[] args) {

		Map<Integer, Book> bookMap = new HashMap<>();
		Scanner sc = new Scanner(System.in);

		Book book1 = new Book("java", "shahidhar", "mc graw hill", 1299);
		Book book2 = new Book("spring", "chaddarby", "mc graw hill", 499);
		Book book3 = new Book("java", "shahidhar", "ramaiah", 1299);
		Book book4 = new Book("toc", "manishekar", "mc graw hill", 300);

		bookMap.put(1, book1);
		bookMap.put(2, book2);
		bookMap.put(3, book3);
		bookMap.put(4, book4);

		System.out.println("enter book title");
		String title = sc.nextLine();
		for (Map.Entry<Integer, Book> book : bookMap.entrySet()) {
			if (book.getValue().getTitle().contains(title)) {
				System.out.println(book.getValue());
			}
		}

		System.out.println("enter publisher name");
		String publisher = sc.nextLine();
		for (Map.Entry<Integer, Book> book : bookMap.entrySet()) {
			if (publisher.equals(book.getValue().getPublisher())) {
				System.out.println(book.getValue());
			}
		}

		System.out.println("enter new publisher name");
		String newPublisher = sc.nextLine();
		System.out.println("enter tttle to be updated for given publisher");
		String newTitle = sc.nextLine();
		for (Map.Entry<Integer, Book> book : bookMap.entrySet()) {
			if (newPublisher.equals(book.getValue().getPublisher())) {
				book.getValue().setTitle(newTitle);
				System.out.println(book);
			}
		}

	}

}
