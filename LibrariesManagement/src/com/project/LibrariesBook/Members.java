package com.project.LibrariesBook;
import java.sql.*;

public class Members {
	//khai bao cac bien private
	
	private Connection connection = null ;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	private int memberID ;
	private int ID;
	private String password;
	private String name ;
	private String email ;
	private String major ;
	private int numberOfBooks ;
	private int mony ;
	private Date expired ;
	private String URL = "jdbc:odbc:JLibrary ";
	
	//tao constructor Members()
	public Members(){
	}
	
	public int getMemberID(){
		return memberID ;
	}
	
	public int getID(){
		return ID ;
	}
	
	public String getPassword() {
		return password ;
	}
	
	public String getName() {
		return name ;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getMajor(){
		return major ;
	}
	
	public int getNumberOfBooks(){
		return numberOfBooks ;
	}
	
	public int getMony(){
		return mony ;
	}
	
	public Date getExpired() {
		return expired ;
	}
	
	pulic void connection (String Query) {
		try{
			Class.forName("sun.jdbc.odbc")
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
