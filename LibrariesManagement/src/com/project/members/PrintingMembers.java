package com.project.members;

import javax.swing.*;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.sql.*;
import java.util.StringTokenizer;
import java.util.Vector;

public class PrintingMembers extends JInternalFrame implements Printable {

	/***************************************************************************
	 *** Khai bao cac bien su dung cho chuong trinh ***
	 ***************************************************************************/

	//Cac bien cho cai dat ket noi
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;

	private String URL = "jdbc:odbc:JLibrary";

	//Tao textArea
	private JTextArea textArea = new JTextArea();
	//Tao vector de su dung cho in
	private Vector lines;
	public static final int TAB_SIZE = 10;

	//Phuong thuc khoi tao cho lop PrintingMembers
	public PrintingMembers(String query) {
		super("In danh sách thành viên", false, true, false, true);
		//Lay giao dien de su dung
		Container cp = getContentPane();
		//Cai dat font
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 9));
		//Them textArea vao container
		cp.add(textArea);
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		}
		catch (ClassNotFoundException ea) {
			System.out.println(ea.toString());
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
		/***************************************************************
		 *       Thuc hien ket noi, tao hoac update co so du lieu      *
		 ***************************************************************/
		try {
			connection = DriverManager.getConnection(URL);
			statement = connection.createStatement();
			resultset = statement.executeQuery(query);
			textArea.append("=============== Thông tin thành viên ===============\n\n");
			while (resultset.next()) {
				textArea.append("Member ID: " + resultset.getString("ID") + "\n" +
				        "Name: " + resultset.getString("Name") + "\n" +
				        "Major: " + resultset.getString("Major") + "\n" +
				        "Expired: " + resultset.getString("Expired") + "\n\n");
			}
			textArea.append("=============== Thông tin thành viên ===============");
			resultset.close();
			statement.close();
			connection.close();
		}
		catch (SQLException SQLe) {
			System.out.println(SQLe.toString());
		}
		//for setting the visible to true
		setVisible(true);
		//to show the frame
		pack();
	}
	
	public int print(Graphics pg, PageFormat pageFormat, int pageIndex) throws PrinterException {
		return pageIndex;
	}
	
	protected Vector getLines(FontMetrics fm, int wPage) {
		return lines;
	}
}
