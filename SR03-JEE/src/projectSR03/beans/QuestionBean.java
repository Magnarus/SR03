package projectSR03.beans;

import java.util.ArrayList;

import projectSR03.utils.State;

public class QuestionBean {
	private int id;
	private String title;
	private ArrayList<AnswerBean> answers;
	private int rightAnswer;
	private boolean state;
	
	
	public int getId() {	return id;	}
	public void setId(int id) {		this.id = id;	}
	
	public String getTitle() {		return title;	}
	public void setTitle(String title) {	this.title = title;	}
	
	public ArrayList<AnswerBean> getAnswers() {	return answers;	}
	public void setAnswers(ArrayList<AnswerBean> answers) {	
		this.answers = answers;
	}
	public int getRightAnswer() {	return rightAnswer;	}
	public void setRightAnswer(int rightAnswer) {	this.rightAnswer = rightAnswer;	}
	
	
	public boolean getState() {	return state;	}
	public void setState(boolean state) {	this.state = state;	}
	
	public void addAnswer (AnswerBean ans) {
		answers.add(ans);
	}
	
	public void removeAnswer (AnswerBean ans) {
		answers.remove(ans);
	}
	
	
	
}