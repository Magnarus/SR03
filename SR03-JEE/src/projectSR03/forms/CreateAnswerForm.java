package projectSR03.forms;

import javax.servlet.http.HttpServletRequest;

import projectSR03.beans.AnswerBean;
import projectSR03.beans.CompoQuestionBean;

public class CreateAnswerForm extends FormHelper {
	public CompoQuestionBean createQuestion(HttpServletRequest req) {
		CompoQuestionBean bean = new CompoQuestionBean();
		AnswerBean answer = new AnswerBean();
		String value = getFieldValue(req, "value");
		String qId = getFieldValue(req, "q_id");
		
		try {
			validateValue(value);
		} catch (Exception e) {
			setError("title", e.getMessage());
		}
		try {
			validateQuestionId(qId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		answer.setValue(value);
		bean.setAnswer(answer);
		bean.setQuestionId(qId);
		return bean;
	}
	
	private void validateValue(String value) throws Exception {
		if(value == null || value.isEmpty()) {
			throw new Exception("le titre doit être indiqué");
		}
	}
	
	private void validateQuestionId(String id) throws Exception {
		if(id == null || id.isEmpty()) {
			throw new Exception("problème interne de transmission du formulaire");
		}
	}
}
