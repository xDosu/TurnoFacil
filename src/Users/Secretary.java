package Users;

import java.util.ArrayList;

public class Secretary extends User{

	private ArrayList<Medic> medics = new ArrayList<Medic>();
	
	public Secretary(String user, String password) {super(user, password);}
		
	public void cancelTurn() {};
	public void editTurn() {};
	public void listTurns() {}

	@Override
	public void printMenu() {
		// TODO Auto-generated method stub
	};
}
