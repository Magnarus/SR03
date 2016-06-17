package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AnnuaireProxy;
import beans.CategorieBean;

@WebServlet("/manageCategories")
public class ManageCategorieServlet extends HttpServlet {
	// Nom de la page qu'elle référence
	private static final String CATEGORIE_MANAGE = "/manageCategories.jsp";

	// Liste qui contient les annonces au premier appel de la page
	private ArrayList<CategorieBean> categorieList;
	private AnnuaireProxy proxy = new AnnuaireProxy();
	
	/**
	 * Fonction appelée au chargement de la page, récupère les données et les transmet à la JSP
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		categorieList = new ArrayList<CategorieBean>(Arrays.asList(proxy.getCategories())); // Récupération des informations
		// Ajout des attributs à l'objet request et redirection
		req.setAttribute("categorieList", categorieList);
		this.getServletContext().getRequestDispatcher(CATEGORIE_MANAGE).forward(req, resp);
	}
	/**
	 * Fonction appelée à la validation du formulaire, suppression de l'entrée dans la liste des annonces
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		System.out.println("Delete called " + id);
		
		proxy.deleteCategorie(id);
		
		for(CategorieBean b : categorieList) {
			if(b.getId() == id) categorieList.remove(b);
		}
		req.setAttribute("categorieList", categorieList);
		this.getServletContext().getRequestDispatcher(CATEGORIE_MANAGE).forward(req, resp);
	}
}
