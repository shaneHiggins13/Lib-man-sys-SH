package com.ait.entities;

import java.sql.SQLException;

import com.ait.boundaries.BooksDAO;
import com.ait.boundaries.FactoryDAO;

public class BooksManagerDelete {
	BooksDAO database = FactoryDAO.getBookDAO();
	
	public void deleteBook(int bookId) throws SQLException { 
		database.deleteBooks(bookId);
	}
	
}
