package com.ait.entitiestest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.awt.print.Book;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.boundaries.BooksDAO;
import com.ait.boundaries.FactoryDAO;
import com.ait.entities.Books;
import com.ait.entities.BooksManager;
import com.ait.entities.BooksManagerAdd;
import com.ait.entities.BooksManagerDelete;
import com.ait.entities.BooksManagerUpdate;
import com.ait.exceptions.BooksDAOException;
import com.ait.ui.LibrarianUI;

class BooksManagerTest {

	private LibrarianUI librarianUI;
	// private final BooksManager booksManager = mock(BooksManager.class);
	private final BooksDAO booksDAO = mock(BooksDAO.class);
	private Books book1 = mock(Books.class);
	final static int BOOK_ID = 1;
	final static int BOOK_ID2 = 2;
	final static int BOOK_ID3 = 3;
	final static String BOOK_NAME = "Harry Potter";
	final static String AUTHOR_NAME = "J.K";
	final static String PUBLISHED = "1996";
	final static int COPIES = 1;
	final static boolean ONLOAN = false;

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("set up");
		booksDAO.deleteBooks(BOOK_ID);

	}

	@AfterEach
	void tearDown() {
		System.out.println("tear down");
	}

	@Test
	public void testAdd() throws SQLException, BooksDAOException {
		BooksManagerAdd booksManager = new BooksManagerAdd();
		System.out.println("Test add");
		BooksDAO booksDAO = FactoryDAO.getBookDAO();
		Books book1 = booksManager.addBook(BOOK_ID, BOOK_NAME, AUTHOR_NAME, PUBLISHED, COPIES, ONLOAN);
		Books book2 = booksManager.addBook(BOOK_ID2, BOOK_NAME, AUTHOR_NAME, PUBLISHED, COPIES, ONLOAN);

		booksDAO.addBook(BOOK_ID, book1);
		booksDAO.addBook(BOOK_ID2, book2);

		List<Books> books = booksDAO.getBooks();

		assertEquals(2, books.size());

		assertEquals(book1, books.get(0));
		assertEquals(book2, books.get(1));

	}

	@Test
	public void testDelete() throws SQLException, BooksDAOException {
		BooksManagerDelete booksManager = new BooksManagerDelete(); 
		BooksManagerAdd booksManagerAdd = new BooksManagerAdd();
		System.out.println("Test Delete");
		BooksDAO booksDAO = FactoryDAO.getBookDAO();
		Books book1 = booksManagerAdd.addBook(BOOK_ID, BOOK_NAME, AUTHOR_NAME, PUBLISHED, COPIES, ONLOAN);
		Books book2 = booksManagerAdd.addBook(BOOK_ID2, BOOK_NAME, AUTHOR_NAME, PUBLISHED, COPIES, ONLOAN);

		booksDAO.addBook(BOOK_ID, book1);
		booksDAO.addBook(BOOK_ID2, book2);

		List<Books> books = booksDAO.getBooks();
		assertEquals(2, books.size());

		// booksDAO.deleteBooks(BOOK_ID);
		booksManager.deleteBook(BOOK_ID);
		List<Books> books1 = booksDAO.getBooks();
		assertEquals(1, books1.size());

		booksDAO.deleteBooks(BOOK_ID2);
		// booksManager.deleteBook(BOOK_ID2);
		List<Books> books2 = booksDAO.getBooks();
		assertEquals(0, books2.size());

	}

	@Test
	public void testUpdateThroughBooksManager() throws SQLException, BooksDAOException {
		BooksManagerUpdate booksManagerUpdate = new BooksManagerUpdate();

		BooksManagerAdd booksManagerAdd = new BooksManagerAdd();
		System.out.println("Test Update");
		BooksDAO booksDAO = FactoryDAO.getBookDAO();

		Books book1 = booksManagerAdd.addBook(BOOK_ID, BOOK_NAME, AUTHOR_NAME, PUBLISHED, COPIES, ONLOAN);

		booksDAO.addBook(BOOK_ID, book1);
		book1.setBookId(2);
		String updateName = book1.setBookName("Potter");

		booksManagerUpdate.update(BOOK_ID2, updateName, AUTHOR_NAME, PUBLISHED, COPIES, ONLOAN);

		assertEquals(2, book1.getBookId());
		assertEquals("Potter", book1.getBookName());

	}

	@Test
	public void testUpdateThroughBooksDAO() throws SQLException, BooksDAOException {
		BooksManagerAdd booksManagerAdd = new BooksManagerAdd();
		System.out.println("Test Update");
		BooksDAO booksDAO = FactoryDAO.getBookDAO();

		Books book1 = booksManagerAdd.addBook(BOOK_ID, BOOK_NAME, AUTHOR_NAME, PUBLISHED, COPIES, ONLOAN);

		booksDAO.addBook(BOOK_ID, book1);

		List<Books> books1 = booksDAO.getBooks();
		assertEquals(1, books1.size());

		assertEquals(1, book1.getBookId());

		book1.setBookId(2);
		booksDAO.updateBooks(BOOK_ID, book1);

		assertEquals(2, book1.getBookId()); 
	}

}
