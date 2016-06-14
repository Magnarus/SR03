package projectSR03.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import projectSR03.DAO.UserDAO;
import projectSR03.beans.UserBean;
import projectSR03.forms.LoginForm;



@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	public static final String SESSION = "sessionUser";
	
	public static final String LOGIN = "/login.jsp";
	
	public static final String RELOG = "/login";

	public static final String H_ADMIN = "/MemberPages/AdminPages/homeAdmin";
	public static final String H_STAGIAIRE = "/homeStagiaire";

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher( LOGIN ).forward( req, resp );
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		LoginForm login = new LoginForm();
		
		UserBean user = login.connectUser(req);
		
        HttpSession session = req.getSession();
		
		if (login.getErrors().isEmpty()){
			user = UserDAO.getUser(req.getParameter("email"));
			session.setAttribute(SESSION, user);
		}
		else {
            session.setAttribute( SESSION, null );
		}
		
		resp.sendRedirect( req.getContextPath() + H_ADMIN );
		
	}

	
	
}
	