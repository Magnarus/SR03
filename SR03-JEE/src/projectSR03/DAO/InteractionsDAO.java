package projectSR03.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InteractionsDAO {

	public static int mySQLwritingQuery (String req) {
		
		Connection conn = null;
		Statement preparedStatement = null;
		ResultSet result = null;
		int key = 0;
		try {
			conn = MysqljdbcDAO.mySQLgetConnection();
			preparedStatement = conn.createStatement();
        	System.out.println(req);
			preparedStatement.executeUpdate(req, Statement.RETURN_GENERATED_KEYS);
			result = preparedStatement.getGeneratedKeys();
			if(result.next() && result != null){
				    key = result.getInt(1);
				}
		} 
		catch ( SQLException e ) {
		    /* Traiter les erreurs éventuelles ici. */
		} 
		finally {
			MysqljdbcDAO.closeConnection(result, preparedStatement, conn);	
		}
		return key;
	}
	
	public static ResultSet mySQLreadingQuery (Connection conn, PreparedStatement preparedStatement) {
		
		ResultSet result = null;
		
		try {
			result = preparedStatement.executeQuery();
		} 
		catch ( SQLException e ) {
		    /* Traiter les erreurs éventuelles ici. */
		} 

		return result;

	}
}
