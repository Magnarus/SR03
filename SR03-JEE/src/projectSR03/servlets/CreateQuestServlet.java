package projectSR03.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projectSR03.DAO.QuestionnaireDAO;
import projectSR03.beans.QuestionnaireBean;
import projectSR03.forms.CreateQuestForm;

@WebServlet("/MemberPages/AdminPages/createQuest")
public class CreateQuestServlet extends HttpServlet {
	
	public static final String M_QUEST = "/MemberPages/AdminPages/manageQuest";
	public static final String C_QUEST = "/MemberPages/AdminPages/createQuest";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( C_QUEST ).forward( req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CreateQuestForm createBean = new CreateQuestForm();
		QuestionnaireBean bean = createBean.createQuestionnaire(req);
		if(createBean.getErrors().isEmpty()) {
			QuestionnaireDAO.addQuestionnaire(bean);
			resp.sendRedirect( req.getContextPath() + M_QUEST );
		} else {
			req.setAttribute( "form", createBean );
        	this.getServletContext().getRequestDispatcher(C_QUEST).forward( req, resp );
		}
	}

}
