package Users;

/*
 * Clase a cargo de:
 * 
 * @author Tomas Fernandez y Esteban Boroni 
 * 
 * @date 28/06/2022
 */


import java.util.ArrayList;
import java.util.Scanner;
import AppTurns.Turn;
import Filters.*;
import Utilidad.FechaYHora;

public class Secretary extends User {

	private ArrayList<Medic> medics = new ArrayList<Medic>();

	public Secretary(String user, String password) {
		super(user, password);
	}
	
	private Turn selectTurn(Medic medic) {
		Scanner reader = new Scanner(System.in);
		String info = "";
		int i = 0;
		ArrayList<Turn> turns = medic.searchTurns(new NotFilterTurn(new FilterTurnFree()));
		for(Turn t : turns) {
			i++;
			info += i + t.toString() + "\n";
		}
		if(!turns.isEmpty()) {
			System.out.println(info);
			int option = reader.nextInt();
			System.out.println("Elija un turno : ");
			if(option >= 1  && option <= turns.size()) return turns.get(option - 1);	
		}
		return null;
	}

	public void cancelTurn(Medic medic) {selectTurn(medic).erasePatient();};

	public void editTurn(Medic medic) {
		Scanner reader = new Scanner(System.in);
		Turn aux = selectTurn(medic);
		if(aux != null) {
			System.out.println("Ingrese un mes para el turno : ");
			int m = reader.nextInt();
			System.out.println("Ingrese un dia para el turno : ");
			int d = reader.nextInt();
			System.out.println("Ingrese un horario para el turno : ");
			int h = reader.nextInt();
			aux.setDate(new FechaYHora(2022,m,d,h));
		}
	};

	public void listTurns(int medic) {
		System.out.println("Lista de turnos : ");
		medics.get(medic).listTurns();
	}
	
	public Turn getTurn(int medic, int turn) {return medics.get(medic).getTurn(turn);}

	@Override
	public void printMenu() {
		System.out.println("Menu Clinica	Secretary : " + this.getUser() + "\n" + "1. Listar turnos" + "\n"
				+ "2. Cancelar turno" + "\n" + "3. Reagendar turno" + "\n" + "4. Ver medicos asignados" + "\n"
				+ "0. Cerrar sesion" + "\n" + "Eliga una opcion : ");
	};

	public void addMedic(Medic m) {medics.add(m);}

	public int getSizeMedics() {return medics.size();};

	public void showMedics() {
		String out = "";
		int i = 0;
		for (Medic m : medics) {
			i++;
			out += i + ". " + m.toString() + "\n";
		}
		System.out.println(out);
	}

	public void showTurnsMedic(int medic) {medics.get(medic).listTurns();}

	public ArrayList<Turn> searchTurnsMedic(int medic,FilterTurn f) {return medics.get(medic).searchTurns(f);}
	
	public Medic getMedic(int i) {return medics.get(i);}
}
