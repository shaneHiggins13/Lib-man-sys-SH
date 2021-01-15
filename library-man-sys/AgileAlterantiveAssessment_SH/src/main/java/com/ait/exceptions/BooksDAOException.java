package com.ait.exceptions;

public class BooksDAOException extends BooksException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BooksDAOException() {
		super("Error in connecting to the books database");
		
	}
	

}
