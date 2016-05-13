package projectSR03.beans;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import projectSR03.DAO.LoginDAO;
import projectSR03.DAO.MysqljdbcDAO;
import projectSR03.beans.UserBean;

public final class LoginBean {
	
    private static final String EMAIL  = "email";
    private static final String PASSWORD   = "password";

    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public UserBean connectUser( HttpServletRequest request ) {
        /* Récupération des champs du formulaire */
        String email = getValeurChamp( request, EMAIL );
        String password = getValeurChamp( request, PASSWORD );

        UserBean user = new UserBean();

        /* Validation du champ email. */
        try {
            validationLogin( email, password );
        } 
        catch ( Exception e ) {
            setErreur( EMAIL, e.getMessage() );
        }
        
        user.setEmail( email );
        user.setPassword( password );
        
        
        try {
			user.setAdmin(isAdmin(email));
		} 
        catch (Exception e) {
            setErreur( EMAIL, e.getMessage() );
		}
        
        /* Initialisation du résultat global de la validation. */
        if ( erreurs.isEmpty() ) {
            resultat = "Succès de la connexion.";
        } 
        else {
            resultat = "Échec de la connexion.";
        }

        return user;
    }

    /**
     * Valide l'adresse email saisie.
     */
    private void validationLogin( String email, String password ) throws Exception {
    	
    	String u_email = LoginDAO.getLogin(email);
    	String u_password = LoginDAO.getPassword(email);
        if ( u_email == null ) {
        	//TODO Appel à la couche DAO pour vérifier si l'email est dansla liste
            throw new Exception( "Champ identifiant vide" );         
        }
        else {
        	if (! u_password.equals(password)) {
        		throw new Exception("Mot de passe incorrect");
        	}
        }
        
    }
    
    private boolean isAdmin( String email ) throws Exception {
    	
    	return LoginDAO.isAdmin(email);
    }


    /**
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /**
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}