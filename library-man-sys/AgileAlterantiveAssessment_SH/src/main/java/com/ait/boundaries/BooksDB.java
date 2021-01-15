package com.ait.boundaries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ait.entities.Books;

public class BooksDB implements BooksDAO {
	private final Map<Integer, Books> books;
	private final List<Books> bookList;
	
	protected BooksDB() {
		books = new HashMap<Integer, Books>();
		bookList = new ArrayList<Books>();
		
	}

	@Override
	public Books addBook(final int bookId,final  Books book) {
		books.put(bookId, book);
		return book;
	}

	@Override
	public Books deleteBooks(int bookId) {
		books.remove(bookId);
		return null;
		
	}
	@Override
	public Books updateBooks(int bookId,Books book) {
		//books.replaceAll((BiFunction<? super Integer, ? super Books, ? extends Books>) book);
		return books.replace(bookId, book);
		
		
	} 
	
	
	@Override
	public Books getBook(int bookId) {
		return books.get(bookId);
		
	}

	@Override
	public List<Books> getBooks() {
		bookList.clear();
		for(final Map.Entry book:books.entrySet()) {
			bookList.add((Books) book.getValue());
		}
		return bookList;
	}

	@Override
	public Books getBookName(String bookName) {
		return books.get(bookName);
	}

}
