package com.ait.entities;

import java.sql.SQLException;

import com.ait.boundaries.BooksDAO;
import com.ait.boundaries.FactoryDAO;
import com.ait.exceptions.BooksDAOException;

public class BooksManagerAdd {

	BooksDAO database = FactoryDAO.getBookDAO();
	public Books addBook(final int bookId,final String bookName,final String bookAuthor,final String yearPublished,final int noOfCopies,
			final boolean isOnLoan) throws SQLException, BooksDAOException{
		final Books books=new Books(bookId, bookName, bookAuthor, yearPublished, noOfCopies, false);

		try {
			
			 database.addBook(bookId, books);
		} catch (SQLException e) {
			throw new BooksDAOException();
		}
		//final Books books=new Books(bookId, bookName, bookAuthor, yearPublished, noOfCopies, false);
		
		return database.addBook(bookId, books);
	}
	
}
 