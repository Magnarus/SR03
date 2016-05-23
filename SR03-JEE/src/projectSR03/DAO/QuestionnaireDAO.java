package projectSR03.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import projectSR03.beans.QuestionBean;
import projectSR03.beans.QuestionnaireBean;

public class QuestionnaireDAO {
	
	/**
	 * Fonction pour obtenir la liste des questionnaires présents en base
	 * @return ArrayList<QuestionnaireBean> contenant la liste des Questionnaires
	 */
	public static ArrayList<QuestionnaireBean> getQuestionnaires() {
		
		Connection conn = MysqljdbcDAO.mySQLgetConnection();
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		ArrayList<QuestionnaireBean> questionnaires =new ArrayList<QuestionnaireBean>();
		
		try {
			preparedStatement = conn.prepareStatement( "SELECT * FROM Questionnaire;" );
			
			result = InteractionsDAO.mySQLreadingQuery(conn, preparedStatement);

			while(result.next()) {
			   QuestionnaireBean questionnaire = new QuestionnaireBean();      
			   questionnaire.setId(result.getInt("Id"));
			   questionnaire.setName(result.getString("Name"));
			   questionnaire.setDateCreation(result.getDate("DateCreation"));
			   questionnaire.setState(result.getBoolean("State"));
			   questionnaire.setQuestions(QuestionnaireDAO.getQuestions(questionnaire.getId()));
			   questionnaires.add(questionnaire);
			}
			
		} 
		catch (SQLException e) {
			return null;
		}
		finally {
			MysqljdbcDAO.closeConnection(result, preparedStatement, conn);				
		}
		
		
		return questionnaires;
	}

	public static ArrayList<QuestionBean> getQuestions(int id) {
		ArrayList<QuestionBean> questions = new ArrayList<QuestionBean>();
		

		Connection conn = MysqljdbcDAO.mySQLgetConnection();
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {
			preparedStatement = conn.prepareStatement( "SELECT Id, Title, RightAnswer, State, OrderQuestion"
													+ " FROM Question q, CompoQuestionnaire cq"
													+ " WHERE cq.IdQuestion=q.Id"
													+ " AND cq.IdQuestionnaire= " + id
													+ " ORDER BY cq.OrderQuestion" + ";" );
			
			result = InteractionsDAO.mySQLreadingQuery(conn, preparedStatement);

			while(result.next()) {
			   QuestionBean question = new QuestionBean();      
			   question.setId(result.getInt(1));
			   question.setTitle(result.getString("Title"));
			   question.setRightAnswer(result.getInt("RightAnswer"));
			   question.setState(result.getBoolean("State"));
			   question.setOrder(result.getInt("OrderQuestion"));
			   question.setAnswers(QuestionDAO.getAnswers(question.getId()));
			   questions.add(question);
			}
			
		} 
		catch (SQLException e) {
			return null;
		}
		finally {
			MysqljdbcDAO.closeConnection(result, preparedStatement, conn);				
		}
		
		
		return questions;
	}

	public static void deleteQuestionnaire(String id) {
		InteractionsDAO.mySQLwritingQuery("DELETE FROM Questionnaire WHERE Id = \"" + id +"\"");
	}
	
	public static void addQuestionnaire(QuestionnaireBean q) {
		Connection conn = MysqljdbcDAO.mySQLgetConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = conn.prepareStatement("INSERT INTO sr03p028.Questionnaire(Name,DateCreation,Subject) VALUES(?, NOW(), ?)");
			statement.setString(1, q.getName());
			statement.setString(2, q.getSubject());
			statement.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<QuestionnaireBean> getQuestionnairesActif() {
		Connection conn = MysqljdbcDAO.mySQLgetConnection();
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		ArrayList<QuestionnaireBean> questionnaires =new ArrayList<QuestionnaireBean>();
		
		try {
			preparedStatement = conn.prepareStatement( "SELECT * FROM Questionnaire WHERE state = 1;" );
			
			result = InteractionsDAO.mySQLreadingQuery(conn, preparedStatement);

			while(result.next()) {
			   QuestionnaireBean questionnaire = new QuestionnaireBean();      
			   questionnaire.setId(result.getInt("Id"));
			   questionnaire.setName(result.getString("Name"));
			   questionnaire.setDateCreation(result.getDate("DateCreation"));
			   questionnaire.setState(result.getBoolean("State"));
			   questionnaire.setQuestions(QuestionnaireDAO.getQuestions(questionnaire.getId()));
			   questionnaires.add(questionnaire);
			}
			
		} 
		catch (SQLException e) {
			return null;
		}
		finally {
			MysqljdbcDAO.closeConnection(result, preparedStatement, conn);				
		}
		
		
		return questionnaires;
		
	}
	
	public static void setIsActif(String qId, String state) {
		InteractionsDAO.mySQLwritingQuery("UPDATE Questionnaire SET State='" + state + "' WHERE Id='" +qId + "'");
	}

	public static QuestionnaireBean getQuestionnaire(int id) {

		Connection conn = MysqljdbcDAO.mySQLgetConnection();
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		QuestionnaireBean questionnaire = new QuestionnaireBean();
		
		try {
			preparedStatement = conn.prepareStatement( "SELECT * FROM Questionnaire Where Id = " + id + ";" );
			
			result = InteractionsDAO.mySQLreadingQuery(conn, preparedStatement);

			while(result.next()) {    
			   questionnaire.setId(result.getInt("Id"));
			   questionnaire.setName(result.getString("Name"));
			   questionnaire.setDateCreation(result.getDate("DateCreation"));
			   questionnaire.setState(result.getBoolean("State"));
			   questionnaire.setQuestions(QuestionnaireDAO.getQuestions(questionnaire.getId()));
			}
			
		} 
		catch (SQLException e) {
			return null;
		}
		finally {
			MysqljdbcDAO.closeConnection(result, preparedStatement, conn);				
		}
		
		
		return questionnaire;
	}
}
