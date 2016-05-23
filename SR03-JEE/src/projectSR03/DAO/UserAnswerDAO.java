package projectSR03.DAO;

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
