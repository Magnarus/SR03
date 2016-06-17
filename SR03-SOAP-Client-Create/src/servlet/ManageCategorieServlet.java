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
	// Nom de la page qu'elle r�f�rence
	private static final String CATEGORIE_MANAGE = "/manageCategories.jsp";

	// Liste qui contient les annonces au premier appel de la page
	private ArrayList<CategorieBean> categorieList;
	private AnnuaireProxy proxy = new AnnuaireProxy();
	
	/**
	 * Fonction appel�e au chargement de la page, r�cup�re les donn�es et les transmet � la JSP
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		categorieList = new ArrayList<CategorieBean>(Arrays.asList(proxy.getCategories())); // R�cup�ration des informations
		// Ajout des attributs � l'objet request et redirection
		req.setAttribute("categorieList", categorieList);
		this.getServletContext().getRequestDispatcher(CATEGORIE_MANAGE).forward(req, resp);
	}
	/**
	 * Fonction appel�e � la validation du formulaire, suppression de l'entr�e dans la liste des annonces
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
