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
		System.out.println("Je delete les answers!");
		for(AnswerBean ans : question.getAnswers()) {
			InteractionsDAO.mySQLwritingQuery("DELETE FROM Answer Where Id = " + ans.getId() + ";" );
		}
	}
	
	public static void addQuestion(CompoQuestionnaireBean bean, String order) {
		String ajoutQuestion = "INSERT INTO sr03p028.Question(Title) VALUES(\""+ bean.getQuestion().getTitle() + "\")";
		int key = InteractionsDAO.mySQLwritingQuery(ajoutQuestion);
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

	public static ArrayList<AnswerBean> getAnswers(int id) {
		ArrayList<AnswerBean> answers = new ArrayList<AnswerBean>();
		

		Connection conn = MysqljdbcDAO.mySQLgetConnection();
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {
			preparedStatement = conn.prepareStatement( "SELECT a.Id, Value, State"
													+ " FROM Answer a, CompoQuestion cq"
													+ " WHERE cq.IdAnswer=a.Id"
													+ " AND cq.IdQuestion= " + id + ";" );
			System.out.println("SELECT Id, Value, State"
													+ " FROM Answer a, CompoQuestion cq"
													+ " WHERE cq.IdAnswer=a.Id"
													+ " AND cq.IdQuestion= " + id + ";");
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
	
}
