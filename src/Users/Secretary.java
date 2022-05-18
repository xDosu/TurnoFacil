package Users;

import java.util.ArrayList;

public class Secretary extends User{

	private ArrayList<Medic> medics = new ArrayList<Medic>();
	
	public Secretary(String user, String password) {super(user, password);}
	
	@Override
	public void login() {
	}
	
	public void cancelTurn() {};
	public void editTurn() {};
	public void listTurns() {};
}
