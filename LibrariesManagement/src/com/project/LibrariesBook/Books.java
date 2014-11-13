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
	
	//cac bien de connect toi CSDL cua thu vien
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	private int bookID;//ma sach
	private String subject;//chu de 
	private String title;//tieu de 
	private String author;//tac gia
	private String publisher;//nha xuat ban
	private int copyright;//ban quyen
	private int edition;//phien ban
	private int pages;//so trang
	private String ISBN;//ma vach sach
	private int numberOfBooks;//tong so sach
	private int numberOfAvailbleBooks;//so sach co the cho muon
	private int numberOfBorrowedBooks;//so sach da duoc muon
	private String library;
	private boolean availble;//flag check sach co muon duoc khong
	private String URL = "jdbc:odbc:JLibrary";//url ket noi toi CSDL

	public Books() {
	}
	/*Cac phuong thuc get(),set().*/
	
	
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
	/*
	 * Thuc hien ket noi CSDL 
	 * @param Query
	 * 
	 * catch SQLException
	 * 
	 * */
	public void connection(String Query) {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		}
		catch (ClassNotFoundException cnfe) {
			System.out.println("Books.java\n" + cnfe.toString());
		}
		catch (Exception e) {
			System.out.println("Books.java\n" + e.toString());
		}
		
try {
			
			connection = DriverManager.getConnection(URL);//tao connect CSDL
			statement = connection.createStatement();
			resultSet = statement.executeQuery(Query);
			while (resultSet.next()) {
				bookID = resultSet.getInt(1);
				subject = resultSet.getString(2);
				title = resultSet.getString(3);
				author = resultSet.getString(4);
				publisher = resultSet.getString(5);
				copyright = resultSet.getInt(6);
				edition = resultSet.getInt(7);
				pages = resultSet.getInt(8);
				ISBN = resultSet.getString(9);
				numberOfBooks = resultSet.getInt(10);
				numberOfAvailbleBooks = resultSet.getInt(11);
				numberOfBorrowedBooks = resultSet.getInt(12);
				library = resultSet.getString(13);
				availble = resultSet.getBoolean(14);
			}
			resultSet.close();
			statement.close();
			connection.close();
		}
		catch (SQLException SQLe) {
			System.out.println("Books.java\n" + SQLe.toString());
		}
	}
	
	public void update(String Query) {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		}
		catch (ClassNotFoundException cnfe) {
			System.out.println("Books.java\n" + cnfe.toString());
		}
		catch (Exception e) {
			System.out.println("Books.java\n" + e.toString());
		}
		try {
			connection = DriverManager.getConnection(URL);
			statement = connection.createStatement();
			statement.executeUpdate(Query);
			statement.close();
			connection.close();
		}
		catch (SQLException SQLe) {
			System.out.println("Books.java\nError:" + SQLe.toString());
		}
	}
	
}
