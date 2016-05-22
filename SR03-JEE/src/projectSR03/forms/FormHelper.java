package projectSR03.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class FormHelper {

	protected Map<String, String> errors;
	
	public FormHelper() {
		errors = new HashMap<>();
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}
	
	protected void setError( String champ, String message ) {
        errors.put( champ, message );
    }
	
	protected String getFieldValue( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
	
}
