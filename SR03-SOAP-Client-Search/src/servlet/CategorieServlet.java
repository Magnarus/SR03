package servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AnnuaireProxy;
import beans.AnnonceBean;
import beans.CategorieBean;

@WebServlet("/afficheCategorie")
public class CategorieServlet extends HttpServlet {

	AnnuaireProxy proxy = new AnnuaireProxy();
	List<CategorieBean> categories;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		categories = Arrays.asList(proxy.getCategories());
		req.setAttribute("categorieList", categories);
		this.getServletContext().getRequestDispatcher("/AfficheCategorie.jsp").forward(req, resp);
	}
}
