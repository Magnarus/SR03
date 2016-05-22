package projectSR03.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import projectSR03.DAO.RunDAO;
import projectSR03.beans.RunBean;
import projectSR03.beans.UserBean;

@WebServlet("/MemberPages/StagiairePages/listRun")
public class ListRunServlet extends HttpServlet {
	private static final String RUN_LIST = "/MemberPages/StagiairePages/listRun.jsp";

	private ArrayList<RunBean> run;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession currentSession = req.getSession();
		UserBean user = (UserBean) currentSession.getAttribute("sessionUser");
		
		run = RunDAO.getUserRuns(user.getId());
		req.setAttribute("listRun", run);
		this.getServletContext().getRequestDispatcher( RUN_LIST ).forward( req, resp );		
	}

}
