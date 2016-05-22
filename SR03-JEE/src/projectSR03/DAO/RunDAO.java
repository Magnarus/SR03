package projectSR03.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

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

	public static int createRun(String questId, int id) {
		String rqt = "INSERT INTO Run(Duration, idUser, idQuestionnaire, Score, Date) "
				+ "VALUES(?,?,?,?, SYSDATE());";
		Connection conn = MysqljdbcDAO.mySQLgetConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int idRun = 0;
		try {
			statement = conn.prepareStatement(rqt, Statement.RETURN_GENERATED_KEYS);
			statement.setTime(1, new Time(0));
			statement.setInt(2, id);
			statement.setInt(3, Integer.parseInt(questId));
			statement.setLong(4, 0);
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			if(resultSet.next() && resultSet!=null) {
				idRun = resultSet.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			MysqljdbcDAO.closeConnection(resultSet, statement, conn);
		}
		
		return idRun;
	}

}
