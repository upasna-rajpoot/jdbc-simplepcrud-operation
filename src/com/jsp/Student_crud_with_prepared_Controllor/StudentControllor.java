package com.jsp.Student_crud_with_prepared_Controllor;

import java.security.Provider.Service;
import java.util.Scanner;

import com.jsp.Student_crud_with_prepared_dAO.StudentDAO;
import com.jsp.Student_crud_with_prepared_dAO.StudentService;
import com.jsp.Student_crud_with_prepared_dto.Student;

public class StudentControllor {
	 static StudentService service=new StudentService();
	StudentDAO studentDAO=new StudentDAO();
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		while(true)
		{
		System.out.println("1  For insert");
		System.out.println("2. For update");
		System.out.println("3. For Display");
		System.out.println("4. For Delete");
		System.out.println(" Enter your choice");
		int ch=sc.nextInt();
		
		switch(ch)
		{
		case 1:
		{
			System.out.println("enter the id");
			int id=sc.nextInt();
			System.out.println("enter your name");
			String name=sc.next();
			System.out.println("enter your email");
			String email=sc.next();
			System.out.println("enter your phone");
			long phone=sc.nextLong();
			Student student=new Student(id,name,email,phone);
			service.insertStudentService(student);
			
		}
		break;
		case 2:
		{
			System.out.println("1 For update name");
			System.out.println("2. For update email");
			System.out.println("3. for update phone");
			
			int select=sc.nextInt();
			
			switch(select)
			{
			case 1:
			{
				System.out.println("Enter the name");
				String name=sc.next();
				System.out.println("enter the exiting id");
				int id=sc.nextInt();
				int a=service.updateStudentServiceName(id,name);
				if(a==1) {
					System.out.println("Data stored successfully");
				}
				else {
					System.out.println("dont match id");
				}
			}
			break;
			case 2:{
				System.out.println("Enter the email");
				String email=sc.next();
				System.out.println("enter the exiting id");
				int id=sc.nextInt();
				int a=service.updateStudentServiceEmail(id,email);
				if(a==1) {
					System.out.println("Data stored successfully");
				}
				else {
					System.out.println("dont match id");
				}
			}
		break;
			case 3:{
				System.out.println("Enter the phone");
				long phone=sc.nextLong();
				System.out.println("enter the exiting id");
				int id=sc.nextInt();
				int a=service.updateStudentServicePhone(id,phone);
				if(a==1) {
					System.out.println("Data stored successfully");
				}
				else {
					System.out.println("dont match id");
				}
			}
		break;
		}
		
		}
		break;
		
		
		case 3:{
			service.displayStudentService();
			System.out.println("data display completed");
		}
		break;
		
		
		case 4:{
			System.out.println("Enter the id");
			int id=sc.nextInt();
			int res=service.deleteStudentService(id);
			if(res==1) {
				System.out.println("Data deleted successfully");
			}
			else {
				System.out.println("dont match id");
			}
		}
		}
		
	
		
		
		
		System.out.println("main method ended");
		}
		
	}

}
