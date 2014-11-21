package com.project.members;

/*@athor Tran Van Thuan*/
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

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
	private ResultSetTableModel tableModel ;
	
	/**
	 * thiet lap yeu cau thong tin cho lop ResultSetTableModel
	 **/
	private static final String JBDC_DRIVER = "sun.jdbc.odbc.JdbcOdbcDriver " ;
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
		//
	}


}
