package com.project.ui;

import javax.swing.*;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;

public class StatusBar extends JPanel {
	
	/***************************************************************************
     ***         Khai bao cac bien su dung cho chuong trinh                  ***
     ***************************************************************************/
	
	private JLabel statusBar = new JLabel("  ");

	//Phuong thuc khoi tao cho lop StatusBar
	public StatusBar() {
		statusBar.setFont(new Font("Tahoma", Font.BOLD, 9));
		this.add(statusBar);
		this.setBorder(new SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
	}
}
