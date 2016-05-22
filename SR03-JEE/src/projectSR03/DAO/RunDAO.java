package projectSR03.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import projectSR03.beans.QuestionnaireBean;
import projectSR03.beans.RunBean;

public class RunDAO {
	
	public static ArrayList<RunBean> getUserRuns(int id) {
		ArrayList<RunBean> runs = new ArrayList<RunBean>();
		Connection conn = MysqljdbcDAO.mySQLgetConnection();
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		try {
			preparedStatement = conn.prepareStatement( "SELECT * FROM Run Where idUser = "+ id + ";" );
			
			result = InteractionsDAO.mySQLreadingQuery(conn, preparedStatement);

			while(result.next()) {
			   RunBean run = new RunBean(); 
			   run.setId(result.getInt("Id"));
			   run.setDate(result.getDate("Date"));
			   run.setDuration(result.getTime("Duration"));
			   run.setScore(result.getLong("Score"));
			   run.setQuest(QuestionnaireDAO.getQuestionnaire(result.getInt("idQuestionnaire")));
			   
			   
			   runs.add(run);
			}
			
		} 
		catch (SQLException e) {
			return null;
		}
		finally {
			MysqljdbcDAO.closeConnection(result, preparedStatement, conn);				
		}
		
		
		
		return runs;
	}

}
