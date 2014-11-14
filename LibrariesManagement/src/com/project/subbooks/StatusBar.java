package com.project.subbooks;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;

import java.awt.*;
/** A public class */

public class StatusBar extends JPanel
{
	
/* khai báo biến sử dụng trong chương trình */
	
private JLabel statusBar = new JLabel(" ");

// Xây dựng thanh StatusBar
public StatusBar()
{
	statusBar.setFont(new Font("Tahoma", Font.BOLD, 9));
	this.add(statusBar);
	this.setBorder(new SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
}

}

