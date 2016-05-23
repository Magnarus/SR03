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
import projectSR03.beans.QuestionBean;
import projectSR03.beans.QuestionnaireBean;

@WebServlet("/MemberPages/AdminPages/manageQuest")
public class ManageQuestServlet extends HttpServlet {
	private static final String QUEST_MANAGE = "/MemberPages/AdminPages/manageQuest.jsp";

	private ArrayList<QuestionnaireBean> questionnaires;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String state = req.getParameter("state");
		if(id != null && state != null && !id.isEmpty() && !state.isEmpty()) {
			QuestionnaireDAO.setIsActif(id, state);
		}
		questionnaires =  QuestionnaireDAO.getQuestionnaires();
		req.setAttribute("listQuest", questionnaires);
		this.getServletContext().getRequestDispatcher( QUEST_MANAGE ).forward( req, resp );
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		ArrayList<QuestionBean> q = null;
		
		System.out.println("Le doPost est bien appel�!" + id);
		
		// Delete des r�ponses car non li� par cl� primaire directe
		// N�cessite de trouver le questionnaire qu'on veut delete
		for(QuestionnaireBean b : questionnaires) {
			if(String.valueOf(b.getId()).equals(id)) {
				q = b.getQuestions();
				questionnaires.remove(b);
				break;
			}
		}
		if(q == null) { // C'est possiblement la merde
			System.out.println("Probl�me");
		} else {
			for(QuestionBean question : q)
			{
				QuestionDAO.deleteAnswers(question);
				QuestionDAO.deleteQuestion(question);
			}
			
			// Puis delete du questionnaire 
			QuestionnaireDAO.deleteQuestionnaire(id);
		}
		// Renvoi des donn�es pour reload de la page ? 
		req.setAttribute("listQuest", questionnaires);
		this.getServletContext().getRequestDispatcher( QUEST_MANAGE ).forward( req, resp );
	}
}
