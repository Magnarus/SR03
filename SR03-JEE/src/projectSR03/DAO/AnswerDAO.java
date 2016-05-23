package projectSR03.DAO;

import projectSR03.beans.AnswerBean;
import projectSR03.beans.CompoQuestionBean;

public class AnswerDAO {

	public static void deleteAnswer(AnswerBean a) {
		InteractionsDAO.mySQLwritingQuery("DELETE FROM Answer Where Id = " + a.getId() + ";" );
	}
	
	public static void addAnswer(CompoQuestionBean cqb) {
		String addAnswer = "INSERT INTO Answer(Value) VALUES(\"" + cqb.getAnswer().getValue() + "\")";
		int key = InteractionsDAO.mySQLwritingQuery(addAnswer);
		String addCompoQuestion;
		int order = QuestionDAO.getAnswers(Integer.parseInt(cqb.getQuestionId())).size()+1;
		String id = Integer.toString(QuestionDAO.getMaxCompoQuestionId()+1);
		addCompoQuestion = "INSERT INTO CompoQuestion VALUES("
							+cqb.getQuestionId()+ "," 
							+ key + ","
							+ id + ","
							+ order+1 + ")";
		InteractionsDAO.mySQLwritingQuery(addCompoQuestion);
	}
	
	public static void setIsActif(String aId, String state) {
		InteractionsDAO.mySQLwritingQuery("UPDATE Answer SET State='" + state + "' WHERE Id='" +aId + "'");
	}
}
