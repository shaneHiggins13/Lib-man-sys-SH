package com.ait.ui;

import java.sql.SQLException;
import java.util.Scanner;

import com.ait.exceptions.BooksDAOException;

public class MainMenu {
	 private static Scanner scanner = null;


	    public static void main(final String args[]) throws SQLException, BooksDAOException
	    {
	        System.out.println("Welcome to the library application\n");

	        // set the class variables
	        scanner = new Scanner(System.in); 

	        // display the command menu 
	        displayMenu();
	         
	        String action = "";
			while (!action.equalsIgnoreCase("exit")) {
				// get the input from the user
				action = Validator.getString(scanner, "Enter a command: ");
				System.out.println(); 

				if (action.equalsIgnoreCase("l")) {
					LibrarianUI.main(args);
				} else if (action.equalsIgnoreCase("m")) { 
					MembersUI.main(args); 
				}else if(action.equalsIgnoreCase("d")) {
					MembersUI.displayAllBooks();
				}
			}
			scanner.close(); 
	    }
	    
	    public static void displayMenu()
	    {
	        System.out.println("COMMAND MENU");
	        System.out.println("L    - Librarian "); 
	        System.out.println("M    - Member");
	        System.out.println("D    - Display books for non-members");
	       
	    }
}
