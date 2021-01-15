package com.ait.entities;

import java.sql.SQLException;
import java.util.List;

import com.ait.boundaries.BooksDAO;
import com.ait.boundaries.FactoryDAO;

public class BooksManager{

	BooksDAO database = FactoryDAO.getBookDAO();
	
	public Books getBookName(final String bookName) throws SQLException{
		return database.getBookName(bookName);
	}
	
	public List<Books> getBooks() throws SQLException{
		return database.getBooks();  		
	}
	
}
