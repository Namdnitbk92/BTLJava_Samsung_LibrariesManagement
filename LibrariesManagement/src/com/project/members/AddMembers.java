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

}
