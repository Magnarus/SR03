package projectSR03.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBean {

	private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private boolean admin;
    private boolean state;

	public int getId() {	return id;	}
	public void setId(int id) {		this.id = id;	}
    
    public void setEmail(String email) { this.email = email; }
    public String getEmail() { return email; }

    public void setPassword(String password) { this.password = password; }
    public String getPassword() { return password; }

    public void setAdmin(boolean admin) { this.admin = admin; }
    public boolean isAdmin() { return admin; }
    
	public String getFirstName() {	return firstName; 	}
	public void setFirstName(String firstName) {this.firstName = firstName;	}
	
	public String getLastName() { return lastName;	}
	public void setLastName(String lastName) {	this.lastName = lastName;	}

	public boolean isState() {	return state;	}
	public void setState(boolean state) {	this.state = state;	}
	
	public static UserBean map(ResultSet result) throws SQLException{
		UserBean user = new UserBean();
		user.setId(result.getInt("Id"));
		user.setEmail(result.getString("Email"));
		user.setLastName(result.getString("Lastname"));
		user.setFirstName(result.getString("Firstname"));
		user.setPassword(result.getString("Password"));
		user.setAdmin(result.getBoolean("Role"));
		user.setState(result.getBoolean("State"));
		return user;
	}


}
