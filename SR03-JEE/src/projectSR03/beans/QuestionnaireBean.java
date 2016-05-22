package projectSR03.beans;

import java.sql.Date;
import java.util.ArrayList;

import projectSR03.utils.State;

public class QuestionnaireBean {
	private int id;
	private String name;
	private Date dateCreation;
	private ArrayList<QuestionBean> questions;
	private boolean state;
	private String subject;
	
	public int getId() { return id;	}
	public void setId(int id) {	this.id = id; }
	
	public String getName() {	return name;	}
	public void setName(String name) {		this.name = name;	}
	
	public Date getDateCreation() {	return dateCreation;	}
	public void setDateCreation(Date dateCreation) {	this.dateCreation = dateCreation;	}
	
	public ArrayList<QuestionBean> getQuestions() {	return questions;	}
	public void setQuestions(ArrayList<QuestionBean> questions) {	this.questions = questions;	}
	
	public boolean getState() {	return state;	}
	public void setState(boolean state) {	this.state = state;	}
	
	public String getSubject() { return subject; }
	public void setSubject(String subject) { this.subject = subject;}
	
	public void removeQuestion(QuestionBean q) {
		questions.remove(q);
	}
	public QuestionBean getQuestion(int currentQuestion) {
		for(QuestionBean q : questions) {
			if(q.getOrder() == currentQuestion) {
				return q;
			}
		}		
		return null;
	}


	
	
}
