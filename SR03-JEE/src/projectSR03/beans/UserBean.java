package projectSR03.beans;

public class UserBean {

    private String email;
    private String password;
    private boolean admin;

    public void setEmail(String email) { this.email = email; }
    public String getEmail() { return email; }

    public void setPassword(String password) { this.password = password; }
    public String setPassword() { return password; }

    public void setAdmin(boolean admin) { this.admin = admin; }
    public boolean isAdmin() { return admin; }

}
