package com.project.books;


import javax.swing.*;
import javax.swing.table.TableColumn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

/* 
 * 
 */
public class ListBooks extends JInternalFrame {
/*
 *  khởi tạo biến sử dung trong chương trình
 */
	// tạo bảng North
	private JPanel northPanel = new JPanel();
	// tạo bảng Trung Tâm 
	private JPanel centerPanel = new JPanel();
	//tạo nhãn
	private JLabel northLabel = new JLabel("THE LIST FOR THE BOOKS");
	// tạo phím bấm 
	private JButton printButton;
	// tạo bảng
	private JTable table;
	//tạo cột bảng
	private TableColumn column = null;
	// tạo JScrollPane
	private JScrollPane scrollPane;
	//tạo 1 đối tượng cho lớp ResultSetTableModel
	private ResultSetTableModel tableModel;
	/***************************************************************************
	 * thiết lập yêu cầu thông tin cho class ResultSetTableModel. *
	 ***************************************************************************/
	private static final String JDBC_DRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
	private static final String DATABASE_URL = "jdbc:odbc:JLibrary";
	private static final String DEFAULT_QUERY = "SELECT BookID, Subject, Title, Author," +
	        "Publisher, Copyright, Edition, Pages, NumberOfBooks, ISBN, Library, Availble,ShelfNo FROM Books";

}
