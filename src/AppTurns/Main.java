package AppTurns;

import java.time.LocalDate;
import java.util.Scanner;

import Filters.*;
import Users.*;

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
		
		// Medico 1 - Daniel Suarez
		medico1.addTurn(new Turn(LocalDate.now(),medico1));
		medico1.addTurn(new Turn(LocalDate.now(),medico1));
		medico1.addTurn(new Turn(LocalDate.now(),medico1));
		// Medico 2 - Luis Contreras
		medico2.addTurn(new Turn(LocalDate.now(),medico1));
		medico2.addTurn(new Turn(LocalDate.now(),medico1));
		medico2.addTurn(new Turn(LocalDate.now(),medico1));
		// Medico 3 - Agustin Perazzi
		medico3.addTurn(new Turn(LocalDate.now(),medico1));
		medico3.addTurn(new Turn(LocalDate.now(),medico1));
		medico3.addTurn(new Turn(LocalDate.now(),medico1));
		// Medico 4 - Luis Suarez
		medico4.addTurn(new Turn(LocalDate.now(),medico1));
		medico4.addTurn(new Turn(LocalDate.now(),medico1));
		medico4.addTurn(new Turn(LocalDate.now(),medico1));
		// Medico 5 - Mauro Lombardo
		medico5.addTurn(new Turn(LocalDate.now(),medico1));
		medico5.addTurn(new Turn(LocalDate.now(),medico1));
		medico5.addTurn(new Turn(LocalDate.now(),medico1));
		// Medico 6 - Martin Michel
		medico6.addTurn(new Turn(LocalDate.now(),medico1));
		medico6.addTurn(new Turn(LocalDate.now(),medico1));
		medico6.addTurn(new Turn(LocalDate.now(),medico1));
						
		/* Login */
		Scanner reader = new Scanner(System.in);
		String user;
		String pass;
		System.out.println("LOGIN Clinica :");
		System.out.println("Usuario : ");
		user = reader.next();
		System.out.println("Contrasenia : ");
		pass = reader.next();
		
		clinica.login(user, pass);
		
		/* Debug */
	}
}
