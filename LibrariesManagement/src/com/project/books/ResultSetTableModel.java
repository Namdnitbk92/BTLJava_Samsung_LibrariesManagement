package com.project.books;
import javax.swing.table.AbstractTableModel;

import java.sql.*;
/**
 *Các hàng cột của ResultSet được đếm từ 1 và  các hàng cột của JTable 
 *được đếm từ 0 .Khi xử lí các hàng và cột của ResultSet
 *  cho sử dụng trong JTable, đó là điều cần thiết để thêm 1 
 *necessary to add 1 cho số hàng cột để vận dụng cột ResultSet thích hợp
 * (i.e., cột 0 JTable  là cột 1 của  ResultSet  and hàng 0 của JTable  
 * là hàng 1 của  ResultSet)
 */
public class ResultSetTableModel extends AbstractTableModel {
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private ResultSetMetaData metaData;
	private int numberOfRows;
	// keep track of database connection status
	private boolean connectedToDatabase = false;
}