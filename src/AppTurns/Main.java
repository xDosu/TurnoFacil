package AppTurns;

import java.util.Random;

import java.util.Scanner;



import Filters.*;
import Users.*;
import Utilidad.FechaYHora;

public class Main {

	public static void main(String[] args) {
		/* Creacion Clinicla */
		Clinic clinica = new Clinic(new Admin("juan","sat"));
		/* Creacion Pacientes */
		Patient paciente1 = new Patient("dosu","123");
		Patient paciente2 = new Patient("mat","456");
		Patient paciente3 = new Patient("pepe","123");
		
		clinica.addUser(paciente1);
		clinica.addUser(paciente2);
		clinica.addUser(paciente3);
		
		/* Creacion Medicos */
		Medic medico1 = new Medic("Dani","12","Neurocirujano","Daniel","Suarez");
		Medic medico2 = new Medic("Kali","tomas1","Neurocirujano","Luis","Contreras");
		
		Medic medico3 = new Medic("Linux","unix","Clinico","Agustin","Perazzi");
		Medic medico4 = new Medic("cristiano","ronaldo","Clinico","Luis","Suarez");
		
		Medic medico5 = new Medic("fran","yer","Otorrino","Mauro","Lombardo");
		Medic medico6 = new Medic("merge","git","Otorrino","Martin","Michel");
		
		clinica.addUser(medico1);
		clinica.addUser(medico2);
		clinica.addUser(medico3);
		clinica.addUser(medico4);
		clinica.addUser(medico5);
		clinica.addUser(medico6);
		
		/* Creacion Turnos */
		//Se crearan turnos al azar
		for (int i=0;i<24;i++) {
			int selectMed = (int)(Math.random()*(6-1+1)+1);
			int randH = (int)(Math.random()*(16-8+1)+8);
			int randD = 14;//(int)(Math.random()*(31-1+1)+1);
			switch(selectMed) {
			//randD = 13; //si se quiere dejar fijo
			case 1 : medico1.addTurn(new Turn(new FechaYHora(2022,06,randD,randH),medico1));
				break;
			case 2 : medico2.addTurn(new Turn(new FechaYHora(2022,06,randD,randH),medico2));
				break;
			case 3 : medico3.addTurn(new Turn(new FechaYHora(2022,06,randD,randH),medico3));
				break;
			case 4 : medico4.addTurn(new Turn(new FechaYHora(2022,06,randD,randH),medico4));
				break;
			case 5 : medico5.addTurn(new Turn(new FechaYHora(2022,06,randD,randH),medico5));
				break;
			case 6 : medico6.addTurn(new Turn(new FechaYHora(2022,06,randD,randH),medico6));
				break;
			}
		}/*
		// Medico 1 - Daniel Suarez
		medico1.addTurn(new Turn(new FechaYHora(2022,06,13,rand),medico1));
		medico1.addTurn(new Turn(LocalDate.now(),medico1));
		medico1.addTurn(new Turn(LocalDate.now(),medico1));
		// Medico 2 - Luis Contreras
		medico2.addTurn(new Turn(LocalDate.now(),medico2));
		medico2.addTurn(new Turn(LocalDate.now(),medico2));
		medico2.addTurn(new Turn(LocalDate.now(),medico2));
		// Medico 3 - Agustin Perazzi
		medico3.addTurn(new Turn(LocalDate.now(),medico3));
		medico3.addTurn(new Turn(LocalDate.now(),medico3));
		medico3.addTurn(new Turn(LocalDate.now(),medico3));
		// Medico 4 - Luis Suarez
		medico4.addTurn(new Turn(LocalDate.now(),medico4));
		medico4.addTurn(new Turn(LocalDate.now(),medico4));
		medico4.addTurn(new Turn(LocalDate.now(),medico4));
		// Medico 5 - Mauro Lombardo
		medico5.addTurn(new Turn(LocalDate.now(),medico5));
		medico5.addTurn(new Turn(LocalDate.now(),medico5));
		medico5.addTurn(new Turn(LocalDate.now(),medico5));
		// Medico 6 - Martin Michel
		medico6.addTurn(new Turn(LocalDate.now(),medico6));
		medico6.addTurn(new Turn(LocalDate.now(),medico6));
		medico6.addTurn(new Turn(LocalDate.now(),medico6));
						
		/* Login */
		Scanner reader = new Scanner(System.in);
		String user;
		String pass;
		System.out.println("LOGIN Clinica :");
		System.out.println("Usuario : ");
		user = reader.next();
		System.out.println("Contrasenia : ");
		pass = reader.next();
		ClearScreen();
		clinica.login(user, pass);
		
		/* Debug */
	}
	
	public static void ClearScreen() {
		for(int i=0;i<25;i++)
			System.out.println("");
	}
}
