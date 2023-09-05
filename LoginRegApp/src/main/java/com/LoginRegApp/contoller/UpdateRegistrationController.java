package com.LoginRegApp.contoller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LoginRegApp.model.DAOService;
import com.LoginRegApp.model.DAOServiceImpl;


@WebServlet("/update")
public class UpdateRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateRegistrationController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		
		System.out.println(email);
		System.out.println(mobile);
		
		request.setAttribute("email", email);
		request.setAttribute("mobile", mobile);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/UpdateReg.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
	
		DAOService service=new DAOServiceImpl();
		service.connectDB();
		
		service.updateRegistration(mobile,email);
		
		ResultSet registration = service.listAll();
		
		request.setAttribute("registration", registration);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/listReg.jsp");
		rd.forward(request, response);
	}

}
