package Users;

import java.util.ArrayList;

public class Medic extends UserWithTurns{
	private String name;
	private String surname;
	private String specialty;
	private ArrayList<String> prepaidsHealth;
	
	public Medic(String user, String password, String specialty, String name, String surname) {
		super(user, password);
		this.specialty = specialty;
		this.prepaidsHealth = null;
		this.name = name;
		this.surname = surname;
	}

	public String getName() {return name;}

	public String getSurname() {return surname;}

	public String getSpecialty() {return specialty;}
	
	public void addPrepaid(String p) {prepaidsHealth.add(p);}
	
	public boolean containsPrepaid(String prepaid) {return prepaidsHealth.contains(prepaid);}
	
	@Override
	public void printMenu() {
		//Do something
	}
	
	@Override
	public String toString() {
		String out = "Nombre : " + name + " " + surname;
		return out;
	}
}
