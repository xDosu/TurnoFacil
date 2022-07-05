package Users;

/*
 * Clase a cargo de:
 * 
 * @author Alan Beguiristain y Matias Sorenson
 * 
 * @date 28/06/2022
 */

public abstract class User {
	private String user;
	private String password;
	
	public User(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}
	
	public String getUser() {return user;}

	public String getPassword() {return password;}
	
	public void setUser(String user) {this.user = user;}

	public void setPassword(String password) {this.password = password;}
	
	public abstract void printMenu();
}
