package projectSR03.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MemberPages/AdminPages/homeAdmin")
public class HomeAdminServlet extends HttpServlet {

	private static final String H_ADMIN = "/MemberPages/AdminPages/homeAdmin.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( H_ADMIN ).forward( req, resp );
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( H_ADMIN ).forward( req, resp );
	}
}
