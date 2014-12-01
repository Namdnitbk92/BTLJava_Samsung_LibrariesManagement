package com.project.members;

/*@athor Tran Van Thuan*/
import java.awt.*;
import java.util.Date;

import javax.swing.*;

public class AddMembers extends JInternalFrame 
{
//khai bao bien private
    //tao North Panel
	private JPanel northPanel = new JPanel();
    //tao North Label
	private JLabel northLabel = new JLabel("Thong tin Sinh vien");
	//tao Center Panel
	private JPanel centerPanel = new JPanel();
	//tao mot Internal Panel trong center panel
	private JPanel informationLabelPanel = new JPanel();
	//tao mot mang JPanel
	private JLabel[] informationLabel = new JLabel[7];
	//tạo 1 mảng String
	private String[] informationString = {"Member ID:","The Password:","Rewrite the password:",
			                              "The Name:","E-mail:","Major Branch:","Expired:"};
	//tao 1 Internal Panel trong center panel
	private JPanel informationTextFieldPanel = new JPanel();
	//tao 1 mang JTextField
	private JTextField[] informationTextField = new JTextField[5];
	//tao 1 mang JPasswordField
	private JPasswordField[] informationPasswordField = new JPasswordField[2] ;
	//tạo 1 Internal Panel trong Center Panel
	private JPanel insertInformationButtonPanel = new JPanel();
	
	//tạo South Panel
	private JPanel southPanel = new JPanel() ;
	//tạo 1 button
	private JButton oKButton = new JButton("Exit");
	//tạo ra các đối tượng từ các lớp khác để sử dụng chúng trong các ActionListener
	private Members member ;
	//tạo 1 mang string de luu tru du lieu
	private String[] data ;
	//kiem tra password
	public boolean isPasswordCorrect(){
		if (informationPasswordField[0].getText().equals(informationPasswordField[1].getText()))
			data[1] = informationPasswordField[1].getText();
		else if(!informationPasswordField[0].getText().equals(informationPasswordField[1].getText()))
				return false ;
		
		return true ;
    }
	
	//kiem tra thong tin tu text field
	public boolean isCorrect()
	{
		data = new String[6];
		for(int i = 0 ;i <informationLabel.length ; i++)
		{
			if(i == 0) 
			{
				if(!informationTextField[i].getText().equals("")){
					data[i] = informationTextField[i].getText();
				}
				else
					return false ;
		    }
			if(i == 1|| i == 2)
			{
				if(informationPasswordField[i - 1].getText().equals(""))
					return false ;
			}
			if(i == 3 || i == 4 || i ==5 || i == 6)
			{
				if(!informationTextField[i-2].getText().equals(""))
				{
					data [i - 1] = informationTextField[i - 2].getText();
				}
				else
					return false ;
			}
	     }  
		 return true ;
	}
	
	//thiết lập mảng JTextField & JPasswordField = null
	public void clearTextField() {
		for (int i = 0; i < informationLabel.length ;i++)
		{
			if (i == 0)
				informationTextField[i].setText(null);
			if (i == 1 || i == 2)
				informationPasswordField[i-1].setText(null) ;
			if (i == 3 || i == 4 || i == 5 || i == 6)
				informationTextField[i-2].setText(null);
		}
	}
	//constructor cho addMembers
	public AddMembers () {
		//thiet lap tieu de cho internal frame
		super ("Thêm Members", false, true,false, true );
		//thiết lập icon
		setFrameIcon(new ImageIcon(ClassLoader.getSystemResource("images/Add16.gif")));
		//thành phần giao diện đồ họa người dùng
		Container cp = getContentPane() ;
		
		//thiết lập layout
		northPanel.setLayout (new FlowLayout (FlowLayout.CENTER)) ;
		//thiết lập font
		northLabel.setFont(new Font ("Tahoma",Font.BOLD, 14) );
		//thêm label cho panel
		northPanel.add(northLabel);
		//thêm panel cho container
		cp.add("North",northPanel);
		
		//thiết lập layout
		centerPanel.setLayout(new BorderLayout());
		//thiết lập border cho panel
		centerPanel.setBorder(BorderFactory.createTitledBorder("Thêm 1 Member mới"));
		//thiết lập layout
		informationLabelPanel.setLayout(new GridLayout(7, 1, 1, 1));
		//thiết lập layout
		informationTextFieldPanel.setLayout(new GridLayout(7,1,1,1));
		
		//thêm strings cho label, thiết lập font 
		//và thêm những label này cho panel
		//cuối cùng thêm panel cho container
		
		for(int i = 0; i< informationLabel.length; i++)
		{
			informationLabelPanel.add(informationLabel[i]= new JLabel(informationString[i]));
			informationLabel[i].setFont(new Font ("Tahoma",Font.BOLD,11));			
		}
		//thêm panel cho centerPanel
		centerPanel.add("West", informationLabelPanel) ;	
		
		//thêm JTextField và JPasswordField cho panel và 
		//thiết lập font cho JTextField và JPasswordField
		//cuối cùng thêm panel cho centerPanel
		
		for( int i = 0; i< informationLabel.length; i++)
		{
			if(i== 1||i ==2)
			{
				informationTextFieldPanel.add(informationPasswordField[i-1] = new JPasswordField(25)) ;
				informationPasswordField[i-1].setFont(new Font("Tohama",Font.PLAIN,11));				
			}
			if (i == 0)
			{
				informationTextFieldPanel.add(informationTextField[i] = new JTextField(25));
				
			}
		}
	}
	

}
