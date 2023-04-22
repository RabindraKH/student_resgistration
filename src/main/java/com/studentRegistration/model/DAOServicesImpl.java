package com.studentRegistration.model;
import java .sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class DAOServicesImpl implements DAOServices {

	private Connection con;
	private Statement stmt;
	@Override
	public void connectDB() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/student_reg","root","test");
			stmt=con.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
		}
         
	}

	@Override
	public boolean verifyLogin(String email, String password) {
    try {
		ResultSet result=stmt.executeQuery("select * from login where email='"+email+"' and password='"+password+"'");
		return result.next();	
    }catch(Exception e) {
    	e.printStackTrace();
    	return false;
    }
		
	}

	@Override
	public void addRegistration(String name,String email, String studentClass,int age) {
		try{
			stmt.executeUpdate("insert into reg_data values('"+name+"','"+email+"','"+studentClass+"',"+age+")");
		}catch(Exception e) {
		e.printStackTrace();
		}
	}

	@Override
	public ResultSet getStudent() {

		try {
		ResultSet result=stmt.executeQuery("select * from reg_data");
		return result;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public void deleteStudent(String email) {
try {
		stmt.executeUpdate("delete from reg_data where email='"+email+"'");
		
}catch(Exception e) {
	e.printStackTrace();
}
		
	}

	@Override
	public void updateStudent(String name, String email) {

		
		try {
		stmt.executeUpdate("update reg_data set email='"+email+"' where name='"+name+"'");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
