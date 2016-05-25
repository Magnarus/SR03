package projectSR03.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

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
			statement = conn.prepareStatement("INSERT INTO User(FirstName,LastName,Email,Password,Role,State, PhoneNumber, Company) VALUES(?,?,?,?,?,?,?,?)");
			statement.setString(1, utilisateur.getFirstName());
			statement.setString(2, utilisateur.getLastName());
			statement.setString(3, utilisateur.getEmail());
			statement.setString(4, utilisateur.getPassword());
			statement.setBoolean(5, utilisateur.isAdmin());
			statement.setBoolean(6, utilisateur.isState());
			statement.setString(7, utilisateur.getPhoneNumber());
			statement.setString(8, utilisateur.getCompany());
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

	
	
	public static UserBean getUser(String email) {
		Connection conn = MysqljdbcDAO.mySQLgetConnection();
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		UserBean user = new UserBean();
		
		try {
			preparedStatement = conn.prepareStatement( "SELECT * FROM User WHERE Email = \""+ email +"\";" );
			
			result = InteractionsDAO.mySQLreadingQuery(conn, preparedStatement);
			
			while(result.next()){
				user = UserBean.map(result);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			MysqljdbcDAO.closeConnection(result, preparedStatement, conn);				
		}
		
		return user;
	}
	
	public static UserBean getUserById(String id) {
		Connection conn = MysqljdbcDAO.mySQLgetConnection();
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		UserBean user = new UserBean();
		
		try {
			preparedStatement = conn.prepareStatement( "SELECT * FROM User WHERE Id = "+ id +";" );
			
			result = InteractionsDAO.mySQLreadingQuery(conn, preparedStatement);
			
			while(result.next()){
				user = UserBean.map(result);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			MysqljdbcDAO.closeConnection(result, preparedStatement, conn);				
		}
		
		return user;
	}

	public static void UpdateUser(UserBean utilisateur) {
		String rqt = "UPDATE User"
					+" SET FirstName = \"" + utilisateur.getFirstName() + "\","
					+ " LastName =\"" + utilisateur.getLastName() + "\","
					+ " Password = \"" + utilisateur.getPassword() + "\","
					+ " Company = \"" + utilisateur.getCompany() + "\","
					+ " Role = " + utilisateur.isAdmin() + ", "
					+ " State = " + utilisateur.isState() + ", "
					+ " Email = \"" + utilisateur.getEmail() + "\","
					+ " PhoneNumber = \"" + utilisateur.getPhoneNumber() + "\""
					+ " WHERE Id = " + utilisateur.getId() + ";";
		InteractionsDAO.mySQLwritingQuery(rqt);
	}

	public static void deleteUser(String id) {
		String rqt = "DELETE FROM User Where Id = " + id;
		InteractionsDAO.mySQLwritingQuery(rqt);
	}
	
}
