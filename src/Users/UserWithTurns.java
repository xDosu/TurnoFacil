package Users;

/*
 * Clase a cargo de 
 * 
 * @author Matias Sorenson
 * 
 * @date 28/06/2022
 */
import java.util.ArrayList;
import AppTurns.Turn;
import Filters.FilterTurn;

public abstract class UserWithTurns extends User {
	private ArrayList<Turn> turns;

	public UserWithTurns(String user, String password) {
		super(user, password);
		turns = new ArrayList<Turn>();
	}

	public void addTurn(Turn t) {
		boolean encontre = false;
		if (!turns.isEmpty()) {
			int i = 0;
			while (i < turns.size() && !encontre)
				if (!turns.get(i).getDate().equals(t.getDate())) // verifica que toda fecha almacenada sea diferente a
																	// la por almacenar
					i++;
				else
					encontre = true;
		}

		if (!encontre)
			turns.add(t);
		
		turns.sort(null); //Ordena los turnos cronologicamente luego de cargarlos.
	}
	
	public void removeTurn(Turn t) {
		turns.remove(t);
	}

	public Turn getTurn(int index) {
		try {
			return turns.get(index);
		} catch (Exception e) {
			return null;
		}
	}

	public boolean haveTurns() {
		return !turns.isEmpty();
	}

	public void listTurns() {
		String info = "";
		int i = 1;
		for (Turn t : turns) {
			info += i + t.toString() + "\n";
			i++;
		}
		System.out.println(info);
	}

	public ArrayList<Turn> searchTurns(FilterTurn f) {
		ArrayList<Turn> filterTurns = new ArrayList<Turn>();
		for (Turn t : turns) {
			if(f.find(t))
				filterTurns.add(t);
		}
		return filterTurns;
	}
}
