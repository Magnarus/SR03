package projectSR03.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projectSR03.DAO.UserDAO;
import projectSR03.beans.UserBean;
import projectSR03.forms.CreateUserForm;
import projectSR03.utils.MailManager;

@WebServlet("/MemberPages/AdminPages/CreateUser")
public class CreateUserServlet extends HttpServlet {
	private static final String USER_CREATE = "/MemberPages/AdminPages/createUser.jsp";
	private static final String USER_MANAGE = "/MemberPages/AdminPages/manageUsers.jsp";
	
	
	private static ArrayList<UserBean> users;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( USER_CREATE ).forward( req, resp );		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/* Préparation de l'objet formulaire */
        CreateUserForm form = new CreateUserForm();

        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
        UserBean utilisateur = form.createUser(req);

        /* Traitement finaux de redirection */
        if(form.getErrors().isEmpty()) {
        	UserDAO.createUser(utilisateur);
        	MailManager.SendMessage(utilisateur.getEmail(), "Coucou", "Coucou");
    		users = UserDAO.getUsers();
    		req.setAttribute("listUsers", users);
        	this.getServletContext().getRequestDispatcher(USER_MANAGE).forward( req, resp );
        } else {
        	req.setAttribute( "form", form );
            req.setAttribute( "utilisateur", utilisateur );
        	this.getServletContext().getRequestDispatcher(USER_CREATE).forward( req, resp );
        }
        
	}
}
