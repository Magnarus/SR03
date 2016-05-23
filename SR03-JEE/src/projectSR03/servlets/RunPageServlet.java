package projectSR03.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projectSR03.DAO.ListAnswerDAO;
import projectSR03.DAO.QuestionnaireDAO;
import projectSR03.DAO.RunDAO;
import projectSR03.DAO.UserAnswerDAO;
import projectSR03.beans.QuestionBean;
import projectSR03.beans.QuestionnaireBean;

@WebServlet("/MemberPages/StagiairePages/runPage")
public class RunPageServlet extends HttpServlet {
	private static final String RUN_PAGE = "/MemberPages/StagiairePages/runPage.jsp";
	private static final String HOME_STAGIAIRE = "/MemberPages/StagiairePages/homeStagiaire.jsp";
	
	private Date runBegin; // Date de début de la question courante
	private int idRun = -1; // ID de la BDD pour le Run courant
	private int idQuest; // ID du questionnaire choisit
	private int currentQuestion = 1; // Ordre pour savoir quelle question afficher ensuite
	private QuestionnaireBean questionnaire;
	private QuestionBean current;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		current = questionnaire.getQuestion(currentQuestion);
		req.setAttribute("questionInformations", current);
		req.setAttribute("idRun", idRun);
		req.setAttribute("questId", idQuest);
		this.getServletContext().getRequestDispatcher( RUN_PAGE ).forward( req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String answer = (String) req.getParameter("question");

		
		if(answer != null && idRun != -1) // En train de parcourir & réponse donnée
		{
			int idAnswer = current.findIdAnswer(answer);
			// Insérer la réponse en BDD.
			// Créer l'entrée dans UserAnswer 
			int key = UserAnswerDAO.createEntry(idAnswer, current.getId());
			// Ajouter cette entrée dans ListAnswer
			ListAnswerDAO.createEntry(key, idRun);
			// Mettre à jour le run
			if(current.getRightAnswer() == idAnswer) {
				RunDAO.UpdateScore(idRun, runBegin);
			}
			
			currentQuestion++;
		}
		
		// Premier passage sur la page de Parcours
		if(req.getAttribute("idRun") != null &&
				(int) req.getAttribute("idRun") != idRun && 
				req.getParameter("idRun") == null) { 
			
			idRun = (int) req.getAttribute("idRun");
			idQuest = Integer.parseInt((String) req.getAttribute("questId"));
			runBegin = new Date();
			questionnaire = QuestionnaireDAO.getQuestionnaire(idQuest);
			currentQuestion = 1;
			resp.sendRedirect(req.getContextPath() + "/MemberPages/StagiairePages/runPage");
		} else {
		
			current = questionnaire.getQuestion(currentQuestion);
			
			if(current == null) { // Fin du questionnaire 
				System.out.println("Fin du questionnaire");
				idRun = -1;
				resp.sendRedirect(req.getContextPath() + HOME_STAGIAIRE);
			} else {
				req.setAttribute("questionInformations", current);
				req.setAttribute("idRun", idRun);
				req.setAttribute("questId", idQuest);
				this.getServletContext().getRequestDispatcher( RUN_PAGE ).forward( req, resp);
			}		
		}

	}
	

}
