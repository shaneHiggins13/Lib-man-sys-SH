package com.ait.boundaries;

import java.sql.SQLException;
import java.util.List;

import com.ait.entities.Books;

public interface BooksDAO {
	Books addBook(int bookId, Books book) throws SQLException;
	Books getBookName(String bookName) throws SQLException;
	List<Books> getBooks() throws SQLException;
	Books deleteBooks(int bookId) throws SQLException;
	Books updateBooks(int bookId, Books book) throws SQLException;
	Books getBook(int bookId) throws SQLException;
	

}
