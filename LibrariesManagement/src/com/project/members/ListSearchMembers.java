package com.project.members;

import javax.swing.*;
import javax.swing.table.TableColumn;

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
	private JLabel label = new JLabel ("Danh sách tìm kiếm thành viên");
	//tạo button
	private JButton printButton ;
	//tạo table
	private JTable table ;
	

}
