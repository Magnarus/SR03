package projectSR03.DAO;

import projectSR03.beans.AnswerBean;
import projectSR03.beans.QuestionBean;

public class QuestionDAO {
	
	public static void deleteAnswers(QuestionBean question) {
		System.out.println("Je delete les answers!");
		for(AnswerBean ans : question.getAnswers()) {
			InteractionsDAO.mySQLwritingQuery("DELETE FROM Answer Where Id = " + ans.getId() + ";" );
		}
	}
	
}
