package AppTurns;

import java.util.ArrayList;
import java.util.Scanner;

import Filters.*;
import Users.*;

public class Clinic {
	private ArrayList<User> users;
	private Admin admin;
	
	public Clinic(Admin admin) {
		super();
		this.admin = admin;
		this.users = new ArrayList<>();
	}
	
	public void addUser(User user) {users.add(user);}
		
	/*
	Este metodo comprueba si las credenciales ingresadas son correctas para algun usuario.
	@author Tomas Fernandez
	@date 23/05/2022
	@params user & password : Recibe las credenciales mediante dos strings.
	*/
	
	public void login(String user, String password) {
		User session = null;
		for(User u : users ) {
			if((u.getUser().equals(user)) & (u.getPassword().equals(password))) {
				session = u;
				break;
			}
		}
		if(session != null) 
			openSession(session);
		else
			System.out.println("Credenciales incorrectas");
	}
	
	public void openSession(User session) {
		Scanner reader = new Scanner(System.in);
		int option = -1;
		while (session != null) {
			session.printMenu();
			option = reader.nextInt();
			switch(option) {
			case 1 : // Sacar turno
				
			case 2 : // Cancelar turno
			
			case 3 : // Mostrar mis turnos
				((UserWithTurns) session).listTurns();
			case 0 : // Cerrar sesion
				session = null;
				break;
			}
			System.out.println("----------------------------");
		}
	}
	
	public ArrayList<Medic> getMedics(){
		ArrayList<Medic> medics = new ArrayList<Medic>();
		for(User u : users) {
			if(u instanceof Medic)
				medics.add((Medic) u);
		}
		return medics;
	}
	
	public ArrayList<Medic> findMedics(Filter filter) {
		ArrayList<Medic> medicsFiltered = new ArrayList<Medic>();
		for(Medic m : getMedics()) {
			if(filter.find(m))
				medicsFiltered.add(m);
		}
		return medicsFiltered;
	}
}