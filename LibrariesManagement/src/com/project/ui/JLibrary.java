package com.project.ui;

import javax.swing.*;

import com.project.members.AddMembers;
import com.project.members.ListMembers;
import com.project.books.BorrowBooks;
import com.project.books.ListBooks;
import com.project.books.ReturnBooks;
import com.project.books.AddBooks;
import com.project.search.SearchBooksAndMembers;

public class JLibrary extends JFrame {
	
	/***************************************************************************
     ***         Khai bao cac bien su dung cho chuong trinh                  ***
     ***************************************************************************/
	
	//Tao JPanel
	private JPanel searchPanel = new JPanel();
	//Tao JToolBar
	private JToolBar searchToolBar = new JToolBar();
	//Tao Label
	private JLabel searchLabel1 = new JLabel("Tiêu đề sách: ");
	//Tao JTextField de su dung cho searchToolBar
	private JTextField searchTextField = new JTextField();
	//Tao JButton de su dung cho searchToolBar
	private JButton searchButton = new JButton("Tìm kiếm");
	
	private JDesktopPane desktop = new JDesktopPane();
    private JSplitPane splitPane;
    private JScrollPane desktopScrollPane;
    private JScrollPane treeScrollPane;
    
    /***************************************************************************
     *      Tao doi tuong tu cac lop khac de su dung trong ActionListener      *
     ***************************************************************************/
    
    private Menubar menu;
    private Toolbar toolbar;
    private StatusBar statusbar = new StatusBar();
    private ListBooks listBooks;
    private AddBooks addBooks;
    private BorrowBooks borrowBooks;
    private ReturnBooks returnBooks;

    private AddMembers addMembers;
    private ListMembers listMembers;
    private SearchBooksAndMembers search;
    
    //Phuong thuc khoi tao JLibrary
    public JLibrary() {
    	
    }
}
