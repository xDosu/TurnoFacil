package Users;

import java.util.ArrayList;

/*
 * Clase a cargo de:
 * 
 * @author Esteban Boroni
 * 
 * @date 15/06/2022
 * 
 * 
 */

public class Medic extends UserWithTurns {
	private String name;
	private String surname;
	private String specialty;
	private ArrayList<String> prepaidsHealth;

	public Medic(String user, String password, String specialty, String name, String surname) {
		super(user, password);
		this.specialty = specialty;
		this.prepaidsHealth = new ArrayList<String>();
		this.name = name;
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void addPrepaid(String p) {
		prepaidsHealth.add(p);
	}

	public boolean containsPrepaid(String prepaid) {
		return prepaidsHealth.contains(prepaid);
	}

	@Override
	public void printMenu() {
		// Do something
	}

	@Override
	public String toString() {
		String out = name + " " + surname;
		return out;
	}
}
