package com.project.members;
/*Tran Van Thuan*/
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
	
	public void connection (String Query) {
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		}
		catch(ClassNotFoundException e1)
		{
			System.out.println("Members.java \n" + e1.toString());
		}
		catch(Exception e2)
		{
			System.out.println("Members.java\n" +e2.toString());
		}
		/* tao connection, tao statement va update bang CSDL. Sau do dong statement
		 * va connection .Khoi SQLException de bat loi 
		 * */
		
		try
		{
			connection = DriverManager.getConnection(URL);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(Query);
			while(resultSet.next()) 
			{
				memberID = resultSet.getInt(1);
				ID = resultSet.getInt(2);
				password = resultSet.getString(3);
				name = resultSet.getString(4);
				email = resultSet.getString(5);
				major = resultSet.getString(6);
				numberOfBooks = resultSet.getInt(7);
				mony = resultSet.getInt(8);
				expired = resultSet.getDate(9);				
			}
			resultSet.close();
			statement.close();
			connection.close();
		}
		catch(SQLException SQLe) {
			System.out.println("Members.java\n"+SQLe.toString());
		}		
	}
	public void update (String Query){
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");			
		}
		catch(ClassNotFoundException e3){
			System.out.println("Members.java\n"+e3.toString());
		}
		catch(Exception e4){
			System.out.println("Members.java\n"+e4.toString());
		}
		
		/*
		 * tao ket noi,tao khai bao va cap nhat
		 * bang co so du lieu.Sau do dong cac khai bao
		 * va ket noi.Khoi SQLException cho viec bat loi
		 * */
		try{
			connection = DriverManager.getConnection(URL);
			statement = connection.createStatement();
			statement.executeUpdate(Query);
			statement.close();
			connection.close();
		}
		catch(SQLException SQLe){
			System.out.println("Members.java\n"+SQLe.toString());
		}
		}
	}
	

