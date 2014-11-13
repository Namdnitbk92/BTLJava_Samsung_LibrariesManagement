package com.project.LibrariesBook;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
/**
 * 
 */
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



/**
 * @author Nam-Thuy92
 *
 */
public class AddBooks extends JInternalFrame {

	/**
	 * 
	 */
	public AddBooks() {
		// TODO Auto-generated constructor stub
	}
	 //khoi tao North Panel
    private JPanel northPanel = new JPanel();
    //khoi tao nhan North Label
    private JLabel northLabel = new JLabel("THÔNG TIN SÁCH");
    
    //khoi tao  Center Panel
    private JPanel centerPanel = new JPanel();
    //khoi tao Internal Panel ben trong  center panel
    private JPanel informationLabelPanel = new JPanel();

    //khoi tao mang JLabel
    private JLabel[] informationLabel = new JLabel[10];
    private JLabel lblShelfNo = new JLabel(" Shelf No");
    private JTextField txtShelfNo = new JTextField();
    //khoi tao mang String
    private String[] informationString = {
        " Chủ đề sách : ", " Tiêu đề sách : ",
        " Tên tác giả (s): ", " Tên nhà xuất bản : ",
        " Bản quyền : ", " Số lần xuất bản : ", " Số trang : ",
        " ISBN của sách : ", " Số lần nhân bản : ", " Tên nhà sách : "
    };
    //khoi tao Internal Panel TextField ben trong center panel
    private JPanel informationTextFieldPanel = new JPanel();
    //khoi tao mang  JTextField
    private JTextField[] informationTextField = new JTextField[10];

    //khoi tao Internal Panel ben trong center panel
    private JPanel insertInformationButtonPanel = new JPanel();
    //khoi tao cac button
    private JButton insertInformationButton = new JButton("Thêm thông tin về sách :");

    //khoi tao South Panel
    private JPanel southPanel = new JPanel();
    private JButton OKButton = new JButton("Exit");

    //khoi tao cac doi tuong tu cac lop khac neu su dung chung trong ActionListener
    private Books book;
    //for creating an array of string to store the data
    //khoi tao mang String de luu du lieu sach
    private String[] data;
    //khoi tao bien check trang thai sach trong thu vien
    private boolean availble = true;

}
