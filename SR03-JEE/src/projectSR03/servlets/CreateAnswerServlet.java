package projectSR03.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projectSR03.DAO.AnswerDAO;
import projectSR03.DAO.QuestionnaireDAO;
import projectSR03.beans.CompoQuestionBean;
import projectSR03.forms.CreateAnswerForm;
import projectSR03.forms.CreateQuestionForm;

@WebServlet("/MemberPages/AdminPages/createAnswer")
public class CreateAnswerServlet extends HttpServlet {

	public static final String M_ANSWER = "/MemberPages/AdminPages/manageAnswer";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CreateAnswerForm form = new CreateAnswerForm();
		CompoQuestionBean bean = form.createQuestion(req);
		if(form.getErrors().isEmpty()) {
			int qId = Integer.parseInt(bean.getQuestionId());
			AnswerDAO.addAnswer(bean);
			resp.sendRedirect(req.getContextPath() + M_ANSWER + "?id="+qId);
		} else {
			req.setAttribute("form", form);
			this.getServletContext().getRequestDispatcher(M_ANSWER).forward( req, resp);
		}
	}	
}
