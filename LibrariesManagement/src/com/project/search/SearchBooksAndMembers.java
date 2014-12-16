package com.project.search;

import javax.swing.*;

import com.project.books.Books;
import com.project.books.ListSearchBooks;
import com.project.members.ListSearchMembers;
import com.project.members.Members;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

;

public class SearchBooksAndMembers extends JInternalFrame {

	/***************************************************************************
	 *** Khai bao cac bien su dung cho chuong trinh ***
	 ***************************************************************************/

	// Tao North Panel
	private JPanel northPanel = new JPanel();
	// Tao label
	private JLabel title = new JLabel("Search for list of Members");

	// Tao center
	private JPanel center = new JPanel();

	// Tao Center Panel
	private JPanel centerBooksPanel = new JPanel();
	// Tao Internal Panel tren center panel
	private JPanel searchBooksPanel = new JPanel();
	// Tao Internal Panel tren center panel
	private JPanel searchBooksButtonPanel = new JPanel();

	// Tao table
	private JLabel searchBooksLabel = new JLabel("Search by: ");
	// Tao JComboBox
	private JComboBox searchBooksTypes;
	// Tao mang String[] luu cac bookTypes
	private String[] booksTypes = { "BookID", "Subject", "Title", "Author",
			"Publisher", "ISBN" };
	// Tao label
	private JLabel booksKey = new JLabel(" Write Key: ");
	// Tao text field
	private JTextField booksKeyTextField = new JTextField();
	// Tao button
	private JButton searchBooksButton = new JButton("Search");

	// Tao Center Panel
	private JPanel centerMembersPanel = new JPanel();
	// Tao Internal Panel tren center panel
	private JPanel searchMembersPanel = new JPanel();
	// Tao Internal Panel tren center panel
	private JPanel searchMembersButtonPanel = new JPanel();

	// Tao table
	private JLabel searchMembersLabel = new JLabel("Search by: ");
	// Tao JComboBox
	private JComboBox searchMembersTypes;
	// Tao mang String[] luu cac membersTypes
	private String[] membersTypes = { "MemberID", "Name", "E-Mail", "Major" };
	// Tao label
	private JLabel membersKey = new JLabel(" Write Key: ");
	// Tao text field
	private JTextField membersKeyTextField = new JTextField();
	// Tao button
	private JButton searchMembersButton = new JButton("Search");

	// Tao south panel
	private JPanel southPanel = new JPanel();
	// Tao button
	private JButton cancelButton = new JButton("Cancer");

	// Tao mang String de luu tru du lieu
	private String[] booksData;
	private String[] membersData;
	// Tao cac doi tuong tu lop khac de su dung chung trong ActionListener
	private ListSearchBooks listBooks;
	private ListSearchMembers listMembers;
	private Books book;
	private Members member;

	// Kiem tra thong tin tu text field
	public boolean isBooksDataCorrect() {
		booksData = new String[2];
		booksData[0] = searchBooksTypes.getSelectedItem().toString();
		for (int i = 1; i < booksData.length; i++) {
			if (!booksKeyTextField.getText().equals("")) {
				if (searchBooksTypes.getSelectedItem().toString()
						.equals("BookID")) {
					booksData[i] = booksKeyTextField.getText();
				} else
					booksData[i] = "'%" + booksKeyTextField.getText() + "%'";
			} else
				return false;
		}
		return true;
	}

	// Kiem tra thong tin tu text field
	public boolean isMembersDataCorrect() {
		membersData = new String[2];
		membersData[0] = searchMembersTypes.getSelectedItem().toString();
		for (int i = 1; i < membersData.length; i++) {
			if (!membersKeyTextField.getText().equals("")) {
				if (searchMembersTypes.getSelectedItem().toString()
						.equals("MemberID")) {
					membersData[i] = membersKeyTextField.getText();
				} else
					membersData[i] = "'%" + membersKeyTextField.getText()
							+ "%'";
			} else
				return false;
		}
		return true;
	}

	// Phuong thuc khoi tao lop searchBooksAndMembers
	public SearchBooksAndMembers() {
		// Cai dat tieu de cho internal frame
		super("Search", false, true, false, true);
		// Cai dat icon
		setFrameIcon(new ImageIcon(
				ClassLoader.getSystemResource("images/Find16.gif")));

		Container cp = getContentPane();

		// Cai dat layout
		northPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		// Cai dat font
		title.setFont(new Font("Tahoma", Font.BOLD, 14));
		// Them label
		northPanel.add(title);
		// Them north panel vao container
		cp.add("North", northPanel);

		// Cai dat layout
		center.setLayout(new BorderLayout());
		centerBooksPanel.setLayout(new BorderLayout());
		searchBooksPanel.setLayout(new GridLayout(2, 2, 1, 1));
		// Them label
		searchBooksPanel.add(searchBooksLabel);
		// Them JComboBos[]
		searchBooksPanel.add(searchBooksTypes = new JComboBox(booksTypes));
		// Them label
		searchBooksPanel.add(booksKey);
		// Them text field
		searchBooksPanel.add(booksKeyTextField);
		// Them internal panel vao panel
		centerBooksPanel.add("North", searchBooksPanel);

		// Cai dat layout
		searchBooksButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		// Them button
		searchBooksButtonPanel.add(searchBooksButton);
		// Them internal panel vao center panel
		centerBooksPanel.add("South", searchBooksButtonPanel);
		// Cai dat border
		centerBooksPanel.setBorder(BorderFactory
				.createTitledBorder("Search Book:"));
		center.add("West", centerBooksPanel);

		// Cai dat layout
		centerMembersPanel.setLayout(new BorderLayout());
		searchMembersPanel.setLayout(new GridLayout(2, 2, 1, 1));
		// Them label
		searchMembersPanel.add(searchMembersLabel);
		// Them JComboBos[]
		searchMembersPanel
				.add(searchMembersTypes = new JComboBox(membersTypes));
		// Them label
		searchMembersPanel.add(membersKey);
		// Them text field
		searchMembersPanel.add(membersKeyTextField);
		// Them internal panel vao panel
		centerMembersPanel.add("North", searchMembersPanel);

		// Cai dat layout
		searchMembersButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		// Them button
		searchMembersButtonPanel.add(searchMembersButton);
		// Them internal panel vao center panel
		centerMembersPanel.add("South", searchMembersButtonPanel);
		// Cai dat border
		centerMembersPanel.setBorder(BorderFactory
				.createTitledBorder("Search Member:"));
		// Them center panel vao center
		center.add("East", centerMembersPanel);

		// Them center vao container
		cp.add("Center", center);

		/**
		 * Cai dat font cho lables & buttons
		 */
		searchBooksLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		searchBooksTypes.setFont(new Font("Tahoma", Font.BOLD, 11));
		booksKey.setFont(new Font("Tahoma", Font.BOLD, 11));
		booksKeyTextField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		searchBooksButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		cancelButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		searchMembersLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		searchMembersTypes.setFont(new Font("Tahoma", Font.BOLD, 11));
		membersKey.setFont(new Font("Tahoma", Font.BOLD, 11));
		membersKeyTextField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		searchMembersButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		cancelButton.setFont(new Font("Tahoma", Font.BOLD, 11));

		// Cai dat layout
		southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		// Them button
		southPanel.add(cancelButton);
		// Cai dat border
		southPanel.setBorder(BorderFactory.createEtchedBorder());
		// Them south panel vao container
		cp.add("South", southPanel);

		/***********************************************************************
		 * Them action listener cho button *
		 ***********************************************************************/
		searchBooksButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				// for checking if there is a missing information
				if (isBooksDataCorrect()) {
					book = new Books();
					String bookQuery = "SELECT BookID, Subject, Title, Author, Publisher,"
							+ "Copyright, Edition, Pages, NumberOfBooks,ISBN,Library,Availble,ShelfNo FROM Books"
							+ " WHERE "
							+ booksData[0]
							+ " LIKE "
							+ booksData[1];
					book.connection(bookQuery);
					int bookID = book.getBookID();
					if (bookID != 0) {
						listBooks = new ListSearchBooks(bookQuery);
						getParent().add(listBooks);
						try {
							listBooks.setSelected(true);
						} catch (java.beans.PropertyVetoException e) {
						}
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "No Match(es)",
								"Error", JOptionPane.ERROR_MESSAGE);
						booksKeyTextField.setText(null);
					}
				} else
					JOptionPane.showMessageDialog(null,
							"Please, complete the information", "Warning",
							JOptionPane.WARNING_MESSAGE);
			}
		});

		searchMembersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (isMembersDataCorrect()) {
					member = new Members();
					String memberQuery = "SELECT MemberID, ID, Name, EMail, Major, Expired"
							+ " FROM Members WHERE "
							+ membersData[0]
							+ " LIKE " + membersData[1];
					member.connection(memberQuery);
					int memberID = member.getMemberID();
					if (memberID != 0) {
						listMembers = new ListSearchMembers(memberQuery);
						getParent().add(listMembers);
						try {
							listMembers.setSelected(true);
						} catch (java.beans.PropertyVetoException e) {
						}
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "No Match(es)",
								"Error", JOptionPane.ERROR_MESSAGE);
						membersKeyTextField.setText(null);
					}
				} else
					JOptionPane.showMessageDialog(null,
							"Please, complete the information", "Warning",
							JOptionPane.WARNING_MESSAGE);
			}
		});
		// Them action listener cho nut cancelButton
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				dispose();
			}
		});
		setVisible(true);
		// Hien thi internal frame
		pack();
	}
}
