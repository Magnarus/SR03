package projectSR03.forms;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import projectSR03.DAO.LoginDAO;
import projectSR03.DAO.MysqljdbcDAO;
import projectSR03.beans.UserBean;

public final class LoginForm extends FormHelper {
	
    private static final String EMAIL  = "email";
    private static final String PASSWORD   = "password";

    private String resultat;

    public String getResultat() {
        return resultat;
    }

    public UserBean connectUser( HttpServletRequest request ) {
        /* Récupération des champs du formulaire */
        String email = getFieldValue( request, EMAIL );
        String password = getFieldValue( request, PASSWORD );

        UserBean user = new UserBean();

        /* Validation du champ email. */
        try {
            validationLogin( email, password );
        } 
        catch ( Exception e ) {
            setError( EMAIL, e.getMessage() );
        }
        
        user.setEmail( email );
        user.setPassword( password );
        
        
        try {
			user.setAdmin(isAdmin(email));
		} 
        catch (Exception e) {
            setError( EMAIL, e.getMessage() );
		}
        
        /* Initialisation du résultat global de la validation. */
        if ( errors.isEmpty() ) {
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
    
    private static boolean isAdmin( String email ) throws Exception {
    	return LoginDAO.isAdmin(email);
    }
    
}