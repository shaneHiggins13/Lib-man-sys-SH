package com.ait.entitiestest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.entities.Books;

class BooksTest {
private Books books;

	@BeforeEach
	void setUp() throws Exception {
		books = new Books(1, "Harry Potter", "J.K Rowlin", "1996", 1, false);
		
	}

	@Test
	void testBookClass() {
		books.setBookId(1);
		books.setBookName("Harry Potter");
		books.setBookAuthor("J.K Rowlin");
		books.setYearPublished("1996");
		books.setNoOfCopies(1);
		books.setOnLoan(false);
		assertEquals(1, books.getBookId());
		assertEquals("Harry Potter", books.getBookName());
		assertEquals("J.K Rowlin", books.getBookAuthor());
		assertEquals("1996", books.getYearPublished());
		assertEquals(1,books.getNoOfCopies());
		assertEquals(false, books.isOnLoan());
	}

}
