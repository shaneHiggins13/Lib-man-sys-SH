package com.ait.exceptiontest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.verification.Times;

import com.ait.boundaries.BooksDAO;
import com.ait.boundaries.FactoryDAO;
import com.ait.entities.Books;
import com.ait.entities.BooksManager;
import com.ait.entities.BooksManagerAdd;
import com.ait.exceptions.BooksDAOException;
import com.ait.exceptions.BooksException;
import com.ait.ui.LibrarianUI;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.List;

import static org.mockito.Mockito.anyString;

class ExceptionTests {
	
	private LibrarianUI librarianUI;
	private final BooksManager booksManager = mock(BooksManager.class);
	private final BooksManagerAdd booksManagera = mock(BooksManagerAdd.class);
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
		BooksManagerAdd booksManager = new BooksManagerAdd();
		System.out.println("Test add");
		BooksDAO booksDAO = FactoryDAO.getBookDAO();
		Books book1 = booksManager.addBook(BOOK_ID, BOOK_NAME, AUTHOR_NAME, PUBLISHED, COPIES, ONLOAN);
		//Books book2 = booksManager.addBook(BOOK_ID2, BOOK_NAME, AUTHOR_NAME, PUBLISHED, COPIES, ONLOAN);

		booksDAO.addBook(BOOK_ID, book1);
		List<Books> books = booksDAO.getBooks();
	}

	/*
	@Test
	public void test1() throws BooksException, SQLException {
		when(booksDAO.getBook(BOOK_ID)).thenReturn(null);
		
		
		assertThrows(BooksDAOException.class, () -> {
			booksDAO.addBook(BOOK_ID, books);
		});
		
		//assertEquals("Error in connecting to the books database");
		
		verify(booksDAO, new Times(1)).getBook(BOOK_ID);
	}
*/
}
