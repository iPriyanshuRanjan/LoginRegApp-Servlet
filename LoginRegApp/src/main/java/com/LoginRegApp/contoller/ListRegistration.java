package com.LoginRegApp.contoller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.LoginRegApp.model.DAOService;
import com.LoginRegApp.model.DAOServiceImpl;

@WebServlet("/listLeads")
public class ListRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListRegistration() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("email") != null) {

			DAOService service = new DAOServiceImpl();
			service.connectDB();
			ResultSet registration = service.listAll();
			request.setAttribute("registration", registration);

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/listReg.jsp");
			rd.forward(request, response);
		} else {
			
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
