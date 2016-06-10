package DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class MysqljdbcDAO {

	private static final String FICHIER_PROPERTIES       = "projectSR03/DAO/dao.properties";
    private static final String PROPERTY_URL             = "url";
    private static final String PROPERTY_DRIVER          = "driver";
    private static final String PROPERTY_NOM_UTILISATEUR = "user";
    private static final String PROPERTY_MOT_DE_PASSE    = "password";
    
	// Obtenir une connexion à la base de données
	public static Connection mySQLgetConnection() {
		Properties properties = new Properties();
		String url = null;
        String user = null;
        String password = null;
		/* Chargement du driver JDBC pour MySQL */
		try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} 
		catch ( ClassNotFoundException e ) {
		    /* Gérer les éventuelles erreurs ici. */
		}
		
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream fichierProperties = classLoader.getResourceAsStream( FICHIER_PROPERTIES );

        if ( fichierProperties == null ) {
            System.out.println( "Le fichier properties " + FICHIER_PROPERTIES + " est introuvable." );
        }

        try {
            properties.load( fichierProperties );
            url = properties.getProperty( PROPERTY_URL );
            user = properties.getProperty( PROPERTY_NOM_UTILISATEUR );
            password = properties.getProperty( PROPERTY_MOT_DE_PASSE );
        } catch ( FileNotFoundException e ) {
            System.out.println("Le fichiefsdfdsr properties " + FICHIER_PROPERTIES + " est introuvable.");
        } catch ( IOException e ) {
            System.out.println("Impossible de charger le fichier properties " + FICHIER_PROPERTIES);
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

}
