package projectSR03.decorators;

import org.displaytag.decorator.TableDecorator;

import projectSR03.beans.QuestionBean;

public class DetailQuestDecorator extends TableDecorator {

	public String getState() {
		QuestionBean question = (QuestionBean)getCurrentRowObject();
		int id = question.getId();
		String questionnaireId = getPageContext().getRequest().getParameter("id");
		int futureState = question.getState() ? 0 : 1;
		String actif = futureState == 0 ? "Actif" : "Inactif";
		return "<a href=\"?id="+questionnaireId+"&questionId="+id+"&state="+futureState+"\">"+actif+"</a>";
	}
}
