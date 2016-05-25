package projectSR03.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projectSR03.DAO.QuestionDAO;
import projectSR03.DAO.QuestionnaireDAO;
import projectSR03.DAO.UserDAO;
import projectSR03.beans.QuestionBean;
import projectSR03.beans.QuestionnaireBean;
import projectSR03.beans.UserBean;

@WebServlet("/MemberPages/AdminPages/manageUsers")
public class ManageUsersServlet extends HttpServlet {

	private static final String M_USER = "/MemberPages/AdminPages/manageUsers.jsp";
	private ArrayList<UserBean> users ;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		users = new ArrayList<UserBean>();
		users = UserDAO.getUsers();
		req.setAttribute("listUsers", users);
		this.getServletContext().getRequestDispatcher( M_USER ).forward( req, resp );
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("q_id");
		if(id != null) {
			UserDAO.deleteUser(id);
			users.clear();
			users = UserDAO.getUsers();
		}
		
		// Renvoi des données pour reload de la page ? 
		req.setAttribute("listUsers", users);
		this.getServletContext().getRequestDispatcher( M_USER ).forward( req, resp );
	}
}
