package Users;

import java.util.ArrayList;

import AppTurns.Turn;

public abstract class UserWithTurns extends User{
	private ArrayList<Turn> turns;

	public UserWithTurns(String user, String password) {
		super(user, password);
		turns = new ArrayList<Turn>();
	}
	
	public void addTurn(Turn t) {turns.add(t);}
	public void removeTurn(Turn t) {turns.remove(t);}
	public Turn getTurn(int index) {return turns.get(index);}

	public void listTurns() {
		String info = "";
		int i = 1;
		for (Turn t : turns) {
			info += i + t.toString() + "\n";
			i++;
		}
		System.out.println(info);
	}
	
	public ArrayList<Turn> getFreeTurns() {
		ArrayList<Turn> freeTurns = new ArrayList<Turn>();
		for (Turn t : turns) {
			if(t.isFree())
				freeTurns.add(t);
		}
		return freeTurns;
	}
}
