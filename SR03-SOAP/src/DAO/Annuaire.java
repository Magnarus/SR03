package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import beans.AdresseBean;
import beans.AnnonceBean;
import beans.CategorieBean;

public class Annuaire {
    
	// Obtenir une connexion à la base de données
	public static Connection mySQLgetConnection() {
		Properties properties = new Properties();
		String url = "jdbc:mysql://tuxa.sme.utc:3306/sr03p028";
        String user = "sr03p028";
        String password = "CSgwRyU5";
		/* Chargement du driver JDBC pour MySQL */
		try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} 
		catch ( ClassNotFoundException e ) {
		    /* Gérer les éventuelles erreurs ici. */
		}
        
        Connection conn = null;
		try {
		    conn = DriverManager.getConnection( url, user, password );
		} 
		catch ( SQLException e ) {
		    /* Gérer les éventuelles erreurs ici */
		}
		return conn;
	}
	
	/* Fermer un resultset */
	public static void closeResultSet( ResultSet resultSet ) {
	    if ( resultSet != null ) {
	        try {
	            resultSet.close();
	        } catch ( SQLException e ) {
	            System.out.println( "Échec de la fermeture du ResultSet : " + e.getMessage() );
	        }
	    }
	}

	/* Fermer un statement  */
	public static void closeStatement( Statement statement ) {
	    if ( statement != null ) {
	        try {
	            statement.close();
	        } catch ( SQLException e ) {
	            System.out.println( "Échec de la fermeture du Statement : " + e.getMessage() );
	        }
	    }
	}

	/* Fermer une connexion */
	public static void closeConnection( Connection conn ) {
	    if ( conn != null ) {
	        try {
	            conn.close();
	        } catch ( SQLException e ) {
	            System.out.println( "Échec de la fermeture de la connexion : " + e.getMessage() );
	        }
	    }
	}

	/* Fermer connexion avec statement  */
	public static void closeConnection( Statement statement, Connection conn ) {
	    closeStatement( statement );
	    closeConnection( conn );
	}

	/* Fermer connexion avec statement et resultset */
	public static void closeConnection( ResultSet resultSet, Statement statement, Connection conn ) {
	    closeResultSet( resultSet );
	    closeStatement( statement );
	    closeConnection( conn );
	}
	
public static int mySQLwritingQuery (String req) {
		
		Connection conn = null;
		Statement preparedStatement = null;
		ResultSet result = null;
		int key = 0;
		try {
			conn = mySQLgetConnection();
			preparedStatement = conn.createStatement();
        	System.out.println(req);
			preparedStatement.executeUpdate(req, Statement.RETURN_GENERATED_KEYS);
			result = preparedStatement.getGeneratedKeys();
			if(result.next() && result != null){
				    key = result.getInt(1);
				}
		} 
		catch ( SQLException e ) {
		    /* Traiter les erreurs éventuelles ici. */
		} 
		finally {
			closeConnection(result, preparedStatement, conn);	
		}
		return key;
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
	
	public static void addAdresse(AdresseBean b) {
		String addAdresse = "INSERT INTO adresse(rue, ville, code_postal) VALUES("
							+"\""+b.getRue()+"\", "
							+"\""+b.getVille()+"\", "
							+"\""+b.getCodePostal()+"\"";
	}
	
	public static AdresseBean getAdresse(int idAdresse) {
		String getRequest = "SELECT * FROM adresse WHERE id = " + idAdresse;
		Connection conn = mySQLgetConnection();
		PreparedStatement preparedStatement;
		ResultSet result = null;
		AdresseBean adresse = new AdresseBean();
		try {
			preparedStatement = conn.prepareStatement(getRequest);
			result = mySQLreadingQuery(mySQLgetConnection(), preparedStatement);
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
	public static void deleteAnnonce(int id) {
		mySQLwritingQuery("DELETE FROM annonce Where Id = " + id + ";" );
	}
	
	public static void addAnnonce(AnnonceBean a, CategorieBean b) {
		String addAnswer = "INSERT INTO annonce(annonceur, nom, telephone,details, idAdresse)"
						  + "VALUES(\"" + a.getAnnonceur() + "\","
						  			+"\""+ a.getNom() +"\","
						  		    +"\""+ a.getTel() +"\","
						  		    +"\""+ a.getDetails() +"\","
						  			+" \""+ a.getAdresse().getId() +"\")";
		int key = mySQLwritingQuery(addAnswer);
		String addCompoCateg = "INSERT INTO CompoCateg VALUES("
				+ b.getId() + "," 
				+ key + ")";
		mySQLwritingQuery(addCompoCateg);		
	}
	
	public static AnnonceBean[] getAnnonces() {
		String getRequest = "SELECT * FROM Annonce";
		Connection conn = mySQLgetConnection();
		PreparedStatement preparedStatement;
		ArrayList<AnnonceBean> annonceList = new ArrayList<AnnonceBean>();
		ResultSet result = null;
		try {
			preparedStatement = conn.prepareStatement(getRequest);
			result = mySQLreadingQuery(mySQLgetConnection(), preparedStatement);
			while(result.next()) {
				AnnonceBean annonce = new AnnonceBean();
				annonce.setId(result.getInt("id"));
				annonce.setAnnonceur(result.getString("annonceur"));
				annonce.setNom(result.getString("nom"));
				annonce.setTel(result.getString("telephone"));
				annonce.setDetails(result.getString("details"));
				annonce.setAdresse(getAdresse(result.getInt("idAdresse")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (AnnonceBean[]) annonceList.toArray();
	}
	
	public static void updateAnnonceName(AnnonceBean annonce) {
		String addAnswer = "UPDATE annonce"
				  + "SET(annonceur =\""+ annonce.getAnnonceur() + "\","
				  			+" nom =\""+ annonce.getNom()+"\","
				  		    +" telephone = \""+ annonce.getTel() +"\","
				  			+" idAdresse = "+annonce.getAdresse().getId() + ","
				  			+ " details = \"" + annonce.getDetails() + "\","
				  			+ " WHERE id = "+ annonce.getId() +")";
		int key = mySQLwritingQuery(addAnswer);
	}

	public static AnnonceBean[] getAnnonces(int id) {
		String getRequest = "SELECT * FROM annonce a, compoCategorie cc"
							+ " Where cc.idAnnonce = a.id "
							+ " AND a.id = " + id;
		Connection conn = mySQLgetConnection();
		PreparedStatement preparedStatement;
		ArrayList<AnnonceBean> annonceList = new ArrayList<AnnonceBean>();
		ResultSet result = null;
		try {
			preparedStatement = conn.prepareStatement(getRequest);
			result = mySQLreadingQuery(mySQLgetConnection(), preparedStatement);
			while(result.next()) {
				AnnonceBean annonce = new AnnonceBean();
				annonce.setId(result.getInt("id"));
				annonce.setAnnonceur(result.getString("annonceur"));
				annonce.setNom(result.getString("nom"));
				annonce.setDetails(result.getString("details"));
				annonce.setTel(result.getString("telephone"));
				annonce.setAdresse(getAdresse(result.getInt("idAdresse")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (AnnonceBean[]) annonceList.toArray();	
	}
	
	public static void deleteCategorie(int id) {
		mySQLwritingQuery("DELETE FROM categorie Where Id = " + id + ";" );
	}
	
	public static void addCategorie(String nom) {
		String addAnswer = "INSERT INTO categorie(nom) VALUES(\"" + nom + "\")";
		int key = mySQLwritingQuery(addAnswer);
	}
	
	public static CategorieBean[] getCategories() {
		String getRequest = "SELECT * FROM categorie";
		Connection conn = mySQLgetConnection();
		PreparedStatement preparedStatement;
		ResultSet result = null;
		ArrayList<CategorieBean> categList = new ArrayList<CategorieBean>();
		try {
			preparedStatement = conn.prepareStatement(getRequest);
			result = mySQLreadingQuery(mySQLgetConnection(), preparedStatement);
			while(result.next()) {
				CategorieBean categ = new CategorieBean();
				categ.setId(result.getInt("id"));
				categ.setNom(result.getString("Nom"));
				categ.setAnonces(getAnnonces(categ.getId()));
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
		mySQLwritingQuery(updateRequest);
	}
}
