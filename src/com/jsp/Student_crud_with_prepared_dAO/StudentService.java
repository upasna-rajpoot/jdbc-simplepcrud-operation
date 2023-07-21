package com.jsp.Student_crud_with_prepared_dAO;

import com.jsp.Student_crud_with_prepared_dto.Student;

public class StudentService 
{
StudentDAO dao=new StudentDAO();

public Student insertStudentService(Student student)
{
	
	System.out.println("insertService method started");
	if(student.getStudentId()<=9999) {
		Student student2=dao.insertStudent(student);
		return student2;
	}
	else {
		System.err.println("please pass your id with 4 digit or less than 4");
	}
	return null;
}
public int updateStudentServiceName(int studentId,String studentName) {
	return dao.updateStudentName(studentId, studentName);
}
public int updateStudentServiceEmail(int studentId,String studentEmail) {
	return dao.updateStudentEmail(studentId, studentEmail);
}
public int updateStudentServicePhone(int studentId,long studentPhone) {
	return dao.updateStudentPhone(studentId, studentPhone);
}
public void displayStudentService() {
	dao.displayStudentDetails();
}
public int deleteStudentService(int id) {
	return dao.deleteStudent(id);
}
}
