package projectSR03.decorators;

import org.displaytag.decorator.TableDecorator;

import projectSR03.beans.AnswerBean;

public class ManageAnswerDecorator extends TableDecorator {

	public String getState() {
		AnswerBean question = (AnswerBean)getCurrentRowObject();
		int id = question.getId();
		String questionId = getPageContext().getRequest().getParameter("id");
		int futureState = question.getState() ? 0 : 1;
		String actif = futureState == 0 ? "Actif" : "Inactif";
		return "<a href=\"?id="+questionId+"&aId="+id+"&state="+futureState+"\">"+actif+"</a>";
	}
}
