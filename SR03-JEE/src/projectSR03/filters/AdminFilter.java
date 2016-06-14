package projectSR03.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import projectSR03.beans.UserBean;

public class AdminFilter implements Filter {
	
    public static final String H_STAGIAIRE = "/MemberPages/StagiairePages/homeStagiaire";
    public static final String SESSION = "sessionUser";
    
    public void init( FilterConfig config ) throws ServletException {
    }

    public void doFilter( ServletRequest req, ServletResponse resp, FilterChain chain ) throws IOException,
            ServletException {
    	
    	/* Cast des objets request et response */
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();

       // On vérifie si l'user est admin

        if ( !((UserBean) session.getAttribute( SESSION )).isAdmin() ) {
            /* Redirection vers la page stagiaire */
            response.sendRedirect( request.getContextPath() + H_STAGIAIRE );
        } else {
            /* Affichage de la page restreinte */
            chain.doFilter( request, response );
        }
    }

    public void destroy() {
    }
}