package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AnnuaireProxy;
import beans.AnnonceBean;

@WebServlet("/manageAnnonces")
public class ManageAnnonceServlet extends HttpServlet {
	private static final String QUEST_MANAGE = "/manageAnnonces.jsp";

	private List<AnnonceBean> annonceList;
	private AnnuaireProxy proxy = new AnnuaireProxy();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		annonceList = new ArrayList<AnnonceBean>();
		annonceList =  (List<AnnonceBean>) Arrays.asList(proxy.getAnnonces());
		req.setAttribute("annonceList", annonceList);
		this.getServletContext().getRequestDispatcher(QUEST_MANAGE).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
