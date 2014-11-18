package com.project.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class Menubar extends JMenuBar {
	
	/***************************************************************************
     ***         Khai bao cac bien su dung cho chuong trinh                  ***
     ***************************************************************************/
	
	//Tao JMenu cho chuong trinh
	public JMenu fileMenu, bookMenu, memberMenu, searchMenu, loanMenu;
	//Tao JMenuItem cho JMenu
	public JMenuItem exit, addBook, listBook;
    public JMenuItem addMember, listMember;
    public JMenuItem searchBooksAndMembers, borrowBook, returnBook;
    //Tao mang cac icon
    public ImageIcon[] icons;
    //Tao mang cac ten file anh (16x16)
    public String[] imageName16 = {"images/Print16.gif", "images/Exit16.gif",
            "images/Add16.gif", "images/List16.gif",
            "images/Edit16.gif", "images/Delete16.gif",
            "images/Information16.gif", "images/Find16.gif",
            "images/Export16.gif", "images/Import16.gif",
    };
    
    //Phuong thuc khoi tao
    public Menubar() {
    	
    	//Them book, member, search, loan & help Menus vao MenuBar
        this.add(fileMenu = new JMenu("File"));
        this.add(bookMenu = new JMenu("Sách"));
        this.add(memberMenu = new JMenu("Thành viên"));
        this.add(searchMenu = new JMenu("Tìm kiếm"));
        this.add(loanMenu = new JMenu("Mượn/Trả"));
        
        //Cai dat Mnemonic key (phim tat cho menu)
        fileMenu.setMnemonic('f');
        bookMenu.setMnemonic('s');
        memberMenu.setMnemonic('v');
        searchMenu.setMnemonic('t');
        loanMenu.setMnemonic('m');
        
        //Cai dat icons
        icons = new ImageIcon[12];
        for (int i = 0; i < imageName16.length; i++) {
            icons[i] = new ImageIcon(ClassLoader.getSystemResource(imageName16[i]));
        }
        
        //Them print books & exit vao fileMenu
        fileMenu.add(exit = new JMenuItem("Thoát", icons[1]));

        //Them add, list, listAvailble, listBorrowed, edit & remove Books va book information vao bookMenu
        bookMenu.add(addBook = new JMenuItem("Thêm sách", icons[2]));
        bookMenu.add(listBook = new JMenuItem("Danh sách sách", icons[3]));
       

        //Them add, list, edit & remove Members and member information vao memberMenu
        memberMenu.add(addMember = new JMenuItem("Thêm thành viên", icons[2]));
        memberMenu.add(listMember = new JMenuItem("Danh sách thành viên", icons[3]));
  
        //Them add, list & remove Members vao memberMenu
        searchMenu.add(searchBooksAndMembers = new JMenuItem("Tìm kiếm", icons[7]));

        //Them borrow & return books vao loanMenu
        loanMenu.add(borrowBook = new JMenuItem("Mượn sách", icons[8]));
        loanMenu.add(returnBook = new JMenuItem("Trả sách", icons[9]));
        
        //Cai dat phim tat cho cac chuc nang trong menu
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        searchBooksAndMembers.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

        addBook.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        listBook.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));


        addMember.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        listMember.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));

        borrowBook.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        returnBook.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
    }
}
