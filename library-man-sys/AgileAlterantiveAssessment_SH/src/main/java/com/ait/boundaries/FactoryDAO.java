package com.ait.boundaries;

public class FactoryDAO {
	private static BooksDAO eDAO = new BooksDB();

	public static BooksDAO getBookDAO() {
		return eDAO;
	}
}
