/**
 * 
 */
package com.project.books;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.project.members.Members;


/**
 * @author Nam-Thuy92
 *
 */
public class BorrowBooks extends JInternalFrame {

	
	private JPanel northPanel = new JPanel();
	private JLabel title = new JLabel("Thông tin sách");
	private JPanel centerPanel = new JPanel();
	private JPanel informationPanel = new JPanel();
	private JLabel[] informationLabel = new JLabel[4];
	private String[] informationString = {" Nhập Book ID:", " Nhập Member ID:",
	                                      " Ngày hiện tại:", " Ngày trả:"};
	private JTextField[] informationTextField = new JTextField[4];
	private String date = new SimpleDateFormat("dd-MM-yy", Locale.getDefault()).format(new java.util.Date());
	private String[] data;

	private JPanel borrowButtonPanel = new JPanel();
	private JButton borrowButton = new JButton("Borrow");

	private JPanel southPanel = new JPanel();
	private JButton cancelButton = new JButton("Cancel");

	//khoi tao doi tuong su dung
	private Books book;
	private Members member;
	private Borrow borrow;

	//check thong tin tu textField
	public boolean isCorrect() {
		data = new String[4];
		for (int i = 0; i < informationLabel.length; i++) {
			if (!informationTextField[i].getText().equals(""))
				data[i] = informationTextField[i].getText();
			else
				return false;
		}
		return true;
	}

	//clear text field
	public void clearTextField() {
		for (int i = 0; i < informationTextField.length; i++)
			if (i != 2)
				informationTextField[i].setText(null);
	}

	public BorrowBooks() {
		super("Borrow Books", false, true, false, true);
		setFrameIcon(new ImageIcon(ClassLoader.getSystemResource("images/Export16.gif")));
		Container cp = getContentPane();

		northPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		title.setFont(new Font("Tahoma", Font.BOLD, 14));
		northPanel.add(title);
		cp.add("North", northPanel);

		centerPanel.setLayout(new BorderLayout());
		informationPanel.setLayout(new GridLayout(4, 2, 1, 1));

		for (int i = 0; i < informationLabel.length; i++) {
			informationPanel.add(informationLabel[i] = new JLabel(informationString[i]));
			informationLabel[i].setFont(new Font("Tahoma", Font.BOLD, 11));
			if (i == 2) {
				informationPanel.add(informationTextField[i] = new JTextField(date));
				informationTextField[i].setFont(new Font("Tahoma", Font.PLAIN, 11));
				informationTextField[i].setEnabled(false);
			}
			else {
				informationPanel.add(informationTextField[i] = new JTextField());
				informationTextField[i].setFont(new Font("Tahoma", Font.PLAIN, 11));
			}
		}
		centerPanel.add("Center", informationPanel);

		borrowButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		borrowButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		borrowButtonPanel.add(borrowButton);
		centerPanel.add("South", borrowButtonPanel);
		centerPanel.setBorder(BorderFactory.createTitledBorder("Borrow a book:"));
		cp.add("Center", centerPanel);

		southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		cancelButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		southPanel.add(cancelButton);
		southPanel.setBorder(BorderFactory.createEtchedBorder());
		cp.add("South", southPanel);
		
		//add su kien 
		borrowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (isCorrect()) {
					Thread runner = new Thread() {
						public void run() {
							book = new Books();
							member = new Members();
							borrow = new Borrow();
							book.connection("SELECT * FROM Books WHERE BookID = " + data[0]);
							member.connection("SELECT * FROM Members WHERE MemberID = " + data[1]);
							int numberOfAvailbleBooks = book.getNumberOfAvailbleBooks();
							int numberOfBorrowedBooks = 1 + book.getNumberOfBorrowedBooks();
							int numberOfBooks = 1 + member.getNumberOfBooks();
							if (numberOfAvailbleBooks == 1) {
								numberOfAvailbleBooks -= 1;
								book.update("UPDATE Books SET NumberOfAvailbleBooks =" + numberOfAvailbleBooks +
								        ",NumberOfBorrowedBooks =" + numberOfBorrowedBooks + ",Availble = false WHERE BookID =" + data[0]);
								member.update("UPDATE Members SET NumberOfBooks = " + numberOfBooks + " WHERE MemberID = " + data[1]);
								borrow.update("INSERT INTO Borrow (BookID, MemberID, DayOfBorrowed, DayOfReturn) VALUES (" +
								        data[0] + "," + data[1] + ",'" + data[2] + "','" + data[3] + "')");
								clearTextField();
							}
							else if (numberOfAvailbleBooks > 1) {
								numberOfAvailbleBooks -= 1;
								book.update("UPDATE Books SET NumberOfAvailbleBooks =" + numberOfAvailbleBooks +
								        ",NumberOfBorrowedBooks =" + numberOfBorrowedBooks + " WHERE BookID =" + data[0]);
								member.update("UPDATE Members SET NumberOfBooks =" + numberOfBooks + " WHERE MemberID =" + data[1]);
								borrow.update("INSERT INTO Borrow (BookID, MemberID, DayOfBorrowed, DayOfReturn) VALUES (" +
								        data[0] + "," + data[1] + ",'" + data[2] + "','" + data[3] + "')");
								JOptionPane.showMessageDialog(null, "The book is Successfully borrowed", "Success", JOptionPane.INFORMATION_MESSAGE);
								clearTextField();
							}
							else
								JOptionPane.showMessageDialog(null, "The book is Not Available", "Warning", JOptionPane.WARNING_MESSAGE);
						}
					};
					runner.start();
				}
				else
					JOptionPane.showMessageDialog(null, "Please, complete the information", "Warning", JOptionPane.WARNING_MESSAGE);//thong bao 
			}
		});
		//add event cho button cancel de dispose Frame.
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				dispose();
			}
		});
		setVisible(true);
		pack();
	}

}
