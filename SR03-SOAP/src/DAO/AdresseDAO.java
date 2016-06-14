package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.AdresseBean;

public class AdresseDAO {
	public static void addAdresse(AdresseBean b) {
		String addAdresse = "INSERT INTO adresse(rue, ville, code_postal) VALUES("
							+"\""+b.getRue()+"\", "
							+"\""+b.getVille()+"\", "
							+"\""+b.getCodePostal()+"\"";
	}
	
	public static AdresseBean getAdresse(int idAdresse) {
		String getRequest = "SELECT * FROM adresse WHERE id = " + idAdresse;
		Connection conn = MysqljdbcDAO.mySQLgetConnection();
		PreparedStatement preparedStatement;
		ResultSet result = null;
		AdresseBean adresse = new AdresseBean();
		try {
			preparedStatement = conn.prepareStatement(getRequest);
			result = InteractionsDAO.mySQLreadingQuery(MysqljdbcDAO.mySQLgetConnection(), preparedStatement);
			while(result.next()) {
				adresse.setId(result.getInt("id"));
				adresse.setRue(result.getString("rue"));
				adresse.setVille(result.getString("ville"));
				adresse.setCodePostal(result.getInt("code_postal"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adresse;
	}
}
