package com.project.members;

/*@athor Tran Van Thuan*/
import ResultSetTableModel;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.SQLException;

public class ListMembers extends JInternalFrame{
	//tao North Panel
	private JPanel northPanel = new JPanel();
	//tao Center Panel
	private JPanel centerPanel = new JPanel();
	//tao label
	private JLabel label = new JLabel("Danh sach Sinh Vien");
	//tao button
	private JButton printButton ;
	//tao table
	private JTable table ;
	//tao TaleColumn
	private TableColumn column = null ;
	//tao JScrollPane
	private JScrollPane scrollPane ;
	
	//tao 1 doi tuong lop ResultSetTableModel
	private ResultSetTableModel tableModel;
	
	/**
	 * thiet lap yeu cau thong tin cho lop ResultSetTableModel
	 **/
	private static final String JDBC_DRIVER = "sun.jdbc.odbc.JdbcOdbcDriver " ;
	private static final String DATABASE_URL = "jdbc:odbc:JLibrary";
	private static final String DEFAULT_QUERY = "SELECT MemberID, ID,Name,Email,"+
	"Major,Expired FROM Members";
	
	//constructor cua ListMembers
	public void LisMembers() {
		//thiet lap title cho internal frame
		super("Members", false,true,false,true);
		//thiet lap icon
		setFrameIcon(new ImageIcon(ClassLoader.getSystemResource("image/List16.gif")));
		//hien thi cac thanh phan giao dien do hoa nguoi dung
		Container cp = getContentPane() ;
		//thong tin yeu cau cho doi tuong ResultSetTableModel
		try
		{
			tableModel = new ResultSetTableModel (JDBC_DRIVER, DATABASE_URL, DEFAULT_QUERY);
			//thiet lap Query
			try
			{
				tableModel.setQuery(DEFAULT_QUERY);
				
			}
			catch (SQLException sqlException)
			{
				sqlException.printStackTrace();
			}			
		}
		catch (ClassNotFoundException classNotFound)
		{
			classNotFound.printStackTrace();
		}
		catch (SQLException sqlException)
		{
			
		}
		//thiet lap bang thong tin
		table = new JTable( tableModel);
		//thiet lap size of table
		table.setPreferredScrollableViewportSize(new Dimension (700, 200));;
		//thiet lap font
		table.setFont (new Font ("Tahoma",Font.PLAIN, 12 )) ;
		//thiet lap scroolpane cho table
		scrollPane = new JScrollPane(table) ;
		//thiet lap size of table columns
		for (int i = 0 ; i < 6; i++ )
		{
			column = table.getColumnModel().getColumn(i) ;
			if(i == 0) //MemberID
				column.setPreferredWidth(30);
			if(i == 1) //ID
				column.setPreferredWidth(20);
			if (i == 2) //Name
				column.setPreferredWidth(150);
			if (i ==3 )//E-mail
				column.setPreferredWidth(120);
			if (i == 4) //major
				column.setPreferredWidth(20);
			if(i == 5) //expired
				column.setPreferredWidth(40);					
		}
		//thiet lap font cho label
		label.setFont(new Font ("Tahoma",Font.BOLD , 14));
		//thiet lap layout cho panel
		northPanel.setLayout(new FlowLayout (FlowLayout.CENTER));
		//thêm label cho panel
		northPanel.add(label);
		//thêm panel cho container
		cp.add("North",northPanel);
		
		//thiết lập layout cho panel
		centerPanel.setLayout(new BorderLayout());
		//tạo 1 ảnh cho button
		ImageIcon printIcon = new ImageIcon(ClassLoader.getSystemResource("image/Print16.gif"));
		//thêm button cho panel
		printButton = new JButton ("in ra các members", printIcon);
		//thiết lập cho tip text
		printButton.setToolTipText("In kết quả");
		//thiết lập font cho button
		printButton.setFont(new Font("Tahoma",Font.PLAIN, 12));
		//thêm button vào panel
		centerPanel.add(printButton, BorderLayout.NORTH);
		//thêm scroolpane cho panel
		centerPanel.add(scrollPane, BorderLayout.CENTER);
		//thiết lập border cho panel
		centerPanel.setBorder(BorderFactory.createTitledBorder("Members"));
		//thêm panel cho container
		cp.add("Center", centerPanel);
		
		//thêm actionListener cho button
		
		
		
	}


}
