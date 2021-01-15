package com.ait.entities;


import java.sql.SQLException;

import com.ait.boundaries.BooksDAO;
import com.ait.boundaries.FactoryDAO;

public class BooksManagerUpdate {

	BooksDAO database = FactoryDAO.getBookDAO();
	
	public Books update(int bookId,String bookName,String bookAuthor,String yearPublished,int noOfCopies,
			boolean isOnLoan) throws SQLException {
		Books book = new Books(bookId, bookName, bookAuthor, yearPublished, noOfCopies, isOnLoan);
		
		return database.updateBooks(bookId, book); 
		
	}
}
