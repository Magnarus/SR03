package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.CategorieBean;

public class CategorieDAO {
	
	public static void deleteCategorie(int id) {
		InteractionsDAO.mySQLwritingQuery("DELETE FROM categorie Where Id = " + id + ";" );
	}
	
	public static void addCategorie(String nom) {
		String addAnswer = "INSERT INTO categorie(nom) VALUES(\"" + nom + "\")";
		int key = InteractionsDAO.mySQLwritingQuery(addAnswer);
	}
	
	public static CategorieBean[] getCategories() {
		String getRequest = "SELECT * FROM categorie";
		Connection conn = MysqljdbcDAO.mySQLgetConnection();
		PreparedStatement preparedStatement;
		ResultSet result = null;
		ArrayList<CategorieBean> categList = new ArrayList<CategorieBean>();
		try {
			preparedStatement = conn.prepareStatement(getRequest);
			result = InteractionsDAO.mySQLreadingQuery(MysqljdbcDAO.mySQLgetConnection(), preparedStatement);
			while(result.next()) {
				CategorieBean categ = new CategorieBean();
				categ.setId(result.getInt("id"));
				categ.setNom(result.getString("Nom"));
				categ.setAnonces(AnnonceDAO.getAnnonces(categ.getId()));
				categList.add(categ);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  (CategorieBean[]) categList.toArray();
	}
	
	public static void updateCategorieName(int id, String newName) {
		String updateRequest = "UPDATE categorie SET nom='"+newName+"' WHERE id="+ id;
		InteractionsDAO.mySQLwritingQuery(updateRequest);
	}
}
