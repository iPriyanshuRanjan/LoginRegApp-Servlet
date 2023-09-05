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

@WebServlet("/saveReg")
public class SaveRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public SaveRegistration() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Welcome.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession session = request.getSession(false);
			//Session timeout
			session.setMaxInactiveInterval(10);
			if (session.getAttribute("email")!=null) {
				
			
			String name = request.getParameter("name");
			String city = request.getParameter("city");
			String mobile = request.getParameter("mobile");
			String email = request.getParameter("email");
			
			DAOService service= new DAOServiceImpl();
			service.connectDB();
			service.saveRegistration(name, city, mobile, email);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Welcome.jsp");
			rd.forward(request, response);
		}
			else {
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
