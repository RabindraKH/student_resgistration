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

@WebServlet("/update")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		
		request.setAttribute("name", name);
		request.setAttribute("email",email);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/update.jsp");
		rd.forward(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		DAOServices services = new DAOServicesImpl();
		services.connectDB();
		
		services.updateStudent(name,email);
		ResultSet result= services.getStudent();
		request.setAttribute("result", result);
		RequestDispatcher rd= request.getRequestDispatcher("WEB-INF/views/studentList.jsp");
		rd.forward(request, response);
		
		
	}

}
