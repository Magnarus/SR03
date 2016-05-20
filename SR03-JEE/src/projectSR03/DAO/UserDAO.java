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
			preparedStatement = conn.prepareStatement( "SELECT * FROM sr03p039.User;" );
			
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
	
}
