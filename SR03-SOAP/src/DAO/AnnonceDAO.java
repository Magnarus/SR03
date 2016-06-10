package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AnnonceDAO {
	public static void deleteAnnonce(int id) {
		InteractionsDAO.mySQLwritingQuery("DELETE FROM annonce Where Id = " + id + ";" );
	}
	
	public static void addAnnonce(String nom, String annonceur, String telephone, String idAdresse, int idCateg) {
		String addAnswer = "INSERT INTO annonce(annonceur, nom, telephone, idAdresse)"
						  + "VALUES(\"" + annonceur + "\","
						  			+"\""+nom+"\","
						  		    +"\""+ telephone +"\","
						  			+" \""+idAdresse+"\")";
		int key = InteractionsDAO.mySQLwritingQuery(addAnswer);
		String addCompoCateg = "INSERT INTO CompoCateg VALUES("
				+idCateg+ "," 
				+ key + ")";
		InteractionsDAO.mySQLwritingQuery(addCompoCateg);		
	}
	
	public static void getAnnonces() {
		String getRequest = "SELECT * FROM Annonce";
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
	
	public static void updateAnnonceName(int id,String nom, String annonceur, String telephone, String idAdresse) {
		String addAnswer = "UPDATE annonce"
				  + "SET(annonceur ="+ annonceur + ","
				  			+"nom = "+nom+","
				  		    +"telephone = "+ telephone +","
				  			+"idAdresse = "+idAdresse
				  			+ " WHERE id = "+id +")";
		int key = InteractionsDAO.mySQLwritingQuery(addAnswer);
	}
	
	public static void addAdresse(String rue, String ville, String codePostal) {
		String addAdresse = "INSERT INTO adresse(rue, ville, code_postal) VALUES("
							+"\""+rue+"\", "
							+"\""+ville+"\", "
							+"\""+codePostal+"\"";
	}
	
	public static void getAdresse(String idAdresse) {
		String getRequest = "SELECT * FROM adresse WHERE id = " + idAdresse;
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
}
