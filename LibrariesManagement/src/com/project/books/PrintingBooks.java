package com.project.books;

import javax.swing.*;


import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.sql.*;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 *@author Bach
 **/
public class PrintingBooks extends JInternalFrame implements Printable
{
/*
 *                       khởi tạo biến sử dụng trong chương trình
 */
	
	// thiết lập kết nối và trạng thái
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;
	private String URL = "jdbc:odbc:JLibrary";
	// khởi tạo vùng text
		private JTextArea textArea = new JTextArea();
		//khởi tạo vector dùng cho việc in
		private Vector lines;
		public static final int TAB_SIZE = 5;
		//kiến trúc của thư viện
		public PrintingBooks(String query) 
		{
			super("Printing Books", false, true, false, true);
			// lấy giao diện đồ họa của người dùng 
			Container cp = getContentPane();
			// thiết lập font chữ
			textArea.setFont(new Font("Tahoma", Font.PLAIN, 9));
			//thêm vùng text vào container
			cp.add(textArea);	
			try 
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			}
			catch (ClassNotFoundException ea) 
			{
				System.out.println(ea.toString());
			}
			catch (Exception e) 
			{
				System.out.println(e.toString());
			}
			/***************************************************************
			 * tạo kết nối báo cáo và update bảng biểu trong cơ sở dữ liệu *
			 * sau khi đóng các báo cáo và kết nối  *
			 ***************************************************************/
			try 
			{
				connection = DriverManager.getConnection(URL);
				statement = connection.createStatement();
				resultset = statement.executeQuery(query);
				textArea.append("=============== Books Information ===============\n\n");
				while (resultset.next()) 
				{
					textArea.append("Subject: " + resultset.getString("Subject") + "\n" +
					        "Title: " + resultset.getString("Title") + "\n" +
					        "Author(s): " + resultset.getString("Author") + "\n" +
					        "Copyright: " + resultset.getString("Copyright") + "\n" +
					        "Edition: " + resultset.getString("Edition") + "\n" +
					        "ISBN: " + resultset.getString("ISBN") + "\n" +
					        "Library: " + resultset.getString("Library") + "\n\n");
				}
				textArea.append("=============== Books Information ===============");
				resultset.close();
				statement.close();
				connection.close();
			}
			catch (SQLException SQLe) 
			{
				System.out.println(SQLe.toString());
			}
			//thiết lập giá trị 'true' cho  visible 
			setVisible(true);
			// đưa ra khung
			pack();
		}
	@Override
	public int print(Graphics pg, PageFormat pageFormat, int pageIndex)
			throws PrinterException {
		pg.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());
		int wPage = (int) pageFormat.getImageableWidth();
		int hPage = (int) pageFormat.getImageableHeight();
		pg.setClip(0, 0, wPage, hPage);

		pg.setColor(textArea.getBackground());
		pg.fillRect(0, 0, wPage, hPage);
		pg.setColor(textArea.getForeground());

		Font font = textArea.getFont();
		pg.setFont(font);
		FontMetrics fm = pg.getFontMetrics();
		int hLine = fm.getHeight();

		if (lines == null)
			lines = getLines(fm, wPage);

		int numLines = lines.size();
		int linesPerPage = Math.max(hPage / hLine, 1);
		int numPages = (int) Math.ceil((double) numLines / (double) linesPerPage);
		if (pageIndex >= numPages) 
		{
			lines = null;
			return NO_SUCH_PAGE;
	    }
	
		int x = 0;
		int y = fm.getAscent();
		int lineIndex = linesPerPage * pageIndex;
		while (lineIndex < lines.size() && y < hPage) 
		{
			String str = (String) lines.get(lineIndex);
			pg.drawString(str, x, y);
			y += hLine;
			lineIndex++;
		}
		return PAGE_EXISTS;
	}

	protected Vector getLines(FontMetrics fm, int wPage) 
	{
		Vector v = new Vector();

		String text = textArea.getText();
		String prevToken = "";
		StringTokenizer st = new StringTokenizer(text, "\n\r", true);
		while (st.hasMoreTokens()) 
		{
			String line = st.nextToken();
			if (line.equals("\r"))
				continue;
			/* StringTokenizer sẽ bỏ qua các dòng trắng , 
			vì vậy đó là một chút khó khăn để có được chúng ...*/
			if (line.equals("\n") && prevToken.equals("\n"))
				v.add("");
			prevToken = line;
			if (line.equals("\n"))
				continue;

			StringTokenizer st2 = new StringTokenizer(line, " \t", true);
			String line2 = "";
			while (st2.hasMoreTokens()) 
			{
				String token = st2.nextToken();
				if (token.equals("\t")) 
				{
					int numSpaces = TAB_SIZE - line2.length() % TAB_SIZE;
					token = "";
					for (int k = 0; k < numSpaces; k++)
						token += " ";
				}
				int lineLength = fm.stringWidth(line2 + token);
				if (lineLength > wPage && line2.length() > 0) 
				{
					v.add(line2);
					line2 = token.trim();
					continue;
				}
				line2 += token;
			}
			v.add(line2);
		}
		return v;
	}
}
