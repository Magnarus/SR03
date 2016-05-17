package projectSR03.beans;

public class UserBean {

	private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private boolean admin;

	public int getId() {	return id;	}
	public void setId(int id) {		this.id = id;	}
    
    public void setEmail(String email) { this.email = email; }
    public String getEmail() { return email; }

    public void setPassword(String password) { this.password = password; }
    public String setPassword() { return password; }

    public void setAdmin(boolean admin) { this.admin = admin; }
    public boolean isAdmin() { return admin; }
    
	public String getFirstName() {	return firstName; 	}
	public void setFirstName(String firstName) {this.firstName = firstName;	}
	
	public String getLastName() { return lastName;	}
	public void setLastName(String lastName) {	this.lastName = lastName;	}


}
