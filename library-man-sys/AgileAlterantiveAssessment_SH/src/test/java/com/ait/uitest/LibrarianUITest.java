package com.ait.uitest;



import org.junit.jupiter.api.BeforeEach;


import com.ait.boundaries.BooksDAO;
import com.ait.entities.Books;
import com.ait.entities.BooksManager;
import com.ait.ui.LibrarianUI;
import com.ait.ui.MainMenu;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.print.attribute.standard.Copies;

import static org.mockito.Mockito.anyString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.anyLong;

class LibrarianUITest {

	private LibrarianUI librarianUI;
	private final BooksManager booksManager = mock(BooksManager.class);
	private final BooksDAO booksDAO = mock(BooksDAO.class);
	private final Books books = mock(Books.class);
	final static int BOOK_ID = 1;
	final static String BOOK_NAME = "Harry Potter";
	final static String AUTHOR_NAME = "J.K";
	final static String PUBLISHED = "1996";
	final static int COPIES = 1;
	final static boolean ONLOAN = false; 
	
	
	
	@BeforeEach
	void setUp() throws Exception {
		librarianUI = new LibrarianUI();
	}
	
	/*
	@Test
	void testAddBook() {
		String input = BOOK_NAME;
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		//LibrarianUI.addBook("Harry Potter");
		booksManager.addBook(BOOK_ID,BOOK_NAME,AUTHOR_NAME,PUBLISHED,COPIES,ONLOAN);
		when(booksDAO.addBook(BOOK_ID, books).equals(in));
		//booksManager.addBook(BOOK_ID,BOOK_NAME,AUTHOR_NAME,PUBLISHED,COPIES,ONLOAN);
		verify(booksDAO, new Times(1)).getBookName(BOOK_NAME);
				
	}
	
	
	@Test
	public void DisplayLibrarian() {
		
		booksManager.addBook(BOOK_ID,BOOK_NAME,AUTHOR_NAME,PUBLISHED,COPIES,ONLOAN);
		//librarianUI.displayMenu();
		MainMenu mainMenu = new MainMenu();
		mainMenu.displayMenu();
		String input = "l";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		assertEquals("Welcome to the library application\n", mainMenu.);
		
	}
	
	*/
	/*
	@Test
	void testAddBook2() {
		
		String input = BOOK_NAME;
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		LibrarianUI.addBook(input);
		assertEquals("Harry Potter", books.getBookName());
	}
*/
}
