package projectSR03.beans;


import java.sql.Time;
import java.util.Date;
import java.util.HashMap;

public class RunBean {
	
	private int id;
	private UserBean user;
	private float score;
	private Date date;
	private Time duration;
	private HashMap<QuestionBean, AnswerBean> answers;
	private QuestionnaireBean quest;
	
	public int getId() {	return id;	}
	public void setId(int id) {	this.id = id;	}
	
	public UserBean getUser() {	return user;	}
	public void setUser(UserBean user) {	this.user = user;	}
	
	public float getScore() {		return score;	}
	public void setScore(float score) {		this.score = score;	}
	
	public Date getDate() {		return date;	}
	public void setDate(Date date) {	this.date = date;	}
	
	public Time getDuration() {	return duration;	}
	public void setDuration(Time duration) {	this.duration = duration;	}
	
	public HashMap<QuestionBean, AnswerBean> getAnswers() {	return answers;	}
	public void setAnswers(HashMap<QuestionBean, AnswerBean> answers) {	this.answers = answers;	}
	
	public QuestionnaireBean getQuest() {	return quest;	}
	public void setQuest(QuestionnaireBean quest) {	this.quest = quest;	}
	
	public void addAnswer(QuestionBean q, AnswerBean a) {
			answers.put(q, a);
	}
	
	public void removeAnswer(QuestionBean q){
		if(answers.containsKey(q)) {
			answers.remove(q);
		}
	}


}
