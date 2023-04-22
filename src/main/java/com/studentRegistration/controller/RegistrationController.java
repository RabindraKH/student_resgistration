package com.studentRegistration.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.studentRegistration.model.DAOServices;
import com.studentRegistration.model.DAOServicesImpl;

@WebServlet("/registration")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public RegistrationController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd =request.getRequestDispatcher("WEB-INF/views/registration.jsp");
		rd.include(request, response);
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String studentClass=request.getParameter("class");
		int age=Integer.parseInt(request.getParameter("age"));
		
		DAOServices services= new DAOServicesImpl();
		services.connectDB();
		
		services.addRegistration(name,email,studentClass,age);
	 
		request.setAttribute("msg", "Registration successful");
		RequestDispatcher rd =request.getRequestDispatcher("WEB-INF/views/registration.jsp");
		rd.include(request, response);
	}

}
