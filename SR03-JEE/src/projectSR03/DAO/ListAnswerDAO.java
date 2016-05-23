package projectSR03.DAO;

public class ListAnswerDAO {
	
	public static void createEntry(int idUserAnswer, int idRun) {
		String addEntry = "INSERT INTO ListAnswer(idUserAnswer, IdRun)"
						+ "VALUES(" + idUserAnswer + "," + idRun + ");";
		InteractionsDAO.mySQLwritingQuery(addEntry);		
	}

}
