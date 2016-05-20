package projectSR03.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projectSR03.DAO.UserDAO;
import projectSR03.beans.UserBean;

public class ManageUsersServlet extends HttpServlet {

	private static final String M_USER = "/MemberPages/AdminPages/manageUsers.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ArrayList<UserBean> users = new ArrayList<UserBean>();
		users = UserDAO.getUsers();
		String test = "oookkk";
		req.setAttribute("test", test);
		req.setAttribute("listUsers", users);
		this.getServletContext().getRequestDispatcher( M_USER ).forward( req, resp );
	}
}
