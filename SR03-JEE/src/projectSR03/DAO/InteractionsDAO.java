package projectSR03.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InteractionsDAO {

	public static void mySQLwritingQuery (String req) {
		
		Connection conn = null;
		Statement preparedStatement = null;
		ResultSet result = null;
		
		try {
			conn = MysqljdbcDAO.mySQLgetConnection();
			preparedStatement = conn.createStatement();
        	System.out.println(req);
			preparedStatement.executeUpdate(req, Statement.RETURN_GENERATED_KEYS);
			result = preparedStatement.getGeneratedKeys();
		} 
		catch ( SQLException e ) {
		    /* Traiter les erreurs éventuelles ici. */
		} 
		finally {
			MysqljdbcDAO.closeConnection(result, preparedStatement, conn);	
		}
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
