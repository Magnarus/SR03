package projectSR03.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projectSR03.DAO.AnswerDAO;
import projectSR03.DAO.QuestionDAO;
import projectSR03.beans.AnswerBean;

@WebServlet("/MemberPages/AdminPages/manageAnswer")
public class ManageAnswerServlet extends HttpServlet {

	public static final String D_ANSWER = "/MemberPages/AdminPages/manageAnswer.jsp";
	private List<AnswerBean> answers;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String right = req.getParameter("right");
		String state = req.getParameter("state");
		String answerId = req.getParameter("aId");
		String questionId = req.getParameter("id");
		int rightAnswer = -1;
		if(right != null && questionId != null) {
			QuestionDAO.setRightAnswer(questionId, right);
		} else if (state != null && answerId != null) {
			AnswerDAO.setIsActif(answerId, state);
		}
		if (questionId != null) {
			answers = QuestionDAO.getAnswers(Integer.parseInt(questionId));
			rightAnswer = QuestionDAO.getRightAnswer(questionId);
		}
		req.setAttribute("answers", answers);
		req.setAttribute("rightAnswer", Integer.toString(rightAnswer));
		this.getServletContext().getRequestDispatcher( D_ANSWER ).forward( req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("a_id");
		for(AnswerBean a : answers) {
			if(a.getId() == Integer.parseInt(id)) {
				AnswerDAO.deleteAnswer(a);
				answers.remove(a);
				break;
			}
		}
		req.setAttribute("answers", answers);
		this.getServletContext().getRequestDispatcher(D_ANSWER).forward( req, resp );
	}

}
