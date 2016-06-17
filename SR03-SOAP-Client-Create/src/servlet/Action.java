package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Home")
public class Action extends HttpServlet {

	private static final String ACTION_PAGE = "/Home.jsp";
	private static final String ADD_PAGE = "/AddAnn.jsp";
	private static final String MOD_PAGE = "/manageAnnonces";
	private static final String DEL_PAGE = "/DelAnn.jsp";

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( ACTION_PAGE ).forward( req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String answer = req.getParameter("action");
		System.out.println(answer);
		if(answer.equals("add")) {
			this.getServletContext().getRequestDispatcher( ADD_PAGE ).forward( req, resp);
		}
		if(answer.equals("mod")) {
			this.getServletContext().getRequestDispatcher( MOD_PAGE ).forward( req, resp);
		}
		if(answer.equals("del")) {
			this.getServletContext().getRequestDispatcher( DEL_PAGE ).forward( req, resp);
		}
	}
}
