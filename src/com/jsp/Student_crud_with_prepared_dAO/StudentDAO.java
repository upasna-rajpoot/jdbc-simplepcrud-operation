package com.jsp.Student_crud_with_prepared_dAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsp.Student_crud_with_prepared_Connection.StudentConnection;
import com.jsp.Student_crud_with_prepared_dto.Student;

public class StudentDAO {
	/**
	 * insert method for 	 */
	
	Connection connection =StudentConnection.getConnection();
	
	public Student insertStudent(Student student) {
		
		String insertQuery="insert into student values(?,?,?,?)";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(insertQuery);
			
			preparedStatement.setInt(1, student.getStudentId());
			preparedStatement.setString(2, student.getStudentName());
			preparedStatement.setString(3, student.getStudentEmail());
			preparedStatement.setLong(4, student.getStudentPhone());
			
			preparedStatement.execute();
			
			System.out.println("data stored successfully");
			return student;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
		
	}
	public int updateStudentName(int studentId,String studentName) 
	{
		String updateQuery="update student set studentName=? where studentIdt=?";
		
		try {
			PreparedStatement preparedStatement=connection.prepareCall(updateQuery);
			preparedStatement. setInt(2,studentId);
			preparedStatement.setString(1, studentName);
		return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	public int updateStudentEmail(int studentId,String studentEmail) 
	{
		String updateQuery="update student set studentcoEmail=? where studentIdt=?";
		
		try {
			PreparedStatement preparedStatement=connection.prepareCall(updateQuery);
			preparedStatement. setInt(2,studentId);
			preparedStatement.setString(1, studentEmail);
		return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public int updateStudentPhone(int studentId,long studentPhone) 
	{
		String updateQuery="update student set studentPhone=? where studentIdt=?";
		
		try {
			PreparedStatement preparedStatement=connection.prepareCall(updateQuery);
			preparedStatement. setInt(2,studentId);
			preparedStatement.setLong(1, studentPhone);
		return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public void displayStudentDetails() {
		
		String displayQuery="select * from student";
		 
		try {
			PreparedStatement preparedStatement=connection.prepareCall(displayQuery);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
			int id =resultSet.getInt("studentIdt");
			String name=resultSet.getString("studentName");
			String email=resultSet.getString("studentcoEmail");
			long phone=resultSet.getLong("studentPhone");
			
			System.out.println("id:-"+id);
			System.out.println("name:--"+name);
			System.out.println("email:--"+email);
			System.out.println("phone:--"+phone);
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int deleteStudent(int id) {
		String deleteQuery="delete from student where studentIdt=?";
		
		try {
			PreparedStatement preparedStatement=connection.prepareCall(deleteQuery);
			preparedStatement.setInt(1,id);
			return preparedStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	

}
