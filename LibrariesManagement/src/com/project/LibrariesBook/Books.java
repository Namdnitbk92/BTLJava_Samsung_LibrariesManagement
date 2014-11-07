package com.project.LibrariesBook;
/**
 * 
 */


/**
 * @author Namdnitbk92
 *
 */
 import java.sql.*;//import cac package can su dung

public class Books {
	
	//khoi tao cac bien private cua class Books
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	private int bookID;
	private String subject;
	private String title;
	private String author;
	private String publisher;
	private int copyright;
	private int edition;
	private int pages;
	private String ISBN;
	private int numberOfBooks;
	private int numberOfAvailbleBooks;
	private int numberOfBorrowedBooks;
	private String library;
	private boolean availble;
	private String URL = "jdbc:odbc:JLibrary";

	public Books() {
	}
	//Cac phuong thuc get(),set().
	public int getBookID() {
		return bookID;
	}

	public String getSubject() {
		return subject;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
	}

	public int getCopyright() {
		return copyright;
	}

	public int getEdition() {
		return edition;
	}

	public int getPages() {
		return pages;
	}

	public String getISBN() {
		return ISBN;
	}

	public int getNumberOfBooks() {
		return numberOfBooks;
	}

	public int getNumberOfAvailbleBooks() {
		return numberOfAvailbleBooks;
	}

	public int getNumberOfBorrowedBooks() {
		return numberOfBorrowedBooks;
	}

	public String getLibrary() {
		return library;
	}

	public boolean getAvailble() {
		return availble;
	}
}
