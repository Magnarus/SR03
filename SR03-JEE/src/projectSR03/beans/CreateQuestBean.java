package projectSR03.beans;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import projectSR03.DAO.QuestionnaireDAO;

public class CreateQuestBean {

	Map<String, String> errors;
	
	public CreateQuestBean() {
		errors = new HashMap<>();
	}
	
	public void createQuestionnaire(HttpServletRequest req) {
		QuestionnaireBean questionnaire = new QuestionnaireBean();
		String name = getValeurChamp(req, "title");
		String subject = getValeurChamp(req, "subject");
		if(name != null && subject != null) {
			questionnaire.setName(name);
			questionnaire.setSubject(subject);
			QuestionnaireDAO.addQuestionnaire(questionnaire);
		} else if(name == null) {
			errors.put("invalid_name", "le nom ne peut être null");
		} else errors.put("invalid_subject","le sujet ne peut être null");
	}
	
	private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
	
	public Map<String, String> getErrors() {
		return errors;
	}
}
