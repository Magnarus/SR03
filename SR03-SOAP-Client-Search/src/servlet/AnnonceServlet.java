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

@WebServlet("/afficheAnnonce")
public class AnnonceServlet extends HttpServlet {

	AnnuaireProxy proxy = new AnnuaireProxy();
	List<AnnonceBean> annonces;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		annonces = Arrays.asList(proxy.getAnnonces());
		req.setAttribute("annonceList", annonces);
		this.getServletContext().getRequestDispatcher("/AfficheAnnonce.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String categ = req.getParameter("filter");
		List<AnnonceBean> annonces = Arrays.asList(proxy.getAnnonces(categ));
		req.setAttribute("annonceList", annonces);
		this.getServletContext().getRequestDispatcher("/AfficheAnnonce.jsp").forward( req, resp );
		super.doPost(req, resp);
	}
	
	

}
