package com.project.LibrariesBook;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
/**
 * 
 */
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    
  //ham kiem tra thong tin duoc nhap tu Text Field
    public boolean isCorrect() {
        data = new String[10];
        for (int i = 0; i < informationLabel.length; i++) {
            if (!informationTextField[i].getText().equals("")) {
                data[i] = informationTextField[i].getText();
            } else {
                return false;
            }
        }
        return true;
    }
    //cai dat mang cac JTextField mac dinh gia tri ban dau la null.
    public void clearTextField() {
        for (int i = 0; i < informationTextField.length; i++) {
            informationTextField[i].setText(null);
        }
        txtShelfNo.setText(null);
    }
    //ham khoi tao cua class Addbooks
    public AddBooks() {
        //set title cho frame ben trong
        super("Add Books", false, true, false, true);
        //setting cac Icon
        setFrameIcon(new ImageIcon(ClassLoader.getSystemResource("images/Add16.gif")));
        //for getting the graphical user interface components display area
        //get Graphical xay dung giao dien nguoi dung de hien thi 
        Container cp = getContentPane();

        //Setting cac Layout
        northPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        //cai dat font cho northLabel
        northLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        //them label vao trogn northLabel
        northPanel.add(northLabel);
        //for adding the north panel to the container
        //them north panel vao Container
        cp.add("North", northPanel);

        //Setting Layout
        centerPanel.setLayout(new BorderLayout());
        //Setting Border cho Layout
        centerPanel.setBorder(BorderFactory.createTitledBorder("Add a new book:"));
        
        informationLabelPanel.setLayout(new GridLayout(11, 1, 1, 1));
        /***********************************************************************
         * them String cho cac labels,font va them cac labels vao panel			*
         * mac dinh them panel vao container									*
         ***********************************************************************/
        for (int i = 0; i < informationLabel.length; i++) {
            informationLabelPanel.add(informationLabel[i] = new JLabel(informationString[i]));
            informationLabel[i].setFont(new Font("Tahoma", Font.BOLD, 11));
        }
        centerPanel.add("West", informationLabelPanel);

        informationTextFieldPanel.setLayout(new GridLayout(11, 1, 1, 1));
        for (int i = 0; i < informationTextField.length; i++) {
            informationTextFieldPanel.add(informationTextField[i] = new JTextField(25));
            informationTextField[i].setFont(new Font("Tahoma", Font.PLAIN, 11));
        }
        lblShelfNo.setFont(new Font("Tahoma", Font.BOLD, 11));
        informationLabelPanel.add(lblShelfNo);
        txtShelfNo.setFont(new Font("Tahoma", Font.PLAIN, 11));
        informationTextFieldPanel.add(txtShelfNo);
        centerPanel.add("East", informationTextFieldPanel);

        /*******************************************************************************
         * setting layout cho panel,font cho cac button va them cac button vao panel 	*
         *  																			*
         * 																				*
         *******************************************************************************/
        insertInformationButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        insertInformationButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        insertInformationButtonPanel.add(insertInformationButton);
        centerPanel.add("South", insertInformationButtonPanel);
        cp.add("Center", centerPanel);

        /***********************************************************************
         * for setting the layout for the panel,setting the font for the button*
         * adding the button to the panel & setting the border.				   *
         * finally adding the panel to the container						   *
         ***********************************************************************/
        southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        OKButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        southPanel.add(OKButton);
        southPanel.setBorder(BorderFactory.createEtchedBorder());
        cp.add("South", southPanel);

        /*************************************************************************
         * them Action Listener bat su kien cho cac button,dau tien cac doi tuong *
         * text se lay tu JTextField[] va tao nen cac connection toi CSDL,sau do  *
         * update cac table trong CSDL voi gia tri moi                            *
         *************************************************************************/
        insertInformationButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

            	//kiem tra neu nhap thieu thong tin them sach
                if (isCorrect()) {
                    Thread runner = new Thread() {

                        public void run() {
                            book = new Books();
                            //for checking if there is no double information in the database
                            //kiem tra neu khong co 2 thong tin cung 1 loai sach trong CSDL
                            book.connection("SELECT BookID FROM Books WHERE ISBN = '" + data[7] + "'");
                            String ISBN = book.getISBN();
                            if (!data[7].equalsIgnoreCase(ISBN)) {
                                try{
                                    String sql="INSERT INTO Books (Subject,Title,Author,Publisher,Copyright," +
                                        "Edition,Pages,ISBN,NumberOfBooks,NumberOfAvailbleBooks,Library,Availble,ShelfNo) VALUES "+
                                        " (?,?,?,?,?,?,?,?,?,?,?,?,?)";
                                        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                                        Connection con=DriverManager.getConnection("jdbc:odbc:JLibrary");
                                        PreparedStatement ps=con.prepareStatement(sql);
                                        ps.setString(1, data[0]);
                                        ps.setString(2, data[1]);
                                        ps.setString(3, data[2]);
                                        ps.setString(4, data[3]);                                        
                                        ps.setInt(5, Integer.parseInt(data[4]));
                                        ps.setInt(6,Integer.parseInt(data[5]));
                                        ps.setInt(7, Integer.parseInt(data[6]));
                                        ps.setString(8, data[7]);
                                        ps.setInt(9, Integer.parseInt(data[8]));
                                        ps.setInt(10, Integer.parseInt(data[8]));
                                        ps.setString(11, data[9]);
                                        ps.setBoolean(12, availble);
                                        ps.setInt(13, Integer.parseInt(txtShelfNo.getText()));
                                        ps.executeUpdate();      
                                }catch(Exception ex){
                                    JOptionPane.showMessageDialog(null, ex.toString());
                                }
                                
                                clearTextField();
                            } else {
                                JOptionPane.showMessageDialog(null, "Sach da co trong thu vien", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    };
                    runner.start();
                } //neu thieu du lieu ve sach,hien thi thong bao cho nguoi dung nhap du thong tin sach
                else {
                    JOptionPane.showMessageDialog(null, "Hay nhap du thong tin sach", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        //tthem su kien cho cac button de xu ly trong frame
        OKButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                dispose();
            }
        });
        setVisible(true);//hien thi frame
        pack();
    }
}
