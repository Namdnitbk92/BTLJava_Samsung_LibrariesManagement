package com.project.books;

import javax.swing.*;
import javax.swing.table.TableColumn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.SQLException;
/**
 *@author Bach 
 */
public class ListSearchBooks extends JInternalFrame
{
	/*
	 * khai báo biến sử dụng trong chương trình
	 */
	// tạo bảng North
		private JPanel northPanel = new JPanel();
		// tạo bảng Trung Tâm 
		private JPanel centerPanel = new JPanel();
		//tạo nhãn
		private JLabel label = new JLabel("List of Books");
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
		//cấu trúc listSearchBooks
		public ListSearchBooks(String query) 
		   {
			// thiết lập tiêu đề khung trong
			super("Searched Books", false, true, false, true);
			//thiết lập icon
			setFrameIcon(new ImageIcon(ClassLoader.getSystemResource("images/List16.gif")));
			// lấy giao diện đồ họa của người dùng 
			Container cp = getContentPane();

			/***********************************************************************
			 * thiết lập yêu cầu thông tin cho lớp ResultSetTableModel *
			 ************************************************************************/
			final String JDBC_DRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
			final String DATABASE_URL = "jdbc:odbc:JLibrary";
			final String DEFAULT_QUERY = query;

			//yêu cầu thông tin cho đối thể ResultSetTableModel 
			try
			    {
				tableModel = new ResultSetTableModel(JDBC_DRIVER, DATABASE_URL, DEFAULT_QUERY);
				//thiết lập Query
				try 
				{
					tableModel.setQuery(DEFAULT_QUERY);
				}
				catch (SQLException sqlException) {
				}
			}
			catch (ClassNotFoundException classNotFound) {
			}
			catch (SQLException sqlException) {
			
			}
			//thiết lập thông tin bảng biểu
			table = new JTable(tableModel);
			//định dạng kích thước bảng biểu
			table.setPreferredScrollableViewportSize(new Dimension(990, 200));
			//định dạng phông  chữ
			table.setFont(new Font("Tahoma", Font.PLAIN, 12));
			//thiết lập scrollpane cho bảng biểu
			scrollPane = new JScrollPane(table);

			//định dạng  kích thước các cột bảng
			for (int i = 0; i < 13; i++) 
			{
				column = table.getColumnModel().getColumn(i);
				if (i == 0) //BookID
					column.setPreferredWidth(20);
				if (i == 1) //Subject
					column.setPreferredWidth(100);
				if (i == 2) //Title
					column.setPreferredWidth(150);
				if (i == 3) //Author
					column.setPreferredWidth(50);
				if (i == 4) //Publisher
					column.setPreferredWidth(70);
				if (i == 5) //Copyright
					column.setPreferredWidth(40);
				if (i == 6) //Edition
					column.setPreferredWidth(40);
				if (i == 7) //Pages
					column.setPreferredWidth(40);
				if (i == 8) //NumberOfBooks
					column.setPreferredWidth(80);
				if (i == 9) //ISBN
					column.setPreferredWidth(70);
				if (i == 10) //Library
					column.setPreferredWidth(30);
				if (i == 11) //Available
					column.setPreferredWidth(30);
	                        if (i == 12) //ShelfNo
					column.setPreferredWidth(30);
			}
			//định dạng phông chữ cho nhãn
			label.setFont(new Font("Tahoma", Font.BOLD, 14));
			//định dạng layout cho panel
			northPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			//thêm nhãn cho panel
			northPanel.add(label);
			//thêm panel vào container
			cp.add("North", northPanel);

			//thiết lập layout cho panel
			centerPanel.setLayout(new BorderLayout());
			//tạo ảnh cho nút bấm
			ImageIcon printIcon = new ImageIcon(ClassLoader.getSystemResource("images/Print16.gif"));
			// thêm nút bấm vào panel
			printButton = new JButton("print the books", printIcon);
			//thiết lập tip text
			printButton.setToolTipText("Print");
			//định dạng phông chữ cho nút bấm
			printButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
			//thêm nút bấm vào panel
			centerPanel.add(printButton, BorderLayout.NORTH);
			//thêm scrollpane vào panel
			centerPanel.add(scrollPane, BorderLayout.CENTER);
			//thiết lập viền bao cho panel
			centerPanel.setBorder(BorderFactory.createTitledBorder("Books:"));
			//thêm panel vào container
			cp.add("Center", centerPanel);

			//thêm actionListener vào nút bấm
			printButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					Thread runner = new Thread() {
						public void run() {
							try {
								PrinterJob prnJob = PrinterJob.getPrinterJob();
								prnJob.setPrintable(new PrintingBooks(DEFAULT_QUERY));
								if (!prnJob.printDialog())
									return;
								setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
								prnJob.print();
								setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
							}
							catch (PrinterException ex) {
								System.out.println("Printing error: " + ex.toString());
							}
						}
					};
					runner.start();
				}
			});
			//thiết lập giá trị 'true' cho  visible 
			setVisible(true);
			// đưa ra khung
			pack();
		}
	}