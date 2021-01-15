package com.ait.entities;

public class Books {
	private int bookId;
	private String bookName;
	private String bookAuthor;
	private String yearPublished;
	private int noOfCopies;
	private boolean isOnLoan;

	public Books(int bookId, String bookName, String bookAuthor, String yearPublished, int noOfCopies,
			boolean isOnLoan) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.yearPublished = yearPublished;
		this.noOfCopies = noOfCopies;
		this.isOnLoan = isOnLoan;
	} 

	

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public String setBookName(String bookName) {
		return this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(String yearPublished) {
		this.yearPublished = yearPublished;
	}

	public int getNoOfCopies() {
		return noOfCopies;
	}

	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}

	public boolean isOnLoan() {
		return isOnLoan;
	}

	public void setOnLoan(boolean isOnLoan) {
		this.isOnLoan = isOnLoan;
	}

	

}
