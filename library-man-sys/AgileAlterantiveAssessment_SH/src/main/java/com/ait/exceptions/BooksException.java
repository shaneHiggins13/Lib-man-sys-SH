package com.ait.exceptions;

public abstract class BooksException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected BooksException(final String message) {
		super(message);
	}

}
