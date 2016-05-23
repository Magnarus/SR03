package projectSR03.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import projectSR03.beans.QuestionBean;
import projectSR03.beans.RunBean;

public class UserAnswerDAO {

	public static int createEntry(int idAnswer, int id) {
		String addEntry = "INSERT INTO UserAnswer(IdCompoQuestion)"
						 + " SELECT cq.Id"
						 + " FROM CompoQuestion cq"
						 + " WHERE cq.IdQuestion = " + id
						 + " AND cq.IdAnswer = " + idAnswer + ";";
		int key = InteractionsDAO.mySQLwritingQuery(addEntry);
		return key;		
	}

	
	
}
