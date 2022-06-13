package AppTurns;

import java.time.LocalDateTime;
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
	
	private void requestTurnOption(Patient patient) {
		Scanner reader = new Scanner(System.in);
		Medic medic = null;
		Turn turn = null;
		System.out.println("Menu 'Sacar Turnos'");
		int option = -1;
		System.out.println("1) Mostrar todos los medicos");
		System.out.println("2) Filtrar por obra social");
		System.out.println("3) Filtrar por especialidad");
		option = reader.nextInt();
		switch(option) {
		case 1 : //Caso 1 "Mostrar Lista de médicos"
			System.out.println("Lista de Medicos");
			medic = chooseMedic(this.getMedics());
			break;
		case 2 : //Caso 2 "Mostrar Lista de médicos por obra social
			System.out.println("Ingrese su obra social : ");
			medic = chooseMedic((this.findMedics(new FilterPrepaid(reader.next()))));
			break;
		case 3 : //Caso 3 "Mostrar Lista de médicos por especialidad
			System.out.println("Ingrese la especialidad del medico : ");
			medic = chooseMedic(this.findMedics(new FilterSpecialty(reader.next())));
			break;
		}
		
		if(medic != null) {
			turn = chooseTurn(medic);
			if(turn != null)
				patient.requestTurn(turn);
			else
				System.out.println("No se selecciono una opcion valida");
		}else
			System.out.println("No se selecciono una opcion valida");
	}
	
	private Medic chooseMedic(ArrayList<Medic> medics) {
		String out = "";
		Scanner reader = new Scanner(System.in);
		int i = 0;
		for(Medic m : medics) {
			i++;
			out += i + ". " + m.toString() +"\n";
		}
		System.out.println(out);
		System.out.println("Ingrese una opcion : ");
		int option = reader.nextInt();
		if(option >= 1 & option <= medics.size())
			return medics.get(option - 1);
		return null;
	}
	
	private Turn chooseTurn(UserWithTurns user) {
		String out = "";
		Scanner reader = new Scanner(System.in);
		int i = 0;
		for(Turn t : user.getFreeTurns()) {
			i++;
			out += i + ". " + t.toString() + "\n";
		}
		System.out.println(out);
		System.out.println("Ingrese una opcion : ");
		int option = reader.nextInt();
		if(option >= 1 & option <= user.getFreeTurns().size()) {
			return user.getFreeTurns().get(option - 1);
		}
		return null;
	}
	
	private void cancelTurn(User session) {
		((UserWithTurns) session).listTurns();
		System.out.println("Elija un turno para cancelar");
		Scanner reader2 = new Scanner(System.in);
		int turn  = reader2.nextInt();
		System.out.println(turn);
		
		LocalDateTime now = LocalDateTime.now();
		
		if(((UserWithTurns) session).haveTurns()) {
			Turn aux = ((UserWithTurns) session).getTurn(turn-1);
			int Diferencia = aux.getDate().getHora() - now.getHour();  
				if(Diferencia > 1)
					((Patient) session).cancelTurn(aux);
				else 
					System.out.println("Falta menos de una hora para tu turno, ya no puedes cancelar");
		}
	}
	
	
	public void openSession(User session) {
		Scanner reader = new Scanner(System.in);
		int option = -1;
		while (session != null) {
			session.printMenu();
			option = reader.nextInt();
			switch(option) {
			case 1 : // Sacar turno
				requestTurnOption((Patient) session);
				break;
			case 2 : // Cancelar turno
				if( ((UserWithTurns)session).haveTurns() )
					cancelTurn(session);
				else
					System.out.println("No tiene ningun turno el cual cancelar");
				break;
			case 3 : // Mostrar mis turnos
				if( ((UserWithTurns)session).haveTurns() )
					((UserWithTurns) session).listTurns();
				else
					System.out.println("No tiene ningun turno el cual cancelar");
				break;
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