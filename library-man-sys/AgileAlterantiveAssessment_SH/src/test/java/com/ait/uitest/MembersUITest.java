package com.ait.uitest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.boundaries.BooksDAO;
import com.ait.boundaries.FactoryDAO;
import com.ait.entities.Books;
import com.ait.entities.BooksManagerAdd;
import com.ait.exceptions.BooksDAOException;
import com.ait.ui.MembersUI;

class MembersUITest {
	
	private MembersUI membersUI;
	private final BooksDAO booksDAO = mock(BooksDAO.class);
	
	final static int BOOK_ID = 1;
	final static String BOOK_NAME = "Harry Potter";
	final static String AUTHOR_NAME = "J.K";
	final static String PUBLISHED = "1996";
	final static int COPIES = 1;
	final static boolean ONLOAN = false; 

	@BeforeEach
	void setUp() throws Exception {
	}

	/*
	@Test
	void test() throws SQLException, BooksDAOException {
		
		BooksManagerAdd booksManager = new BooksManagerAdd();
		System.out.println("Test add");
		BooksDAO booksDAO = FactoryDAO.getBookDAO();
		Books books = booksManager.addBook(BOOK_ID, BOOK_NAME, AUTHOR_NAME, PUBLISHED, COPIES, ONLOAN);
		
		assertEquals(false, books.isOnLoan());
		
		String input = "1";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		booksDAO.getBooks();
		
		MembersUI.loanBook();;
		
		assertEquals(true, books.isOnLoan());
	}
	
	*/

}
