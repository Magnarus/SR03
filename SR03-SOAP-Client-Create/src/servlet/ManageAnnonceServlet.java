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
	// Nom de la page qu'elle r�f�rence
	private static final String ANNONCE_MANAGE = "/manageAnnonces.jsp";

	// Liste qui contient les annonces au premier appel de la page
	private ArrayList<AnnonceBean> annonceList;
	private AnnuaireProxy proxy = new AnnuaireProxy();
	
	/**
	 * Fonction appel�e au chargement de la page, r�cup�re les donn�es et les transmet � la JSP
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		annonceList = new ArrayList<AnnonceBean>(Arrays.asList(proxy.getAnnonces())); // R�cup�ration des informations
		// Ajout des attributs � l'objet request et redirection
		req.setAttribute("annonceList", annonceList);
		this.getServletContext().getRequestDispatcher(ANNONCE_MANAGE).forward(req, resp);
	}
	/**
	 * Fonction appel�e � la validation du formulaire, suppression de l'entr�e dans la liste des annonces
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		//System.out.println("Delete called");
		proxy.deleteAnnonce(id);
		
		for(AnnonceBean b : annonceList) {
			if(b.getId() == id) annonceList.remove(b);
		}
		req.setAttribute("annonceList", annonceList);
		this.getServletContext().getRequestDispatcher(ANNONCE_MANAGE).forward(req, resp);
	}
}
