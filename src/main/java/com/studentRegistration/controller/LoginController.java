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

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String email=request.getParameter("email");
	String password=request.getParameter("password");
	
	DAOServices services= new DAOServicesImpl();
	services.connectDB();
	
	Boolean bool=services.verifyLogin(email,password);
	if(bool==true) {
		RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/views/registration.jsp");
		rd.forward(request, response);
	}else {
		request.setAttribute("error","Invalid username/password");
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.include(request,response);
		
	}
	
	}

}
