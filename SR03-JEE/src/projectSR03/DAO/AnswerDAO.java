package projectSR03.DAO;

import projectSR03.beans.AnswerBean;
import projectSR03.beans.QuestionBean;

public class AnswerDAO {

	public static void deleteAnswer(AnswerBean a) {
		InteractionsDAO.mySQLwritingQuery("DELETE FROM Answer Where Id = " + a.getId() + ";" );
	}
}
