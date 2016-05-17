package projectSR03.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManageUsersServlet extends HttpServlet {

	private static final String M_USER = "/MemberPages/AdminPages/manageUsers.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( M_USER ).forward( req, resp );
	}
}
