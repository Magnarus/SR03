package projectSR03.decorators;

import org.displaytag.decorator.TableDecorator;

import projectSR03.beans.QuestionnaireBean;

public class ManageQuestDecorator extends TableDecorator {
	
	public String getState() {
		QuestionnaireBean question = (QuestionnaireBean)getCurrentRowObject();
		int id = question.getId();
		int futureState = question.getState() ? 0 : 1;
		String actif = futureState == 0 ? "Actif" : "Inactif";
		return "<a href=\"?id="+id+"&state="+futureState+"\">"+actif+"</a>";
	}
}
