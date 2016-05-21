package projectSR03.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import projectSR03.DAO.UserDAO;
import projectSR03.beans.UserBean;

public final class CreateUserForm {
	 private static final String CHAMP_EMAIL  = "email";
	 private static final String CHAMP_PASS   = "password";
     private static final String CHAMP_LASTNAME    = "lastname";
     private static final String CHAMP_FIRSTNAME    = "firstname";
     private static final String CHAMP_ADMIN    = "admin";
     
     
     private String              result;
     private Map<String, String> errors      = new HashMap<String, String>();

     public String getResult() {    return result;     }
     public Map<String, String> getErrors() {    return errors;    }
     
     public UserBean createUser( HttpServletRequest request ) {
    	    String email = getFieldValue( request, CHAMP_EMAIL );
    	    String motDePasse = getFieldValue( request, CHAMP_PASS );
    	    String lastname = getFieldValue( request, CHAMP_LASTNAME );
    	    String firstname = getFieldValue( request, CHAMP_FIRSTNAME );
    	    String role = getFieldValue(request, CHAMP_ADMIN);

    	    
    	    UserBean utilisateur = new UserBean();

    	    try {
    	        emailValidator( email );
    	    } catch ( Exception e ) {
    	        setError( CHAMP_EMAIL, e.getMessage() );
    	    }
    	    utilisateur.setEmail( email );

    	    try {
    	        passwordValidator( motDePasse);
    	    } catch ( Exception e ) {
    	        setError( CHAMP_PASS, e.getMessage() );
    	    }
    	    utilisateur.setPassword( motDePasse );

    	    try {
    	        nameValidator(firstname);
    	    } catch ( Exception e ) {
    	        setError( CHAMP_FIRSTNAME, e.getMessage() );
    	    }
    	    utilisateur.setFirstName(firstname);
    	    
    	    try {
    	        nameValidator(lastname);
    	    } catch ( Exception e ) {
    	        setError( CHAMP_LASTNAME, e.getMessage() );
    	    }
    	    utilisateur.setLastName(lastname);
    	    
    	    if(role.equals("Administrateur")) {
    	    	utilisateur.setAdmin(true);
    	    } else {
    	    	utilisateur.setAdmin(false);
    	    }
    	    utilisateur.setState(true);
    	    
    	    if (! errors.isEmpty() ) {
    	        result = "Corrigez les erreurs du formulaire d'inscription.";
    	    } 

    	    return utilisateur;
    	}
     

	private void emailValidator( String email ) throws Exception {
	    if ( email != null ) {
	        if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
	            throw new Exception( "Merci de saisir une adresse mail valide." );
	        } else if(!UserDAO.isEmailUnique(email)) {
	        	throw new Exception("Adresse email déjà utilisée");
	        }
	    } else {
	        throw new Exception( "Merci de saisir une adresse mail." );
	    }
	}
	
	
	private void passwordValidator( String motDePasse) throws Exception {
	    if ( motDePasse != null) {
	    	if ( motDePasse.length() < 3 ) {
	            throw new Exception( "Les mots de passe doivent contenir au moins 3 caractères." );
	        }
	    } else {
	        throw new Exception( "Mot de passe incorrect." );
	    }
	}
	
	
	private void nameValidator( String nom ) throws Exception {
	    if ( nom != null && nom.length() < 3 ) {
	        throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
	    }
	}
	
	
	/*
	 * Ajoute un message correspondant au champ spécifié à la map des erreurs.
	 */
	
	private void setError( String champ, String message ) {    errors.put( champ, message ); }
	
	
	/*
	 * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
	 * sinon.
	 */
	
	private static String getFieldValue( HttpServletRequest request, String nomChamp ) {
	    String valeur = request.getParameter( nomChamp );
	    if ( valeur == null || valeur.trim().length() == 0 ) {
	        return null;
	    } else {
	        return valeur.trim();
	    }
	}

}
