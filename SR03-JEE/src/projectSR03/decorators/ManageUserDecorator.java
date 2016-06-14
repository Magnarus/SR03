package projectSR03.decorators;

import org.displaytag.decorator.TableDecorator;

import projectSR03.beans.UserBean;

public class ManageUserDecorator extends TableDecorator {

	public String getAdmin() {
		UserBean user = (UserBean)getCurrentRowObject();
		if(user.isAdmin()) {
			return "<input type=\"checkbox\" name=\"isAdmin\" disabled=\"disabled\" checked=\"checked\"/>";
		} else return "<input type=\"checkbox\" name=\"isAdmin\" disabled=\"disabled\"/>";
	}
	
	public String getState() {
		UserBean user = (UserBean)getCurrentRowObject();
		if(user.isState()) {
			return "<input type=\"checkbox\" name=\"stateUser\" disabled=\"disabled\" checked=\"checked\"/>";
		} else return "<input type=\"checkbox\" name=\"stateUser\" disabled=\"disabled\"/>";
	}
}
