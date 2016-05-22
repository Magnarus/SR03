package projectSR03.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projectSR03.DAO.QuestionDAO;
import projectSR03.DAO.QuestionnaireDAO;
import projectSR03.beans.CompoQuestionnaireBean;
import projectSR03.forms.CreateQuestionForm;

@WebServlet("/MemberPages/AdminPages/createQuestion")
public class CreateQuestionServlet extends HttpServlet {

	public static final String D_QUEST = "/MemberPages/AdminPages/detailQuest";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CreateQuestionForm form = new CreateQuestionForm();
		CompoQuestionnaireBean bean = form.createQuestion(req);
		if(form.getErrors().isEmpty()) {
			int qId = Integer.parseInt(bean.getQuestionnaireId());
			QuestionDAO.addQuestion(bean);
			resp.sendRedirect(req.getContextPath() + D_QUEST + "?id="+qId);
		} else {
			req.setAttribute("form", form);
			this.getServletContext().getRequestDispatcher(D_QUEST).forward( req, resp);
		}
	}	
}
