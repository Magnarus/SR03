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

@WebServlet("/MemberPages/AdminPages/detailQuest")
public class DetailQuestServlet extends HttpServlet {

	public static final String D_QUEST = "/MemberPages/AdminPages/detailQuest.jsp";
	private ArrayList<QuestionBean> questions;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("questionId");
		String state = req.getParameter("state");
		if(id != null && state != null && !id.isEmpty() && !state.isEmpty()) {
			QuestionDAO.setIsActif(id, state);
		}
		questions = QuestionnaireDAO.getQuestions(Integer.parseInt(req.getParameter("id")));
		req.setAttribute("questions", questions);
		req.setAttribute("size", questions.size());
		this.getServletContext().getRequestDispatcher( D_QUEST ).forward( req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("q_id");
		if(req.getParameter("supprimer") != null && id !=null) {
			removeQuestion(id);
		}
		if(req.getParameter("monter") != null && id != null) {
			upOrder(id);
		}
		if(req.getParameter("descendre") != null && id != null) {
			downOrder(id);
		}
		questions = QuestionnaireDAO.getQuestions(Integer.parseInt(req.getParameter("id")));
		req.setAttribute("questions", questions);
		req.setAttribute("size", questions.size());
		this.getServletContext().getRequestDispatcher(D_QUEST).forward( req, resp );
	}
	
	private void removeQuestion(String id) {
		for(QuestionBean question : questions) {
			if(question.getId() == Integer.parseInt(id)) {
				QuestionDAO.deleteAnswers(question);
				QuestionDAO.deleteQuestion(question);
				questions.remove(questions.indexOf(question));
				break;
			}
		}
	}
	
	private void upOrder(String id) {
		QuestionDAO.upQuestionOrder(id);
	}
	
	private void downOrder(String id) {
		QuestionDAO.downQuestionOrder(id);
	}
}
