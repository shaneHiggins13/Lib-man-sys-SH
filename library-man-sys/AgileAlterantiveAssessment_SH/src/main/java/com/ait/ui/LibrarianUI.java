package com.ait.ui;

import java.util.Scanner;
import java.sql.SQLException;
import java.util.List;

import com.ait.boundaries.BooksDAO;
import com.ait.boundaries.FactoryDAO;
import com.ait.entities.*;
import com.ait.exceptions.BooksDAOException;

public class LibrarianUI {
	// declare two class variables
	private static Scanner scanner = null;

	public static void main(final String args[]) throws SQLException, BooksDAOException {
		System.out.println("Welcome to the library application\n");

		// set the class variables
		scanner = new Scanner(System.in);

		// display the command menu
		displayMenu();

		// perform 1 or more actions
		String action = "";
		while (!action.equalsIgnoreCase("exit")) {
			// get the input from the user
			action = Validator.getString(scanner, "Enter a command: ");
			System.out.println();

			if (action.equalsIgnoreCase("Display")) {
				displayAllBooks();
			} else if (action.equalsIgnoreCase("add")) {
				addBook(scanner);
			} else if (action.equalsIgnoreCase("exit")) {
				System.out.println("Bye.\n");
			} else if (action.equalsIgnoreCase("delete")) {
				deleteBook();
			} else if (action.equalsIgnoreCase("update")) {
				updateBook(scanner);
			} else if (action.equalsIgnoreCase("m")) {
				MainMenu.main(args);
			} else if (action.equalsIgnoreCase("Search")){
				searchBooks();
			}else {
				System.out.println("Error! Not a valid command.\n");
			}
		}
		scanner.close();
	}

	public static void displayMenu() {
		System.out.println("COMMAND MENU");
		System.out.println("Display - Display all Books on system");
		System.out.println("add     - Add add Book");
		System.out.println("update  - Update an entry");
		System.out.println("delete	- Delete book from system");
		System.out.println("search  - Search a book on system with ID");
		System.out.println("M       - Return to main menu");
		System.out.println("help    - Show this menu");
		System.out.println("exit    - Exit this application\n");

	}

	public static void displayAllBooks() throws SQLException {
		System.out.println("Book LIST");
		final BooksManager bookManager = new BooksManager();
		final List<Books> books = bookManager.getBooks();
		for (final Books book : books) {
			System.out.println("BookId: " + book.getBookId() + " Book Name: " + book.getBookName() + " Author name: "
					+ book.getBookAuthor() + " Year published: " + book.getYearPublished()
					+ " How many copies on system: " + book.getNoOfCopies() + " Is the book on loan: "
					+ book.isOnLoan());
		}
	}

	public static void addBook(Object object) throws SQLException, BooksDAOException {
		System.out.println("Add");
		int bookId = Validator.getInt(scanner, "Enter bookId: ");

		String bookName = Validator.getLine(scanner, "Enter book name: ");

		String bookAuthor = Validator.getLine(scanner, "Enter author name: ");

		String yearPublished = Validator.getLine(scanner, "Enter year book was published: ");

		int noOfCopies = Validator.getInt(scanner, "Enter number of copies on system");

		BooksManagerAdd booksManager = new BooksManagerAdd();
		booksManager.addBook(bookId, bookName, bookAuthor, yearPublished, noOfCopies, true);

		System.out.println();
		System.out.println("The book with the " + bookName + " has been added.\n");

	}

	public static void deleteBook() throws SQLException {
		System.out.println("Enter the bookId to delete");
		int id = scanner.nextInt();
		BooksManagerDelete booksManager = new BooksManagerDelete();
		booksManager.deleteBook(id);
		System.out.println("Book with the id " + id + " has been deleted from the system");
		displayAllBooks();
	}

	public static void updateBook(Object object) throws SQLException {

		System.out.println("Update book");
		BooksManagerUpdate booksManagerUpdate = new BooksManagerUpdate();
		Books books = new Books(0, null, null, null, 0, false);

		System.out.println("Enter id to update");
		int i = scanner.nextInt();
		books.setBookId(i);

		System.out.println("Enter update details");
		System.out.println("Enter book name");
		String bookNameNew = scanner.next();

		System.out.println("Enter author name");
		String authorNameNew = scanner.next();

		System.out.println("Enter published year");
		String PublishedNew = scanner.next();

		System.out.println("How many copies in library");
		int noOfBooks = scanner.nextInt();

		booksManagerUpdate.update(i, bookNameNew, authorNameNew, PublishedNew, noOfBooks, false);
		displayAllBooks();
		System.out.println();
		System.out.println("Book with ID of " + i + " has been updated.\n");
	}

	public static void searchBooks() throws SQLException {
		System.out.println("Search");

		BooksDAO database = FactoryDAO.getBookDAO();

		System.out.println("Enter book id you wish to search");
		int i = scanner.nextInt();
		Books book = database.getBook(i);

		System.out.println("BookId: " + book.getBookId() + " Book Name: " + book.getBookName() + " Author name: "
				+ book.getBookAuthor() + " Year published: " + book.getYearPublished() + " How many copies on system: "
				+ book.getNoOfCopies() + " Is the book on loan: " + book.isOnLoan());

	}

}
