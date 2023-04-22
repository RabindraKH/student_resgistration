package com.studentRegistration.model;

import java.sql.ResultSet;

public interface DAOServices {
	public void connectDB();
	public boolean verifyLogin(String email,String password);
	public void addRegistration(String name,String email, String studentClass,int age);
	public ResultSet getStudent();
	public void deleteStudent(String email);
	public void updateStudent(String name,String email);

}
