package com.project.ui;

import javax.swing.*;

public class Toolbar extends JToolBar {

	/***************************************************************************
	 *** Khai bao cac bien su dung cho chuong trinh ***
	 ***************************************************************************/

	// Khoi tao buttons de su dung tren ToolBar
	public JButton[] button;
	// Khoi tao ten file anh hien thi cua cac nut (24*24)
	public String[] imageName24 = { "images/Add24.gif", "images/List24.gif",
									"images/Add24.gif", "images/List24.gif",
									"images/Find24.gif", "images/Export24.gif", 
									"images/Import24.gif","images/Exit24.gif" };
	// Khoi tao tipText cho ToolBar
	public String[] tipText = { "Thêm sách", "Danh sách sách",
								"Thêm thành viên", "Danh sách thành viên", 
								"Tìm kiếm", "Mượn sách", 
								"Trả sách", "Thoát" };
	//Phuong thuc khoi tao lop ToolBar
	public Toolbar() {
		button = new JButton[19];
		for (int i = 0; i < imageName24.length; i++) {
			if (i == 2 || i == 4 || i == 5 || i == 7)
			//Them dau phan cach cho ToolBar
				addSeparator();
			// for adding the buttons to toolBar
			add(button[i] = new JButton(new ImageIcon(ClassLoader.getSystemResource(imageName24[i]))));
			// for setting the ToolTipText to the button
			button[i].setToolTipText(tipText[i]);
		}
	}
}
