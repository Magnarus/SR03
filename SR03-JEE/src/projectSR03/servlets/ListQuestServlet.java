package projectSR03.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projectSR03.DAO.QuestionnaireDAO;
import projectSR03.DAO.RunDAO;
import projectSR03.beans.QuestionnaireBean;
import projectSR03.beans.UserBean;

@WebServlet("/MemberPages/StagiairePages/listQuest")
public class ListQuestServlet extends HttpServlet {
	private static final String QUEST_LIST = "/MemberPages/StagiairePages/listQuest.jsp";
	private static final String RUN_PAGE = "/MemberPages/StagiairePages/runPage";

	private ArrayList<QuestionnaireBean> questionnaires;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		questionnaires =  QuestionnaireDAO.getQuestionnairesActif();
		req.setAttribute("listQuest", questionnaires);
		this.getServletContext().getRequestDispatcher( QUEST_LIST ).forward( req, resp );
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String filter = req.getParameter("filter");
		if(filter != null) {
			filterData(filter);
			req.setAttribute("listQuest", questionnaires);
			this.getServletContext().getRequestDispatcher( QUEST_LIST ).forward( req, resp );
		} else {
			//  Implémenter le run
			String questId = (String) req.getParameter("id");
			UserBean u = (UserBean) req.getSession().getAttribute("sessionUser");
			// Création du run en base
			int idRun = RunDAO.createRun(questId, u.getId());
			
			// Redirection
			req.setAttribute("idRun", idRun);
			req.setAttribute("questId", questId);
			
			this.getServletContext().getRequestDispatcher( RUN_PAGE ).forward( req, resp );
		}
	}
	
	public void filterData(String filter) {
		questionnaires = QuestionnaireDAO.getQuestionnairesActif(filter);
	}
	
	
	
}
