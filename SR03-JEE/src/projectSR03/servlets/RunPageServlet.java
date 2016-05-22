package projectSR03.servlets;

import java.io.IOException;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projectSR03.DAO.QuestionnaireDAO;
import projectSR03.beans.QuestionBean;
import projectSR03.beans.QuestionnaireBean;

@WebServlet("/MemberPages/StagiairePages/runPage")
public class RunPageServlet extends HttpServlet {
	private static final String RUN_PAGE = "/MemberPages/StagiairePages/runPage.jsp";
	
	private Time currentQuestionBegin; // Date de début de la question courante
	private int idRun = -1; // ID de la BDD pour le Run courant
	private int idQuest; // ID du questionnaire choisit
	private int currentQuestion = 1; // Ordre pour savoir quelle question afficher ensuite
	private QuestionnaireBean questionnaire;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String answer = (String) req.getParameter("question");

		
		if(answer != null && idRun != -1) // En train de parcourir
		{
			System.out.println("Answer : " + answer);
			currentQuestion++;
		}
		
		
		if((int) req.getAttribute("idRun") != idRun ) { // Premier passage sur la page de Parcours
			idRun = (int) req.getAttribute("idRun");
			idQuest = Integer.parseInt((String) req.getAttribute("questId"));
			questionnaire = QuestionnaireDAO.getQuestionnaire(idQuest);
			currentQuestion = 1;
		}
		
		QuestionBean current = questionnaire.getQuestion(currentQuestion);
		
		if(current == null) { // Fin du questionnaire 
			System.out.println("Fin du questionnaire");
		} else {
			System.out.println(current.getAnswers().size());
			req.setAttribute("questionInformations", current);
			req.setAttribute("idRun", idRun);
			req.setAttribute("questId", idQuest);
			this.getServletContext().getRequestDispatcher( RUN_PAGE ).forward( req, resp);
		}		
	

	}
	

}
