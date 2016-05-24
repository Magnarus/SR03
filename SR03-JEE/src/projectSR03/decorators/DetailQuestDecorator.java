package projectSR03.decorators;

import java.util.Enumeration;

import org.displaytag.decorator.TableDecorator;

import projectSR03.beans.QuestionBean;

public class DetailQuestDecorator extends TableDecorator {

	public String getState() {
		QuestionBean question = (QuestionBean)getCurrentRowObject();
		int id = question.getId();
		String returnedString;
		String questionnaireId = getPageContext().getRequest().getParameter("id");
		if(question.getState()) {
			returnedString = "<a href=\"?id="+questionnaireId+"&questionId="+id+"&state=0\">Actif</a>";
		} else returnedString = "<a href=\"?id="+questionnaireId+"&questionId="+id+"&state=1\">Inactif</a>";
		return returnedString;
	}
}
