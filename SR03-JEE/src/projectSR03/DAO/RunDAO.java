package projectSR03.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import com.mysql.jdbc.Statement;

import projectSR03.beans.RunBean;
import projectSR03.utils.ValueComparator;

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
			   String time = String.format("%02d min, %02d sec", 
					    TimeUnit.MILLISECONDS.toMinutes((long) result.getFloat("Duration")),
					    TimeUnit.MILLISECONDS.toSeconds((long) result.getFloat("Duration")) - 
					    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) result.getFloat("Duration")))
					);
			   run.setDuration(time);
			   run.setScore(result.getLong("Score"));
			   run.setClassement(result.getInt("Classement"));
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
		String rqt = "INSERT INTO Run(Duration, idUser, idQuestionnaire, Score, Date, Classement) "
				+ "VALUES(?,?,?,?, SYSDATE(), ?);";
		System.out.println(rqt);
		Connection conn = MysqljdbcDAO.mySQLgetConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int idRun = 0;
		try {
			statement = conn.prepareStatement(rqt, Statement.RETURN_GENERATED_KEYS);
			statement.setFloat(1,0);
			statement.setInt(2, id);
			statement.setInt(3, Integer.parseInt(questId));
			statement.setLong(4, 0);
			statement.setInt(5, -1);
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

	public static void UpdateScore(int idRun) {
		String rqt = "UPDATE Run SET Score = Score + 1"
					+ " WHERE Id = " + idRun;
		System.out.println(rqt);
		Connection conn = MysqljdbcDAO.mySQLgetConnection();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(rqt);
			statement.executeUpdate();			
		} 
		catch (SQLException e) {
			System.out.println("Message " + e.getMessage());
		}
		finally {
			MysqljdbcDAO.closeConnection(statement, conn);				
		}
	}
	
	public static void UpdateDuration(int idRun, long start) {
		String rqt = "UPDATE Run SET Duration = " + (System.currentTimeMillis() - start) + ""
					+ " WHERE Id = " + idRun;
		System.out.println(rqt);
		Connection conn = MysqljdbcDAO.mySQLgetConnection();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(rqt);
			statement.executeUpdate();			
		} 
		catch (SQLException e) {
			System.out.println("Message " + e.getMessage());
		}
		finally {
			MysqljdbcDAO.closeConnection(statement, conn);				
		}
	}

	public static ArrayList<RunBean> getUserBestRuns(String id) {
		String rqt = "SELECT Distinct(IdQuestionnaire), Id, Score, Date, Duration, Classement"
				    +  " FROM Run r"
					+  " WHERE idUser = " + id 
					+  " AND Score = (SELECT MAX(Score)"
						+		" From Run ru "
						+		" WHERE ru.IdQuestionnaire = r.IdQuestionnaire"
						+ 		" AND idUser = " + id + ");";
		
		System.out.println(rqt);
		ArrayList<RunBean> runs = new ArrayList<RunBean>();
		Connection conn = MysqljdbcDAO.mySQLgetConnection();
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		try {
			preparedStatement = conn.prepareStatement( rqt );
			
			result = InteractionsDAO.mySQLreadingQuery(conn, preparedStatement);

			while(result.next()) {
			   RunBean run = new RunBean(); 
			   run.setId(result.getInt("Id"));
			   run.setDate(result.getDate("Date"));
			   String time = String.format("%02d min, %02d sec", 
					    TimeUnit.MILLISECONDS.toMinutes((long) result.getFloat("Duration")),
					    TimeUnit.MILLISECONDS.toSeconds((long) result.getFloat("Duration")) - 
					    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) result.getFloat("Duration")))
					);
			   run.setDuration(time);
			   run.setScore(result.getLong("Score"));
			   run.setClassement(result.getInt("Classement"));
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
	
	public static long getRunScore(int idRun){
		
		long score = -1;
		
		String rqt = "SELECT Score"
			    +  " FROM Run r"
				+  " WHERE r.Id = " + idRun +";";
	
		Connection conn = MysqljdbcDAO.mySQLgetConnection();
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		try {
			preparedStatement = conn.prepareStatement( rqt );

			result = InteractionsDAO.mySQLreadingQuery(conn, preparedStatement);
			result.next();
			score = result.getLong("Score");
		} 
		catch (SQLException e) {

		}
		finally {
			MysqljdbcDAO.closeConnection(result, preparedStatement, conn);				
		}
		return score;	
	}

	public static String getRunDuration(int idRun){
		
		String duration = null;
		
		String rqt = "SELECT Duration"
			    +  " FROM Run r"
				+  " WHERE r.Id = " + idRun +";";
	
		Connection conn = MysqljdbcDAO.mySQLgetConnection();
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		try {
			preparedStatement = conn.prepareStatement( rqt );
			
			result = InteractionsDAO.mySQLreadingQuery(conn, preparedStatement);
			result.next();
			duration = String.format("%02d min, %02d sec", 
				    TimeUnit.MILLISECONDS.toMinutes((long) result.getFloat("Duration")),
				    TimeUnit.MILLISECONDS.toSeconds((long) result.getFloat("Duration")) - 
				    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) result.getFloat("Duration"))));
		} 
		catch (SQLException e) {

		}
		finally {
			MysqljdbcDAO.closeConnection(result, preparedStatement, conn);				
		}
		return duration;	
	}

	public static ArrayList<RunBean> getUserBestRuns(int id, String filter) {
		String rqt = "SELECT Distinct(IdQuestionnaire), q.Id as Id, Score, Date, Duration, Classement"
			    +  " FROM Run r, Questionnaire q"
				+  " WHERE idUser = " + id
				+  " AND r.IdQuestionnaire = q.Id"
				+  " AND q.Subject LIKE \"%" + filter + "%\""
				+  " AND Score = (SELECT MAX(Score)"
					+		" From Run ru "
					+		" WHERE ru.IdQuestionnaire = r.IdQuestionnaire"
					+ 		" AND idUser = " + id + ");";
	
		System.out.println(rqt);
		ArrayList<RunBean> runs = new ArrayList<RunBean>();
		Connection conn = MysqljdbcDAO.mySQLgetConnection();
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		try {
			preparedStatement = conn.prepareStatement( rqt );
			
			result = InteractionsDAO.mySQLreadingQuery(conn, preparedStatement);
	
			while(result.next()) {
			   RunBean run = new RunBean(); 
			   run.setId(result.getInt("Id"));
			   run.setDate(result.getDate("Date"));
			   String time = String.format("%02d min, %02d sec", 
					    TimeUnit.MILLISECONDS.toMinutes((long) result.getFloat("Duration")),
					    TimeUnit.MILLISECONDS.toSeconds((long) result.getFloat("Duration")) - 
					    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) result.getFloat("Duration")))
					);
			   run.setDuration(time);
			   run.setScore(result.getLong("Score"));
			   run.setClassement(result.getInt("Classement"));
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

	public static ArrayList<RunBean> getUserRuns(int id, String filter) {
		ArrayList<RunBean> runs = new ArrayList<RunBean>();
		Connection conn = MysqljdbcDAO.mySQLgetConnection();
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		try {
			preparedStatement = conn.prepareStatement( "SELECT * FROM Run r, Questionnaire q " 
													 	+ " Where r.IdQuestionnaire = q.Id AND idUser = "+ id 
													 	+ " AND q.Subject LIKE \"%"+ filter + "%\" ;" );
			
			result = InteractionsDAO.mySQLreadingQuery(conn, preparedStatement);

			while(result.next()) {
			   RunBean run = new RunBean(); 
			   run.setId(result.getInt("Id"));
			   run.setDate(result.getDate("Date"));
			   String time = String.format("%02d min, %02d sec", 
					    TimeUnit.MILLISECONDS.toMinutes((long) result.getFloat("Duration")),
					    TimeUnit.MILLISECONDS.toSeconds((long) result.getFloat("Duration")) - 
					    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) result.getFloat("Duration")))
					);
			   run.setDuration(time);
			   run.setScore(result.getLong("Score"));
			   run.setClassement(result.getInt("Classement"));
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

	public static TreeMap<Integer,Integer> getClassement(int idQuest, int userId, int score) {
		
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		ValueComparator comparateur = new ValueComparator(map);
		TreeMap<Integer,Integer> mapTriee = new TreeMap<Integer,Integer>(comparateur);
		
		map.put(userId, score);
		
		String rqt = "SELECT Max(Score) AS Score, idUser FROM Run r "
				+ "WHERE IdQuestionnaire = ? "
				+ "GROUP BY idUser;";
		
		Connection conn = MysqljdbcDAO.mySQLgetConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = conn.prepareStatement(rqt);
			statement.setInt(1, idQuest);
			
			resultSet = InteractionsDAO.mySQLreadingQuery(conn, statement);
			while(resultSet.next()) {
				map.put(resultSet.getInt("idUser"), resultSet.getInt("Score"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			MysqljdbcDAO.closeConnection(resultSet, statement, conn);
		}
		
		mapTriee.putAll(map);
		 
		return mapTriee;
	}

	public static void setClassement(TreeMap<Integer, Integer> classement, int idQuest) {
		
		String rqt = "UPDATE Run SET Classement = ? "
				+ "WHERE IdQuestionnaire = ? AND idUser = ? ;";
		
		int currentInd = 1;
		
		for (Entry<Integer, Integer> entry : classement.entrySet()) {
			
			Connection conn = MysqljdbcDAO.mySQLgetConnection();
			PreparedStatement statement = null;
			ResultSet resultSet = null;
			
			try {
				statement = conn.prepareStatement(rqt, Statement.RETURN_GENERATED_KEYS);
				statement.setInt(1, currentInd);
				statement.setInt(2, idQuest);
				statement.setInt(3, entry.getKey());
				statement.executeUpdate();
				resultSet = statement.getGeneratedKeys();
				currentInd++;
			}
			catch(Exception e) {
				e.printStackTrace();
			} 
			finally {
				MysqljdbcDAO.closeConnection(resultSet, statement, conn);
			}
		}
	}		

}
