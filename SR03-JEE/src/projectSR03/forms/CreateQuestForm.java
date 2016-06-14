package projectSR03.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import projectSR03.DAO.QuestionnaireDAO;
import projectSR03.beans.QuestionnaireBean;

public class CreateQuestForm extends FormHelper {
	
	public QuestionnaireBean createQuestionnaire(HttpServletRequest req) {
		String title = getFieldValue(req, "title");
		String subject = getFieldValue(req, "subject");
		QuestionnaireBean questionnaire = new QuestionnaireBean();
		
		try {
			titleValidator(title);
		} catch(Exception e) {
			setError("title", e.getMessage());
		}
		
		try {
			subjectValidator(subject);
		} catch(Exception e) {
			setError("subject", e.getMessage());
		}
		
		questionnaire.setName(title);
		questionnaire.setSubject(subject);
		return questionnaire;
	}

	private void titleValidator(String title) throws Exception {
		if(title == null) throw new Exception("Le titre ne doit pas être null");
	}
	
	private void subjectValidator(String subject) throws Exception {
		if(subject == null) throw new Exception("Le sujet ne doit pas être null");
	}
}
