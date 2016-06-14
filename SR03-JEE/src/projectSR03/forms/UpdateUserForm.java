package projectSR03.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import projectSR03.DAO.UserDAO;
import projectSR03.beans.UserBean;

public final class UpdateUserForm extends FormHelper{
	 private static final String CHAMP_EMAIL  = "email";
	 private static final String CHAMP_PASS   = "password";
     private static final String CHAMP_LASTNAME    = "lastname";
     private static final String CHAMP_FIRSTNAME    = "firstname";
     private static final String CHAMP_ADMIN    = "admin";
     private static final String CHAMP_PHONE    = "phonenumber";
     private static final String CHAMP_COMPANY    = "company";
     private static final String CHAMP_STATE   = "state";
     
     
     private String              result;
     private Map<String, String> errors      = new HashMap<String, String>();

     public String getResult() {    return result;     }
     
     public UserBean createUser( HttpServletRequest request ) {
    	    String email = getFieldValue( request, CHAMP_EMAIL );
    	    String motDePasse = getFieldValue( request, CHAMP_PASS );
    	    String lastname = getFieldValue( request, CHAMP_LASTNAME );
    	    String firstname = getFieldValue( request, CHAMP_FIRSTNAME );
    	    String role = getFieldValue(request, CHAMP_ADMIN);
    	    String company = getFieldValue(request, CHAMP_COMPANY);
    	    String phonenumber = getFieldValue(request, CHAMP_PHONE);
    	    String state = getFieldValue(request, CHAMP_STATE);
    	    
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
    	        stringValidator(firstname);
    	    } catch ( Exception e ) {
    	        setError( CHAMP_FIRSTNAME, e.getMessage() );
    	    }
    	    utilisateur.setFirstName(firstname);
    	    
    	    try {
    	        stringValidator(company);
    	    } catch ( Exception e ) {
    	        setError( CHAMP_COMPANY, e.getMessage() );
    	    }
    	    utilisateur.setCompany(company);
    	    
    	    try {
    	        phoneValidator(phonenumber);
    	    } catch ( Exception e ) {
    	        setError( CHAMP_PHONE, e.getMessage() );
    	    }
    	    utilisateur.setPhoneNumber(phonenumber);
    	    
    	    try {
    	        stringValidator(lastname);
    	    } catch ( Exception e ) {
    	        setError( CHAMP_LASTNAME, e.getMessage() );
    	    }
    	    utilisateur.setLastName(lastname);
    	    
    	    if(role.equals("admin")) {
    	    	utilisateur.setAdmin(true);
    	    } else {
    	    	utilisateur.setAdmin(false);
    	    }
    	    
    	    if(state.equals("actif")) {
    	    	utilisateur.setState(true);
    	    } else {
    	    	utilisateur.setState(false);
    	    }
    	    
    	    
    	    if (! errors.isEmpty() ) {
    	        result = "Corrigez les erreurs du formulaire d'inscription.";
    	    } 

    	    return utilisateur;
    	}
     

	private void emailValidator( String email ) throws Exception {
	    if ( email != null ) {
	        if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
	            throw new Exception( "Merci de saisir une adresse mail valide." );
	        } 
	    } else {
	        throw new Exception( "Merci de saisir une adresse mail." );
	    }
	}
	
	private void phoneValidator( String phone ) throws Exception {
	    if ( phone != null ) {
	        if ( !phone.matches( "[0-9]{10}" ) ) {
	            throw new Exception( "Numéro de téléphone invalide." );
	        } 
	    } else {
	        throw new Exception( "Merci de saisir un numéro." );
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
	
	
	private void stringValidator( String string ) throws Exception {
	    if ( string != null && string.length() < 3 ) {
	        throw new Exception( "Champs invalide." );
	    }
	}
}
