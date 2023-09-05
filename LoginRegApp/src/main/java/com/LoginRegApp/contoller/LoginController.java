package com.LoginRegApp.contoller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.LoginRegApp.model.DAOService;
import com.LoginRegApp.model.DAOServiceImpl;


@WebServlet("/verifyLogin")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			//Class up casting
			DAOService service= new DAOServiceImpl();
			service.connectDB();
			
			boolean status = service.verifyCredentials(email, password);
			if(status==true) {
				HttpSession session = request.getSession(true);
				session.setAttribute("email", email);
				
				//Session timeout
				session.setMaxInactiveInterval(10);
				
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Welcome.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("error", "Invalid Credentials.");
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("error", "Session timeout. Login again");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
			
		}
	}

}
