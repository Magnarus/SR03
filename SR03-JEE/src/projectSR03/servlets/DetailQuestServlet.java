package projectSR03.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projectSR03.DAO.QuestionnaireDAO;
import projectSR03.beans.QuestionBean;

@WebServlet("/MemberPages/AdminPages/detailQuest")
public class DetailQuestServlet extends HttpServlet {

	public static final String D_QUEST = "/MemberPages/AdminPages/detailQuest.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<QuestionBean> questions = QuestionnaireDAO.getQuestions(Integer.parseInt(req.getParameter("id")));
		System.out.println(questions.size());
		req.setAttribute("questions", questions);
		this.getServletContext().getRequestDispatcher( D_QUEST ).forward( req, resp);
	}
	
}
