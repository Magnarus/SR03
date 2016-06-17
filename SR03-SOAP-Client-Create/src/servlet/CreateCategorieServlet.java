package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AnnuaireProxy;

@WebServlet("/createCategorie")
public class CreateCategorieServlet extends HttpServlet{

	private static final String CATEGORIE_CREATE = "/createCategorie.jsp";
	private static final String CATEGORIE_MANAGE = "/manageCategories";
	private AnnuaireProxy proxy = new AnnuaireProxy();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher(CATEGORIE_CREATE).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String categ = req.getParameter("categ");
		proxy.addCategorie(categ);
		resp.sendRedirect(req.getContextPath() + CATEGORIE_MANAGE);
	}
	
	

}
