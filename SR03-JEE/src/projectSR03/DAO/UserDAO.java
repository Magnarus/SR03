package projectSR03.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import projectSR03.beans.UserBean;

public class UserDAO {

	public static ArrayList<UserBean> getUsers() {
		Connection conn = MysqljdbcDAO.mySQLgetConnection();
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		ArrayList<UserBean> userList = new ArrayList<UserBean>();
		
		try {
			preparedStatement = conn.prepareStatement( "SELECT * FROM User;" );
			
			result = InteractionsDAO.mySQLreadingQuery(conn, preparedStatement);
			
			while(result.next()){
				userList.add(UserBean.map(result));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			MysqljdbcDAO.closeConnection(result, preparedStatement, conn);				
		}
		
		return userList;
	}

	public static void createUser(UserBean utilisateur) {
		Connection conn = MysqljdbcDAO.mySQLgetConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = conn.prepareStatement("INSERT INTO User(FirstName,LastName,Email,Password,Role,State) VALUES(?,?,?,?,?,?)");
			statement.setString(1, utilisateur.getFirstName());
			statement.setString(2, utilisateur.getLastName());
			statement.setString(3, utilisateur.getEmail());
			statement.setString(4, utilisateur.getPassword());
			statement.setBoolean(5, utilisateur.isAdmin());
			statement.setBoolean(6, utilisateur.isState());
			statement.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public static boolean isEmailUnique(String email) {
		Connection conn = MysqljdbcDAO.mySQLgetConnection();
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		int nbResult = 0;

		
		try {
			String rqt = "SELECT Id FROM User WHERE Email = \"" + email + "\"";
			preparedStatement = conn.prepareStatement(rqt);
			
			result = InteractionsDAO.mySQLreadingQuery(conn, preparedStatement);
			
			while(result.next()){
				nbResult++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			MysqljdbcDAO.closeConnection(result, preparedStatement, conn);				
		}
		
		return nbResult == 0;
	}
	
}
