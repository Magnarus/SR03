package projectSR03.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MysqljdbcDAO {

	// Obtenir une connexion à la base de données
	public static Connection mySQLgetConnection() {
		
		/* Chargement du driver JDBC pour MySQL */
		try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} 
		catch ( ClassNotFoundException e ) {
		    /* Gérer les éventuelles erreurs ici. */
		}
		
		/* Connexion à la base de données */
		String url = "jdbc:mysql://tuxa.sme.utc:3306/sr03p028";
		String user = "sr03p028";
		String password = "CSgwRyU5";
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

}
