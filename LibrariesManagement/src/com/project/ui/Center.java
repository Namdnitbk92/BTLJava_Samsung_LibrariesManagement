package com.project.ui;

import java.awt.*;

public class Center {
	JLibrary l; //De su dung class JLibrary.java

	public Center(JLibrary l) {
		this.l = l;
	}

	public void LibraryCenter() {
		//Chinh sua cua so hien thi
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		l.setLocation((screenSize.width - l.getWidth()) / 2, (screenSize.height - l.getHeight()) / 2);
	}
}
