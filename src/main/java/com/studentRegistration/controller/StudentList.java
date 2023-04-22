package com.studentRegistration.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

import com.studentRegistration.model.DAOServices;
import com.studentRegistration.model.DAOServicesImpl;

@WebServlet("/studentList")
public class StudentList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public StudentList() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		DAOServices services= new DAOServicesImpl();
		services.connectDB();
		ResultSet result= services.getStudent();
	
		request.setAttribute("result", result);
		RequestDispatcher rd= request.getRequestDispatcher("WEB-INF/views/studentList.jsp");
		rd.forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
