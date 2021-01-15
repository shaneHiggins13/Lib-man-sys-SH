package com.ait.ui;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ait.boundaries.BooksDAO;
import com.ait.boundaries.FactoryDAO;
import com.ait.entities.Books;
import com.ait.entities.BooksManager;
import com.ait.exceptions.BooksDAOException;

public class MembersUI { 

	 private static Scanner scanner = null;

	 public static void main(final String args[]) throws SQLException, BooksDAOException
	    {
	        System.out.println("Welcome to the library application	--	Members section\n");

	        // set the class variables
	        scanner = new Scanner(System.in);

	        // display the command menu
	        displayMenu();
	        
	        String action = "";
			while (!action.equalsIgnoreCase("exit")) {
				// get the input from the user
				action = Validator.getString(scanner, "Enter a command: ");
				System.out.println(); 
				if (action.equalsIgnoreCase("display")) {
					displayAllBooks();
				} else if (action.equalsIgnoreCase("m")) {
					MainMenu.main(args);
				}else if (action.equalsIgnoreCase("loan")) {
					loanBook();
				}else if (action.equalsIgnoreCase("return")) {    
					returnBook();
				}else if(action.equalsIgnoreCase("search")) {
					searchBooks();
				}
			}
			scanner.close();
	    }
	    
	    public static void displayMenu()
	    {
	        System.out.println("COMMAND MENU");
	        System.out.println("Display    - Display all books on system");
	        System.out.println("Loan       - Get a book out on loan");
	        System.out.println("Return     - Return loaned book");
	        System.out.println("Search     - Search if a book is on loan");
	        System.out.println("m  		   - Return to main menu");
	       
	    }
	    
	    public static void loanBook() throws SQLException { 
	    	System.out.println("Loan");
	    	
	    	BooksDAO database = FactoryDAO.getBookDAO();
	    	System.out.println("Enter book id you wish to loan");
			int i = scanner.nextInt();
			
			Books books = database.getBook(i);
			books.setOnLoan(true);					
			database.updateBooks(books.getBookId(), books);
	
			System.out.println(); 
			System.out.println("Book with ID of " + i + " and title of " + books.getBookName() + " has been loaned out.\n");
	    }
	    
	    public static void returnBook() throws SQLException {
	    	System.out.println("Return"); 
	    	
	    	BooksDAO database = FactoryDAO.getBookDAO();
	
	    	System.out.println("Enter book id you wish to return");
			int i = scanner.nextInt();
			Books books = database.getBook(i);
			
			books.setOnLoan(false);					
			database.updateBooks(books.getBookId(), books);
	
			System.out.println();
			System.out.println("Book with ID of " + i + " has been loaned out.\n");
	    }
	    
	    public static void searchBooks() throws SQLException {
	    	System.out.println("Search"); 
	    	
	    	BooksDAO database = FactoryDAO.getBookDAO();
	    	
	    	System.out.println("Enter book id you wish to search");
	    	int i = scanner.nextInt();
	    	Books book = database.getBook(i);
	    	
	    	String name = book.getBookName();
	    	Boolean bookOnLoan = book.isOnLoan();
	    	
	    	System.out.println("Book --> " + name + " is on loan : " + bookOnLoan);
	
	    }

	    public static void displayAllBooks() throws SQLException {
			System.out.println("Book LIST");
			final BooksManager bookManager = new BooksManager();
			final List<Books> books = bookManager.getBooks();
			for (final Books book : books) {
				System.out.println("BookId: " +book.getBookId() + " Book Name: " + book.getBookName() + " Author name: " + book.getBookAuthor() + " Year published: "
						+ book.getYearPublished() + " How many copies on system: " + book.getNoOfCopies() + " Is the book on loan: " + book.isOnLoan());
			}
		}
}
