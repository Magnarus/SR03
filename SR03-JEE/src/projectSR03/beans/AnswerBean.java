package projectSR03.beans;

import projectSR03.utils.State;

public class AnswerBean {
	private int id;
	private String value;
	private State state;
	
	
	public int getId() {	return id;	}
	public void setId(int id) {	this.id = id;	}
	
	public String getValue() {	return value;	}
	public void setValue(String value) {this.value = value;	}
	
	public State getState() {	return state;	}	
	public void setState(State state) {	this.state = state;	}	
	
	
}
