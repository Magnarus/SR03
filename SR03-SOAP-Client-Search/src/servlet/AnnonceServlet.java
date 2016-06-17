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

@WebServlet("/afficheAnnonce")
public class AnnonceServlet extends HttpServlet {

	AnnuaireProxy proxy = new AnnuaireProxy();
	List<AnnonceBean> annonces;
	List<CategorieBean> categories;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		annonces = Arrays.asList(proxy.getAnnonces());
		categories = Arrays.asList(proxy.getCategories());
		System.out.println(categories.size());
		req.setAttribute("annonceList", annonces);
		req.setAttribute("categorieList", categories);
		this.getServletContext().getRequestDispatcher("/AfficheAnnonce.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String categ = req.getParameter("categs");
		int id = Integer.parseInt(categ);
		List<AnnonceBean> annonces = Arrays.asList(proxy.getAnnoncesWithIdCateg(id));
		req.setAttribute("annonceList", annonces);
		this.getServletContext().getRequestDispatcher("/AfficheAnnonce.jsp").forward( req, resp );
		super.doPost(req, resp);
	}
	
	

}
