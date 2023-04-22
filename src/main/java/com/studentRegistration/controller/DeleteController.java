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

@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		String email=request.getParameter("email");
		DAOServices services=new DAOServicesImpl(); 
		services.connectDB();
		
		services.deleteStudent(email);
		ResultSet result= services.getStudent();
		request.setAttribute("result", result);
		RequestDispatcher rd= request.getRequestDispatcher("WEB-INF/views/studentList.jsp");
		rd.forward(request, response);
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
