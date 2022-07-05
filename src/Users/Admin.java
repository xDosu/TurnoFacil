package Users;

/*
 * Clase a cargo de:
 * 
 * @author Francisco Aristegui
 * 
 * @date 24/05/2022
 * 
 *
 */

public class Admin extends User{

	public Admin(String user, String password) {super(user, password);}
	
	public void createUser() {};
	public void editUser() {};
	public void addSecretary() {}

	@Override
	public void printMenu() {
		// TODO Auto-generated method stub
	};
}
