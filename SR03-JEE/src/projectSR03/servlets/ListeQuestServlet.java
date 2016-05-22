package projectSR03.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projectSR03.DAO.QuestionnaireDAO;
import projectSR03.beans.QuestionnaireBean;

@WebServlet("/MemberPages/StagiairePages/listQuest")
public class ListeQuestServlet extends HttpServlet {
	private static final String QUEST_LIST = "/MemberPages/StagiairePages/listQuest.jsp";

	private ArrayList<QuestionnaireBean> questionnaires;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		questionnaires =  QuestionnaireDAO.getQuestionnairesActif();
		req.setAttribute("listQuest", questionnaires);
		this.getServletContext().getRequestDispatcher( QUEST_LIST ).forward( req, resp );
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO : Implémenter le run
		req.setAttribute("listQuest", questionnaires);
		this.getServletContext().getRequestDispatcher( QUEST_LIST ).forward( req, resp );
	}
	
	
	
}
