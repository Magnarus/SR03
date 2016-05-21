package projectSR03.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projectSR03.DAO.QuestionnaireDAO;

@WebServlet("/MemberPages/AdminPages/manageQuest")
public class ManageQuestServlet extends HttpServlet {
	private static final String QUEST_MANAGE = "/WEB-INF/manageQuest.jsp";
	private static final String LOGIN = "/login.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("listQuest", QuestionnaireDAO.getQuestionnaires());
		this.getServletContext().getRequestDispatcher( QUEST_MANAGE ).forward( req, resp );
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( QUEST_MANAGE ).forward( req, resp );
	}
}
