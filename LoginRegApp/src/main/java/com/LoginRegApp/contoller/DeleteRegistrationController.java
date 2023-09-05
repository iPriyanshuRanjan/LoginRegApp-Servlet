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


@WebServlet("/delete")
public class DeleteRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteRegistrationController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
//		System.out.println(email);
		DAOService service=new DAOServiceImpl();
		service.connectDB();
		service.deleteReg(email);
		ResultSet registration=service.listAll();
		request.setAttribute("registration", registration);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/listReg.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
