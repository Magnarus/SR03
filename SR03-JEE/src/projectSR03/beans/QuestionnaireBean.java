package projectSR03.beans;

import java.util.ArrayList;

import projectSR03.utils.State;

public class QuestionnaireBean {
	private int id;
	private String name;
	private ArrayList<QuestionBean> questions;
	private State state;
	
	public int getId() { return id;	}
	public void setId(int id) {	this.id = id; }
	
	public String getName() {	return name;	}
	public void setName(String name) {		this.name = name;	}
	
	
	public ArrayList<QuestionBean> getQuestions() {	return questions;	}
	public void setQuestions(ArrayList<QuestionBean> questions) {	this.questions = questions;	}
	
	public State getState() {	return state;	}
	public void setState(State state) {	this.state = state;	}
	
	
	public void addQuestion(QuestionBean q) {
		questions.add(q);
	}
	
	public void removeQuestion(QuestionBean q) {
		questions.remove(q);
	}

	
	
}
