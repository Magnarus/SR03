package projectSR03.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

	public static String getLogin(String email) {
		
		Connection conn = MysqljdbcDAO.mySQLgetConnection();
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		String mail = null;
		
		try {
			preparedStatement = conn.prepareStatement( "SELECT Email FROM sr03p028.User WHERE Email = ?;" );
			preparedStatement.setString(1, email);
			
			result = InteractionsDAO.mySQLreadingQuery(conn, preparedStatement);
			result.next();
			mail = result.getString(1);

		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			MysqljdbcDAO.closeConnection(result, preparedStatement, conn);				
		}
		
		return mail;
	}
	
	public static String getPassword(String email) {
		
		Connection conn = MysqljdbcDAO.mySQLgetConnection();
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		String pass = null;
		
		try {
			preparedStatement = conn.prepareStatement( "SELECT Password FROM sr03p028.User WHERE Email = ?;" );
			preparedStatement.setString(1, email);
			
			result = InteractionsDAO.mySQLreadingQuery(conn, preparedStatement);
			result.next();
			pass = result.getString(1);

		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			MysqljdbcDAO.closeConnection(result, preparedStatement, conn);				
		}
		
		return pass;
	}
	
	public static boolean isAdmin(String email) {
		
		Connection conn = MysqljdbcDAO.mySQLgetConnection();
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		boolean admin = false;
		
		try {
			preparedStatement = conn.prepareStatement( "SELECT Role FROM sr03p028.User WHERE Email = ?;" );
			preparedStatement.setString(1, email);
			
			result = InteractionsDAO.mySQLreadingQuery(conn, preparedStatement);
			result.next();
			admin = result.getBoolean(1);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			MysqljdbcDAO.closeConnection(result, preparedStatement, conn);				
		}
		
		return admin;
	}
}
