package com.project.books;

import javax.swing.table.AbstractTableModel;

import java.sql.*;

public class ResultSetTableModel extends AbstractTableModel {
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private ResultSetMetaData metaData;
	private int numberOfRows;

	// Theo doi trang thai ket noi co so du lieu
	private boolean connectedToDatabase = false;

	// Khoi tao resultSet
	// Xac dinh so hang
	public ResultSetTableModel(String driver, String url, String query)
			throws SQLException, ClassNotFoundException {
		Class.forName(driver); // load CSDL
		connection = DriverManager.getConnection(url); // Ket noi CSDL
		// Tao Statement de truy van CSDL
		statement = connection.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		connectedToDatabase = true; // Cap nhat trang thai ket noi CSDL
		setQuery(query); // Thiet lap truy van va thuc hien
	}

	// Lay lop dai dien cho loai cot
	public Class getColumnClass(int column) throws IllegalStateException {
		// Kiem tra ket noi CSDL
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");
		// Xac dinh lop Java cua cot
		try {
			String className = metaData.getColumnClassName(column + 1);
			return Class.forName(className); 
		}
		// Bat SQLExceptions and ClassNotFoundExceptions
		catch (Exception exception) {
			exception.printStackTrace();
		}
		
		return Object.class;
	}

	// Lay so luong cot trong ResultSet
	public int getColumnCount() throws IllegalStateException {
		// Kiem tra ket noi CSDL
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");
		// Xac dinh so cot
		try {
			return metaData.getColumnCount();
		}
		// Bat SQLExceptions va in thong bao loi
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		
		return 0;
	}

	// Lay ten cot trong ResultSet
	public String getColumnName(int column) throws IllegalStateException {
		// Kiem tra ket noi CSDL
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");
		// Xac dinh ten cot
		try {
			return metaData.getColumnName(column + 1);
		}
		// Bat SQLExceptions va in thong bao loi
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		
		return "";
	}

	// Tra ve so luong hang trong ResultSet
	public int getRowCount() throws IllegalStateException {
		// Kiem tra ket noi CSDL
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");
		return numberOfRows;
	}

	// Co gia tri trong hang va cot cu the
	public Object getValueAt(int row, int column) throws IllegalStateException {
		// Kiem tra ket noi CSDL
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");
		try {
			resultSet.absolute(row + 1);
			return resultSet.getObject(column + 1);
		}
		// Bat SQLExceptions va in thong bao loi
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		
		return "";
	}

	// Thiet lap moi chuoi truy van CSDL
	public void setQuery(String query) throws SQLException,
			IllegalStateException {
		// Kiem tra ket noi CSDL
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");
		// Chi dinh truy van va thuc hien
		resultSet = statement.executeQuery(query);
		// Lay du lieu meta cho ResultSet
		metaData = resultSet.getMetaData();
		// Xac dinh so hang trong ResultSet
		resultSet.last(); // Di chuyen den hang cuoi
		numberOfRows = resultSet.getRow(); // Lay so luong hang
		fireTableStructureChanged(); // Thong bao cho JTable la da thay doi
	}

	// Dong ket noi CSDL
	public void disconnectFromDatabase() {
		try {
			statement.close();
			connection.close();
		}
		// Bat SQLExceptions va in thong bao loi
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		// Cap nhap trang thai ket noi CSDL
		finally {
			connectedToDatabase = false;
		}
	}
}