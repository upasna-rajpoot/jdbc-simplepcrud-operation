package com.jsp.Student_crud_with_prepared_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentConnection 
{
  public static Connection getConnection() {
	  
	  
	  try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/preparedstatement";
		String user="root";
		String pass="root";
		
		Connection connection=DriverManager.getConnection(url, user, pass);
		return connection;
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	  
  }
}
