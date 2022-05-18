package Users;

import java.util.ArrayList;

import AppTurns.Turn;

public class UserWithTurns extends User{
	
	private ArrayList<Turn> turns;
	private ArrayList<String> prepaidsHealth;

	public UserWithTurns(String user, String password) {super(user, password);}

	@Override
	public void login() {
		
	}
	
	public void addTurn(Turn t) {turns.add(t);}
	public void addPrepaid(String p) {prepaidsHealth.add(p);}
	
	public void listTurns() {
	}
}
