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
	private static final String LOGIN = "/login.jsp";

	private ArrayList<QuestionnaireBean> questionnaires;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		questionnaires =  QuestionnaireDAO.getQuestionnaires();
		System.out.println("Appelé, liste : " + questionnaires);
		req.setAttribute("listQuest", questionnaires);
		this.getServletContext().getRequestDispatcher( QUEST_MANAGE ).forward( req, resp );
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		ArrayList<QuestionBean> q = null;
		
		System.out.println("Le doPost est bien appelé!" + id);
		
		// Delete des réponses car non lié par clé primaire directe
		// Nécessite de trouver le questionnaire qu'on veut delete
		for(QuestionnaireBean b : questionnaires) {
			if(String.valueOf(b.getId()).equals(id)) {
				q = b.getQuestions();
				questionnaires.remove(questionnaires.indexOf(b));
				System.out.println("J'ai trouvé le bon questionnaire!" + b);
				break;
			}
		}
		if(q == null) { // C'est possiblement la merde
			System.out.println("Problème");
		} else {
			for(QuestionBean question : q)
			{
				QuestionDAO.deleteAnswers(question);
				QuestionDAO.deleteQuestion(question);
			}
			
			// Puis delete du questionnaire 
			QuestionnaireDAO.deleteQuestionnaire(id);
		}
		// Renvoi des données pour reload de la page ? 
		req.setAttribute("listQuest", questionnaires);
		this.getServletContext().getRequestDispatcher( QUEST_MANAGE ).forward( req, resp );
	}
}
