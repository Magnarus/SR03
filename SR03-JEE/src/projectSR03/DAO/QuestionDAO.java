package projectSR03.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import projectSR03.beans.AnswerBean;
import projectSR03.beans.CompoQuestionnaireBean;
import projectSR03.beans.QuestionBean;

public class QuestionDAO {
	
	public static void deleteAnswers(QuestionBean question) {
		for(AnswerBean ans : question.getAnswers()) {
			InteractionsDAO.mySQLwritingQuery("DELETE FROM Answer Where Id = " + ans.getId() + ";" );
		}
	}
	
	public static void addQuestion(CompoQuestionnaireBean bean) {
		String ajoutQuestion = "INSERT INTO sr03p028.Question(Title) VALUES(\""+ bean.getQuestion().getTitle() + "\")";
		int key = InteractionsDAO.mySQLwritingQuery(ajoutQuestion);
		int qId = Integer.parseInt(bean.getQuestionnaireId());
		String order = Integer.toString(QuestionnaireDAO.getQuestions(qId).size()+1);
		String ajoutCompo = "INSERT INTO sr03p028.CompoQuestionnaire VALUES(" + key + ","  + bean.getQuestionnaireId()+"," + order + ")";
		InteractionsDAO.mySQLwritingQuery(ajoutCompo);
		
	}

	public static void deleteQuestion(QuestionBean question) {
		InteractionsDAO.mySQLwritingQuery("DELETE FROM Question Where Id = " + question.getId() + ";" );
	}
	
	public static int getMaxCompoQuestionId() {
		Connection conn = MysqljdbcDAO.mySQLgetConnection();
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		int id = -1;
		try {
			preparedStatement = conn.prepareStatement("SELECT MAX(id) FROM CompoQuestion");
			result = InteractionsDAO.mySQLreadingQuery(conn, preparedStatement);
			if(result.next()) {
				id = result.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public static int getRightAnswer(String questionId) {
		Connection conn = MysqljdbcDAO.mySQLgetConnection();
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		int answerId = -1;
		try {
			preparedStatement = conn.prepareStatement("SELECT RightAnswer " 
													  + "FROM Question "
													  + "WHERE Id = " + questionId);
			result = InteractionsDAO.mySQLreadingQuery(conn, preparedStatement);
			if(result != null && result.next()) answerId = result.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return answerId;
	}
	
	public static void setRightAnswer(String qId, String aId) {
		InteractionsDAO.mySQLwritingQuery("UPDATE Question SET RightAnswer='"+aId+"' WHERE Id='"+qId+"'");
	}
	
	public static void setIsActif(String qId, String state) {
		InteractionsDAO.mySQLwritingQuery("UPDATE Question SET State='" + state + "' WHERE Id='" +qId + "'");
	}

	public static ArrayList<AnswerBean> getAnswers(int id) {
		ArrayList<AnswerBean> answers = new ArrayList<AnswerBean>();
		

		Connection conn = MysqljdbcDAO.mySQLgetConnection();
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try {
			preparedStatement = conn.prepareStatement( "SELECT a.Id, Value, State"
													+ " FROM Answer a, CompoQuestion cq"
													+ " WHERE cq.IdAnswer=a.Id"
													+ " AND cq.IdQuestion= " + id 
													+ " Order By OrderAnswer;" );
			result = InteractionsDAO.mySQLreadingQuery(conn, preparedStatement);

			while(result.next()) {
			   AnswerBean answer = new AnswerBean();      
			   answer.setId(result.getInt(1));
			   answer.setValue(result.getString("Value"));
			   answer.setState(result.getBoolean("State"));
			   answers.add(answer);
			}
			
		} 
		catch (SQLException e) {
			return null;
		}
		finally {
			MysqljdbcDAO.closeConnection(result, preparedStatement, conn);				
		}
		
		
		return answers;
	}
	
	public static void upQuestionOrder(String id) {
		int currentOrder = getQuestionOrder(id);
		String newOrder = Integer.toString(currentOrder-1);
		InteractionsDAO.mySQLwritingQuery("UPDATE CompoQuestionnaire"
										+" SET OrderQuestion='"+newOrder
									   +"' WHERE idQuestion='" + id + "'");
		
		//On descend celui qui était à cette place là
		String currentOrderString = Integer.toString(currentOrder);
		InteractionsDAO.mySQLwritingQuery("UPDATE CompoQuestionnaire"
										 +" SET OrderQuestion='"+currentOrderString
										+"' WHERE idQuestion<>'" + id + "'"
										 +" AND OrderQuestion = '"+newOrder+"'");
	}
	
	public static void downQuestionOrder(String id) {
		int currentOrder = getQuestionOrder(id);
		String newOrder = Integer.toString(currentOrder+1);
		InteractionsDAO.mySQLwritingQuery("UPDATE CompoQuestionnaire"
										+" SET OrderQuestion='"+newOrder
									   +"' WHERE idQuestion='" + id + "'");
		
		//On descend celui qui était à cette place là
		String currentOrderString = Integer.toString(currentOrder);
		InteractionsDAO.mySQLwritingQuery("UPDATE CompoQuestionnaire"
										 +" SET OrderQuestion='"+currentOrderString
										+"' WHERE idQuestion<>'" + id + "'"
										 +" AND OrderQuestion = '"+newOrder+"'");
	}
	
	private static int getQuestionOrder(String id) {
		Connection conn = MysqljdbcDAO.mySQLgetConnection();
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		int order = -1;
		try {
			preparedStatement = conn.prepareStatement("SELECT OrderQuestion"
													+ " FROM CompoQuestionnaire"
													+ " WHERE IdQuestion= " + id  + ";");
			result = InteractionsDAO.mySQLreadingQuery(conn, preparedStatement);
			if(result != null && result.next()) {
				order = result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}
	
}
