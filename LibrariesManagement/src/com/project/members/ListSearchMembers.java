package com.project.members;
/*@author Tran van Thuan*/
import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.SQLException;

public class ListSearchMembers extends JInternalFrame {
	//khai bao các biến
	//tạo North Panel
	private JPanel northPanel = new JPanel() ;
	//tạo Center Panel
	private JPanel centerPanel = new JPanel();
	//tạo label
	private JLabel label = new JLabel ("Danh sách tìm kiếm Sinh viên");
	//tạo button
	private JButton printButton ;
	//tạo table
	private JTable table ;
	//tạo TableColumn
	private TableColumn column = null ;
	//tạo TableColumn
	private JScrollPane scrollPane ;
	
	//tạo 1 đối tượng cho lớp ResultSetTableModel
	private  ResultSetTableModel tableModel ;
	
	//constructor chi ListSearchMembers
	public ListSearchMembers( String query)
	{
		//thiết lập title cho internal frame
		super ("Tìm kiếm Sinh viên", false, true,false,true) ;
		//thiết lập icon
		setFrameIcon(new ImageIcon(ClassLoader.getSystemResource("image/List16.gif")));
		//giao diện đồ họa người dùng
		Container cp = getContentPane();
		
		//thiết lập yêu cầu thông tin cho lớp ResultSetTableModel
		
		final String JDBC_DRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
		final String DATABASE_URL = "jdbc:odbc:Jlibrary";
		final String DEFAULT_QUERY = query ;
		
		//bắt các lỗi cho đối tượng ResultSetTableModel
		try
		{
			tableModel = new ResultSetTableModel (JDBC_DRIVER, DATABASE_URL, DEFAULT_QUERY);
			//thiết lập Query
			try
			{
				tableaModel.setQuery(DEFAULT_QUERY);
			}
			catch(SQLException sqlException)
			{				
			}
		}
		catch(ClassNotFoundException classNotFound)
		{
			System.out.println("ListSearchMembers.java\n"+classNotFound.toString());
		}
		catch(SQLException sqlException)
		{			
		}
		//thiết lập table với thông tin
		table = new JTable(TableModel);
		//thiết lập kích thước table
		table.setPreferredScrollableViewportSize(new Dimension(700,200));
		//thiết lập font
		table.setFont(new Font("Tohama",Font.PLAIN,12));
		//thiết lập scrollpane cho table
		scrollPane = new JSrcollPane(table);
		
		//thiết lâp size cho table colums
		for(int i = 0 ; i < 6; i++)
		{
			column = table.getColumnModel().getColumn(i);
			if (i == 0) //MemberID
				column.setPreferredWidth(30);
			if (i == 1) //ID
				column.setPreferredWidth(20);
			if (i == 2) //name
				column.setPreferredWidth(150);
			if (i == 3) //Email
				column.setPreferredWidth(120);
			if (i == 4) //Major
				column.setPreferredWidth(20);
			if (i == 5) //expired
				column.setPreferredWidth(40);
		}
		
		
		
		
	}
}
