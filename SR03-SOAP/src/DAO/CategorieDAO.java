package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategorieDAO {
	
	public static void deleteCategorie(int id) {
		InteractionsDAO.mySQLwritingQuery("DELETE FROM categorie Where Id = " + id + ";" );
	}
	
	public static void addCategorie(String nom) {
		String addAnswer = "INSERT INTO categorie(nom) VALUES(\"" + nom + "\")";
		int key = InteractionsDAO.mySQLwritingQuery(addAnswer);
	}
	
	public static void getCategories() {
		String getRequest = "SELECT * FROM categorie";
		Connection conn = MysqljdbcDAO.mySQLgetConnection();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(getRequest);
			InteractionsDAO.mySQLreadingQuery(MysqljdbcDAO.mySQLgetConnection(), preparedStatement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void updateCategorieName(int id, String newName) {
		String updateRequest = "UPDATE categorie SET nom='"+newName+"' WHERE id="+ id;
		InteractionsDAO.mySQLwritingQuery(updateRequest);
	}
}
