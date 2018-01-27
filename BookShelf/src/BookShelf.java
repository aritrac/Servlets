import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class BookShelf {

	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(new File("input.txt"));
		ArrayList<Books> books = new ArrayList<Books>();

		String author, title, publisher;
		int copyright;
		int count = 0;

		try {
			while (scan.hasNext()) {
				title = scan.nextLine();
				author = scan.nextLine();
				publisher = scan.nextLine();
				copyright = scan.nextInt();
				if (scan.hasNext())
					scan.next();

				Books book = new Books(title, author, publisher, copyright);
				books.add(book);

			}

			scan.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		while (count < books.size()) {
			System.out.println(books.get(count));
			count++;
		}
	}
}

class Books {

	private String title, author, publisher;
	private int copyright;

	public Books(String newTitle, String newAuthor, String newPub, int newCopy) {
		title = newTitle;
		author = newAuthor;
		publisher = newPub;
		copyright = newCopy;
	}

	// Setters
	public void setTitle(String newTitle) {
		title = newTitle;
	}

	public void setAuthor(String newAuthor) {
		author = newAuthor;
	}

	public void setPublisher(String newPub) {
		publisher = newPub;
	}

	public void setCopyrightDate(int newCopy) {
		copyright = newCopy;
	}

	// Getters
	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
	}

	public int getCopyrightDate() {
		return copyright;
	}

	public String toString() {
		String result = "";
		result = "Title: " + title + "\nAuthor: " + author + "\nPublisher: "
				+ publisher;
		result += "\nCopyright Date: " + copyright;
		return result;
	}

}