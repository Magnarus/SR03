package projectSR03.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import projectSR03.beans.AnswerBean;
import projectSR03.beans.CompoQuestionBean;

public class AnswerDAO {

	public static void deleteAnswer(AnswerBean a) {
		InteractionsDAO.mySQLwritingQuery("DELETE FROM Answer Where Id = " + a.getId() + ";" );
	}
	
	public static void addAnswer(CompoQuestionBean cqb) {
		String addAnswer = "INSERT INTO Answer(Value) VALUES(\"" + cqb.getAnswer().getValue() + "\")";
		int key = InteractionsDAO.mySQLwritingQuery(addAnswer);
		String addCompoQuestion;
		int order = QuestionDAO.getAnswers(Integer.parseInt(cqb.getQuestionId())).size()+1;
		String id = Integer.toString(QuestionDAO.getMaxCompoQuestionId()+1);
		addCompoQuestion = "INSERT INTO CompoQuestion VALUES("
							+cqb.getQuestionId()+ "," 
							+ key + ","
							+ id + ","
							+ order+1 + ")";
		InteractionsDAO.mySQLwritingQuery(addCompoQuestion);
	}
	
	public static void setIsActif(String aId, String state) {
		InteractionsDAO.mySQLwritingQuery("UPDATE Answer SET State='" + state + "' WHERE Id='" +aId + "'");
	}
	
	public static void upAnswerOrder(String id, String questionId) {
		int currentOrder = getAnswerOrder(id);
		String newOrder = Integer.toString(currentOrder-1);
		InteractionsDAO.mySQLwritingQuery("UPDATE CompoQuestion"
										+" SET OrderAnswer='"+newOrder
									   +"' WHERE idAnswer='" + id + "'");
		
		//On descend celui qui était à cette place là
		String currentOrderString = Integer.toString(currentOrder);
		InteractionsDAO.mySQLwritingQuery("UPDATE CompoQuestion"
										 +" SET OrderAnswer='"+currentOrderString
										+"' WHERE idAnswer<>'" + id + "'"
										 +" AND OrderAnswer = '"+newOrder+"'"
										 +" AND idQuestion = '"+questionId+"'");
	}
	
	public static void downAnswerOrder(String id, String questionId) {
		int currentOrder = getAnswerOrder(id);
		String newOrder = Integer.toString(currentOrder+1);
		InteractionsDAO.mySQLwritingQuery("UPDATE CompoQuestion"
										+" SET OrderAnswer='"+newOrder
									   +"' WHERE idAnswer='" + id + "'");
		
		//On descend celui qui était à cette place là
		String currentOrderString = Integer.toString(currentOrder);
		InteractionsDAO.mySQLwritingQuery("UPDATE CompoQuestion"
										 +" SET OrderAnswer='"+currentOrderString
										+"' WHERE idAnswer<>'" + id + "'"
										 +" AND OrderAnswer = '"+newOrder+"'"
										 +" AND idQuestion = '"+questionId+"'");
	}
	
	private static int getAnswerOrder(String id) {
		Connection conn = MysqljdbcDAO.mySQLgetConnection();
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		int order = -1;
		try {
			preparedStatement = conn.prepareStatement("SELECT OrderAnswer"
													+ " FROM CompoQuestion"
													+ " WHERE IdAnswer= " + id  + ";");
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
