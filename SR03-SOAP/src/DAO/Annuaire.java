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

	
	public static void addAdresse(AdresseBean b) {
		String addAdresse = "INSERT INTO adresse(rue, ville, code_postal) VALUES("
							+"\""+b.getRue()+"\", "
							+"\""+b.getVille()+"\", "
							+"\""+b.getCodePostal()+"\")";
		Connection conn = null;
		Statement preparedStatement = null;
		ResultSet result = null;
		int key = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection( "jdbc:mysql://tuxa.sme.utc:3306/sr03p028", "root", "root" );
			preparedStatement = conn.createStatement();
			preparedStatement.executeUpdate(addAdresse, Statement.RETURN_GENERATED_KEYS);
			result = preparedStatement.getGeneratedKeys();
			if(result.next() && result != null){
				    key = result.getInt(1);
				}
		} 
		catch (Exception e ) {
		    /* Traiter les erreurs éventuelles ici. */
		} 
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static AdresseBean getAdresse(int idAdresse) {
		String getRequest = "SELECT * FROM adresse WHERE id = " + idAdresse;
		Connection conn = null;
		PreparedStatement preparedStatement;
		ResultSet result = null;
		AdresseBean adresse = new AdresseBean();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection( "jdbc:mysql://tuxa.sme.utc:3306/sr03p028", "sr03p028", "CSgwRyU5" );
			preparedStatement = conn.prepareStatement(getRequest);
			result = preparedStatement.executeQuery();
			while(result.next()) {
				adresse.setId(result.getInt("id"));
				adresse.setRue(result.getString("rue"));
				adresse.setVille(result.getString("ville"));
				adresse.setCodePostal(result.getInt("code_postal"));
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adresse;
	}
	public static void deleteAnnonce(int id) {
		java.sql.Connection Conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
            Conn = DriverManager.getConnection("jdbc:mysql://tuxa.sme.utc:3306/sr03p028", "sr03p028", "CSgwRyU5");
            java.sql.Statement Stmt = Conn.createStatement();
   
            String query = "DELETE FROM annonce WHERE id = '"+id+"'";
            Stmt.executeUpdate(query);             

            
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				Conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void addAnnonce(AnnonceBean a, CategorieBean b) {
		String addAnswer = "INSERT INTO annonce(annonceur, nom, telephone,details, idAdresse)"
						  + "VALUES(\"" + a.getAnnonceur() + "\","
						  			+"\""+ a.getNom() +"\","
						  		    +"\""+ a.getTel() +"\","
						  		    +"\""+ a.getDetails() +"\","
						  			+" \""+ a.getAdresse().getId() +"\")";
		Connection conn = null;
		Statement preparedStatement = null;
		ResultSet result = null;
		int key = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection( "jdbc:mysql://tuxa.sme.utc:3306/sr03p028", "root", "root" );
			preparedStatement = conn.createStatement();
			preparedStatement.executeUpdate(addAnswer, Statement.RETURN_GENERATED_KEYS);
			result = preparedStatement.getGeneratedKeys();
			if(result.next() && result != null){
				    key = result.getInt(1);
				}
		} 
		catch (Exception e ) {
		    /* Traiter les erreurs éventuelles ici. */
		} 
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String addCompoCateg = "INSERT INTO CompoCateg VALUES("
				+ b.getId() + "," 
				+ key + ")";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection( "jdbc:mysql://tuxa.sme.utc:3306/sr03p028", "root", "root" );
			preparedStatement = conn.createStatement();
			preparedStatement.executeUpdate(addCompoCateg, Statement.RETURN_GENERATED_KEYS);
			result = preparedStatement.getGeneratedKeys();
			if(result.next() && result != null){
				    key = result.getInt(1);
				}
		} 
		catch (Exception e ) {
		    /* Traiter les erreurs éventuelles ici. */
		} 
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	
	public static AnnonceBean[] getAnnonces() {
		String getRequest = "SELECT * FROM annonce";
		Connection conn = null; 
		PreparedStatement preparedStatement;
		ArrayList<AnnonceBean> annonceList = new ArrayList<AnnonceBean>();
		ResultSet result = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection( "jdbc:mysql://tuxa.sme.utc:3306/sr03p028", "sr03p028", "CSgwRyU5" );
			preparedStatement = conn.prepareStatement(getRequest);
			result = preparedStatement.executeQuery();
			while(result.next()) {
				AnnonceBean annonce = new AnnonceBean();
				annonce.setId(result.getInt("id"));
				annonce.setAnnonceur(result.getString("annonceur"));
				annonce.setNom(result.getString("nom"));
				annonce.setTel(result.getString("telephone"));
				annonce.setDetails(result.getString("details"));
				annonce.setAdresse(getAdresse(result.getInt("idAdresse")));
				annonceList.add(annonce);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AnnonceBean[] b;
		b =  (AnnonceBean[]) annonceList.toArray(new AnnonceBean[annonceList.size()]);
		return (b);	
	}
	
	public static void updateAnnonceName(AnnonceBean annonce) {
		String addAnswer = "UPDATE annonce"
				  + "SET(annonceur =\""+ annonce.getAnnonceur() + "\","
				  			+" nom =\""+ annonce.getNom()+"\","
				  		    +" telephone = \""+ annonce.getTel() +"\","
				  			+" idAdresse = "+annonce.getAdresse().getId() + ","
				  			+ " details = \"" + annonce.getDetails() + "\","
				  			+ " WHERE id = "+ annonce.getId() +")";
		Connection conn = null;
		Statement preparedStatement = null;
		ResultSet result = null;
		int key = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection( "jdbc:mysql://tuxa.sme.utc:3306/sr03p028", "root", "root" );
			preparedStatement = conn.createStatement();
			preparedStatement.executeUpdate(addAnswer, Statement.RETURN_GENERATED_KEYS);
			result = preparedStatement.getGeneratedKeys();
			if(result.next() && result != null){
				    key = result.getInt(1);
				}
		} 
		catch (Exception e ) {
		    /* Traiter les erreurs éventuelles ici. */
		} 
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static AnnonceBean[] getAnnoncesWithId(int id) {
		String getRequest = "SELECT * FROM annonce a, compoCategorie cc"
							+ " Where cc.idAnnonce = a.id "
							+ " AND a.id = " + id;
		Connection conn = null;
		PreparedStatement preparedStatement;
		ArrayList<AnnonceBean> annonceList = new ArrayList<AnnonceBean>();
		ResultSet result = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection( "jdbc:mysql://tuxa.sme.utc:3306/sr03p028", "sr03p028", "CSgwRyU5" );
			preparedStatement = conn.prepareStatement(getRequest);
			result = preparedStatement.executeQuery();
			while(result.next()) {
				AnnonceBean annonce = new AnnonceBean();
				annonce.setId(result.getInt("id"));
				annonce.setAnnonceur(result.getString("annonceur"));
				annonce.setNom(result.getString("nom"));
				annonce.setDetails(result.getString("details"));
				annonce.setTel(result.getString("telephone"));
				annonce.setAdresse(getAdresse(result.getInt("idAdresse")));
				annonceList.add(annonce);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AnnonceBean[] b;
		b =  (AnnonceBean[]) annonceList.toArray(new AnnonceBean[annonceList.size()]);
		return (b);	
	}
	
	public static AnnonceBean[] getAnnoncesWithIdCateg(int id) {
		String getRequest = "SELECT * FROM annonce a, compoCategorie cc"
							+ " Where cc.idAnnonce = a.id "
							+ " AND cc.idCategorie = " + id;
		Connection conn = null;
		PreparedStatement preparedStatement;
		ArrayList<AnnonceBean> annonceList = new ArrayList<AnnonceBean>();
		ResultSet result = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection( "jdbc:mysql://tuxa.sme.utc:3306/sr03p028", "sr03p028", "CSgwRyU5" );
			preparedStatement = conn.prepareStatement(getRequest);
			result = preparedStatement.executeQuery();
			while(result.next()) {
				AnnonceBean annonce = new AnnonceBean();
				annonce.setId(result.getInt("id"));
				annonce.setAnnonceur(result.getString("annonceur"));
				annonce.setNom(result.getString("nom"));
				annonce.setDetails(result.getString("details"));
				annonce.setTel(result.getString("telephone"));
				annonce.setAdresse(getAdresse(result.getInt("idAdresse")));
				annonceList.add(annonce);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AnnonceBean[] b;
		b =  (AnnonceBean[]) annonceList.toArray(new AnnonceBean[annonceList.size()]);
		return (b);	
	}
	
	public static void deleteCategorie(int id) {
		String rqt = "DELETE FROM categorie Where Id = " + id + ";" ;
		java.sql.Connection Conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://tuxa.sme.utc:3306/sr03p028";
			String login = "sr03p028";
			String passwd = "CSgwRyU5";
            Conn = DriverManager.getConnection(url, login, passwd);
            java.sql.Statement Stmt = Conn.createStatement();
            Stmt.executeUpdate(rqt); 
            
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				Conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void addCategorie(String nom) {
		java.sql.Connection Conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://tuxa.sme.utc:3306/sr03p028";
			String login = "sr03p028";
			String passwd = "CSgwRyU5";
            Conn = DriverManager.getConnection(url, login, passwd);
            java.sql.Statement Stmt = Conn.createStatement();
            String query = "INSERT INTO categorie (nom) VALUES('"+nom+"')";
            Stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				Conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static CategorieBean[] getCategories() {
		String getRequest = "SELECT * FROM categorie";
		Connection conn = null;
		PreparedStatement preparedStatement;
		ResultSet result = null;
		ArrayList<CategorieBean> categList = new ArrayList<CategorieBean>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection( "jdbc:mysql://tuxa.sme.utc:3306/sr03p028", "sr03p028", "CSgwRyU5" );
			preparedStatement = conn.prepareStatement(getRequest);
			result = preparedStatement.executeQuery();
			while(result.next()) {
				CategorieBean categ = new CategorieBean();
				categ.setId(result.getInt("id"));
				categ.setNom(result.getString("Nom"));
				categ.setAnonces(getAnnoncesWithIdCateg(categ.getId()));
				categList.add(categ);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CategorieBean[] b ;
		b =  (CategorieBean[]) categList.toArray(new CategorieBean[categList.size()]);
		return  b;
	}
	
	public static void updateCategorieName(int id, String newName) {
		String updateRequest = "UPDATE categorie SET nom='"+newName+"' WHERE id="+ id;
		Connection conn = null;
		Statement preparedStatement = null;
		ResultSet result = null;
		int key = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection( "jdbc:mysql://tuxa.sme.utc:3306/sr03p028", "root", "root" );
			preparedStatement = conn.createStatement();
			preparedStatement.executeUpdate(updateRequest, Statement.RETURN_GENERATED_KEYS);
			result = preparedStatement.getGeneratedKeys();
			if(result.next() && result != null){
				    key = result.getInt(1);
				}
		} 
		catch (Exception e ) {
		    /* Traiter les erreurs éventuelles ici. */
		} 
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
