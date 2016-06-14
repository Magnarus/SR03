package projectSR03.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projectSR03.DAO.RunDAO;
import projectSR03.DAO.UserDAO;
import projectSR03.beans.RunBean;
import projectSR03.beans.UserBean;
import projectSR03.forms.CreateUserForm;
import projectSR03.forms.UpdateUserForm;

@WebServlet("/MemberPages/AdminPages/detailUser")
public class DetailUserServlet extends HttpServlet {
	
	public static final String D_USER = "/MemberPages/AdminPages/detailUser.jsp";
	public static final String  STAG_HOME = "/MemberPages/AdminPages/homeStagiaire";
	private static final String USER_MANAGE = "/MemberPages/AdminPages/manageUsers.jsp";
	private UserBean user; 
	private ArrayList<RunBean> runs;

	private static ArrayList<UserBean> users;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("userId");
		
		if(id != null) {
			user = UserDAO.getUserById(id);
			runs = RunDAO.getUserBestRuns(id);
			req.setAttribute("user", user);
			req.setAttribute("runs", runs);
			this.getServletContext().getRequestDispatcher( D_USER ).forward( req, resp);
		} else {
			resp.sendRedirect(req.getContextPath() + STAG_HOME);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String filter = req.getParameter("filter");
		if(filter != null) {
			filterData(filter);
		} else {
		
		/* Préparation de l'objet formulaire */
		UpdateUserForm form = new UpdateUserForm();

        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
        UserBean utilisateur = form.createUser(req);
        utilisateur.setId(user.getId());

	        /* Traitement finaux de redirection */
	        if(form.getErrors().isEmpty()) {
	        	UserDAO.UpdateUser(utilisateur);
	    		users = UserDAO.getUsers();
	    		req.setAttribute("listUsers", users);
	        	this.getServletContext().getRequestDispatcher(USER_MANAGE).forward( req, resp );
	        }
	        
		}

    	req.setAttribute("user", user);
		req.setAttribute("runs", runs);
		this.getServletContext().getRequestDispatcher( D_USER ).forward( req, resp);
	}
	
	public void filterData(String filter) {
		runs = RunDAO.getUserBestRuns(user.getId(), filter);
	}

}
