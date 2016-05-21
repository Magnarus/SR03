package projectSR03.servlets;

import java.io.IOException;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projectSR03.beans.CreateQuestBean;

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
		CreateQuestBean createBean = new CreateQuestBean();
		createBean.createQuestionnaire(req);
		if(createBean.getErrors().size() > 0) {
			//TODO FORWARD ERRORS
			for(Entry entry : createBean.getErrors().entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		} else {
			resp.sendRedirect( req.getContextPath() + M_QUEST );
		}
	}

}
