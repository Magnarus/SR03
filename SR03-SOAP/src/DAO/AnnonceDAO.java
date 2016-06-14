package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.AnnonceBean;
import beans.CategorieBean;

public class AnnonceDAO {
	public static void deleteAnnonce(int id) {
		InteractionsDAO.mySQLwritingQuery("DELETE FROM annonce Where Id = " + id + ";" );
	}
	
	public static void addAnnonce(AnnonceBean a, CategorieBean b) {
		String addAnswer = "INSERT INTO annonce(annonceur, nom, telephone, idAdresse)"
						  + "VALUES(\"" + a.getAnnonceur() + "\","
						  			+"\""+ a.getNom() +"\","
						  		    +"\""+ a.getTel() +"\","
						  			+" \""+ a.getAdresse().getId() +"\")";
		int key = InteractionsDAO.mySQLwritingQuery(addAnswer);
		String addCompoCateg = "INSERT INTO CompoCateg VALUES("
				+ b.getId() + "," 
				+ key + ")";
		InteractionsDAO.mySQLwritingQuery(addCompoCateg);		
	}
	
	public static AnnonceBean[] getAnnonces() {
		String getRequest = "SELECT * FROM Annonce";
		Connection conn = MysqljdbcDAO.mySQLgetConnection();
		PreparedStatement preparedStatement;
		ArrayList<AnnonceBean> annonceList = new ArrayList<AnnonceBean>();
		ResultSet result = null;
		try {
			preparedStatement = conn.prepareStatement(getRequest);
			result = InteractionsDAO.mySQLreadingQuery(MysqljdbcDAO.mySQLgetConnection(), preparedStatement);
			while(result.next()) {
				AnnonceBean annonce = new AnnonceBean();
				annonce.setId(result.getInt("id"));
				annonce.setAnnonceur(result.getString("annonceur"));
				annonce.setNom(result.getString("nom"));
				annonce.setTel(result.getString("telephone"));
				annonce.setAdresse(AdresseDAO.getAdresse(result.getInt("idAdresse")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (AnnonceBean[]) annonceList.toArray();
	}
	
	public static void updateAnnonceName(AnnonceBean annonce) {
		String addAnswer = "UPDATE annonce"
				  + "SET(annonceur ="+ annonce.getAnnonceur() + ","
				  			+"nom = "+ annonce.getNom()+","
				  		    +"telephone = "+ annonce.getTel() +","
				  			+"idAdresse = "+annonce.getAdresse().getId()
				  			+ " WHERE id = "+ annonce.getId() +")";
		int key = InteractionsDAO.mySQLwritingQuery(addAnswer);
	}

	public static AnnonceBean[] getAnnonces(int id) {
		String getRequest = "SELECT * FROM annonce a, compoCategorie cc"
							+ " Where cc.idAnnonce = a.id "
							+ " AND a.id = " + id;
		Connection conn = MysqljdbcDAO.mySQLgetConnection();
		PreparedStatement preparedStatement;
		ArrayList<AnnonceBean> annonceList = new ArrayList<AnnonceBean>();
		ResultSet result = null;
		try {
			preparedStatement = conn.prepareStatement(getRequest);
			result = InteractionsDAO.mySQLreadingQuery(MysqljdbcDAO.mySQLgetConnection(), preparedStatement);
			while(result.next()) {
				AnnonceBean annonce = new AnnonceBean();
				annonce.setId(result.getInt("id"));
				annonce.setAnnonceur(result.getString("annonceur"));
				annonce.setNom(result.getString("nom"));
				annonce.setTel(result.getString("telephone"));
				annonce.setAdresse(AdresseDAO.getAdresse(result.getInt("idAdresse")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (AnnonceBean[]) annonceList.toArray();	
	}
}
	
