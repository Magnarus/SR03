package projectSR03.forms;

import javax.servlet.http.HttpServletRequest;

import projectSR03.DAO.QuestionDAO;
import projectSR03.beans.CompoQuestionnaireBean;
import projectSR03.beans.QuestionBean;

public class CreateQuestionForm extends FormHelper {
	
	public CompoQuestionnaireBean createQuestion(HttpServletRequest req) {
		CompoQuestionnaireBean bean = new CompoQuestionnaireBean();
		QuestionBean question = new QuestionBean();
		String title = getFieldValue(req, "title");
		String qId = getFieldValue(req, "q_id");
		
		try {
			validateTitle(title);
		} catch (Exception e) {
			setError("title", e.getMessage());
		}
		try {
			validateQuestionnaireId(qId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		question.setTitle(title);
		bean.setQuestion(question);
		bean.setQuestionnaireId(qId);
		return bean;
	}
	
	private void validateTitle(String title) throws Exception {
		if(title == null || title.isEmpty()) {
			throw new Exception("le titre doit être indiqué");
		}
	}
	
	private void validateQuestionnaireId(String id) throws Exception {
		if(id == null || id.isEmpty()) {
			throw new Exception("problème interne de transmission du formulaire");
		}
	}
}
