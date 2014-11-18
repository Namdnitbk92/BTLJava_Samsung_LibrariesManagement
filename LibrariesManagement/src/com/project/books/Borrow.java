package com.project.books;

//import the packages 

import java.sql.*;

public class Borrow {
	/***************************************************************************
	              Khởi tạo các biến sử dụng trong chương trình       
	 ***************************************************************************/

	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	private int bookID;
	private int memberID;
	private Date dayOfBorrowed;
	private Date dayOfReturn;
	private String URL = "jdbc:odbc:JLibrary";

	public Borrow() {
	}

	public int getBookID() {
		return bookID;
	}

	public int getMemberID() {
		return memberID;
	}

	public Date getDayOfBorrowed() {
		return dayOfBorrowed;
	}

	public Date getDayOfReturn() {
		return dayOfReturn;
	}

	public void connection() {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		}
		catch (ClassNotFoundException cnfe) {
			System.out.println("Borrow.java\n" + cnfe.toString());
		}
		catch (Exception e) {
			System.out.println("Borrow.java\n" + e.toString());
		}
		/***************************************************************
		 * Tạo kết nối báo cáo update bảng biểu trong cơ sở sữ liệu
		 * Sau đó đóng các kết nối,báo cáo .Đó cũng là cách bắt lỗi SQL Exeption 
		 ***************************************************************/
}
}