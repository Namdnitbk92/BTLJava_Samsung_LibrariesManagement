package com.project.search;

import javax.swing.*;

import com.project.books.Books;
import com.project.books.ListSearchBooks;
import com.project.members.ListSearchMembers;
import com.project.members.Members;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchBooksAndMembers extends JInternalFrame {

	/***************************************************************************
	 *** Khai bao cac bien su dung cho chuong trinh ***
	 ***************************************************************************/

	// Tao North Panel
	private JPanel northPanel = new JPanel();
	// Tao label
	private JLabel title = new JLabel("Tìm kiếm sách và thành viên");

	// Tao center
	private JPanel center = new JPanel();

	// Tao Center Panel
	private JPanel centerBooksPanel = new JPanel();
	// Tao Internal Panel tren center panel
	private JPanel searchBooksPanel = new JPanel();
	// Tao Internal Panel tren center panel
	private JPanel searchBooksButtonPanel = new JPanel();

	// Tao table
	private JLabel searchBooksLabel = new JLabel(" Tìm kiếm bằng: ");
	// Tao JComboBox
	private JComboBox searchBooksTypes;
	// Tao mang String[] luu cac bookTypes
	private String[] booksTypes = { "BookID", "Subject", "Title", "Author",
			"Publisher", "ISBN" };
	// Tao label
	private JLabel booksKey = new JLabel(" Viết từ khóa: ");
	// Tao text field
	private JTextField booksKeyTextField = new JTextField();
	// Tao button
	private JButton searchBooksButton = new JButton("Tìm kiếm");

	// Tao Center Panel
	private JPanel centerMembersPanel = new JPanel();
	// Tao Internal Panel tren center panel
	private JPanel searchMembersPanel = new JPanel();
	// Tao Internal Panel tren center panel
	private JPanel searchMembersButtonPanel = new JPanel();

	// Tao table
	private JLabel searchMembersLabel = new JLabel(" Tìm kiếm bằng: ");
	// Tao JComboBox
	private JComboBox searchMembersTypes;
	// Tao mang String[] luu cac membersTypes
	private String[] membersTypes = { "MemberID", "Name", "E-Mail", "Major" };
	// Tao label
	private JLabel membersKey = new JLabel(" Viết từ khóa: ");
	// Tao text field
	private JTextField membersKeyTextField = new JTextField();
	// Tao button
	private JButton searchMembersButton = new JButton("Tìm kiếm");

	// Tao south panel
	private JPanel southPanel = new JPanel();
	// Tao button
	private JButton cancelButton = new JButton("Hủy bỏ");

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

	}
}
