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

	public void addUser(User user) {
		users.add(user);
	}

	/*
	 * Este metodo comprueba si las credenciales ingresadas son correctas para algun
	 * usuario.
	 * 
	 * @author Tomas Fernandez
	 * 
	 * @date 23/05/2022
	 * 
	 * @params user & password : Recibe las credenciales mediante dos strings.
	 */

	public void login(String user, String password) {
		User session = null;
		for (User u : users) {
			if ((u.getUser().equals(user)) & (u.getPassword().equals(password))) {
				session = u;
				break;
			}
		}
		if (session != null)
			openSession(session);
		else
			System.out.println("Credenciales incorrectas");
	}

	/*
	 * Permite solcitar un turno por un paciente dandole diferentes funcionalidades previas
	 * 
	 * @author Esteban Boroni
	 * 
	 * @date 8/06/2022
	 * 
	 * @params patient : recibe el paciente el cual requiere turno
	 */
	
	
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
		switch (option) {
		case 1: // Caso 1 "Mostrar Lista de médicos"
			System.out.println("Lista de Medicos");
			medic = chooseMedic(this.getMedics());
			break;
		case 2: // Caso 2 "Mostrar Lista de médicos por obra social
			System.out.println("Ingrese su obra social : ");
			medic = chooseMedic((this.findMedics(new FilterPrepaid(reader.next()))));
			break;
		case 3: // Caso 3 "Mostrar Lista de médicos por especialidad
			System.out.println("Ingrese la especialidad del medico : ");
			medic = chooseMedic(this.findMedics(new FilterSpecialty(reader.next())));
			break;
		}

		if (medic != null) {
			turn = chooseTurn(medic);
			if (turn != null)
				patient.requestTurn(turn);
		} else
			System.out.println("No se selecciono una opcion valida");
		//;
	}
	/*
	 * Permite seleccionar un medico de todos los que se encuentran en la clinica
	 * 
	 * @author Esteban Boroni
	 * 
	 * @date 2/06/2022
	 * 
	 * @parameters medics: Medicos a buscarse 
	 */
	private Medic chooseMedic(ArrayList<Medic> medics) {
		String out = "";
		Scanner reader = new Scanner(System.in);
		int i = 0;
		for (Medic m : medics) {
			i++;
			out += i + ". " + m.toString() + "\n";
		}
		System.out.println(out);
		System.out.println("Ingrese una opcion : ");
		int option = reader.nextInt();
		//;
		if (option >= 1 & option <= medics.size())
			return medics.get(option - 1);
		return null;
	}
	/*
	 * Permite selecionar un turno de los que tiene un usuario
	 * 
	 * @author MatiasSorenson
	 * 
	 * @date 2/06/2022
	 * 
	 * @parameters user: Usuario que elegira un turno
	 */
	private Turn chooseTurn(UserWithTurns user) {
		String out = "";
		Scanner reader = new Scanner(System.in);
		int i = 0;
		if(!user.searchTurns(new FilterTurnFree()).isEmpty()) {
			for (Turn t : user.searchTurns(new FilterTurnFree())) {
				i++;
				out += i + ". " + t.toString() + "\n";
			}
			System.out.println(out);
			System.out.println("Ingrese una opcion : ");
			int option = reader.nextInt();
			//;
			if (option >= 1 & option <= user.searchTurns(new FilterTurnFree()).size()) {
				return user.searchTurns(new FilterTurnFree()).get(option - 1);
			}
		}else 
			System.out.println("No hay turnos disponibles");
		return null;
	}
	
	/*
	 * Permite cancelar un turno de los que tiene un usuario
	 * 
	 * @author Francisco Aristegui
	 * 
	 * @date 01/06/2022
	 * 
	 * @parameters session: Usuario que cancelara un turn
	 */

	private void cancelTurn(User session) {
		((UserWithTurns) session).listTurns();
		System.out.println("Elija un turno para cancelar");
		Scanner reader2 = new Scanner(System.in);
		int turn = reader2.nextInt();
		System.out.println(turn);

		LocalDateTime now = LocalDateTime.now();

		if (((UserWithTurns) session).haveTurns()) {
			Turn aux = ((UserWithTurns) session).getTurn(turn - 1);
			int Diferencia = aux.getDate().getHora() - now.getHour();
			if (aux.getDate().getDia() > now.getDayOfMonth() && aux.getDate().getMes() >= now.getMonthValue() && aux.getDate().getAnio() >= now.getYear()) 
				aux.erasePatient();
			else if(Diferencia > 1) {
				aux.erasePatient();
			}
			else
				System.out.println("Falta menos de una hora para tu turno, ya no puedes cancelar");
		}
	}
	
	/* Opciones menu Secretaria */
	
	/*
	 * Permite seleccionar un medico de los que tiene una secretaria
	 * 
	 * @author Alan Beguiristain
	 * 
	 * @date 30/06/2022
	 * 
	 * @parameters s : secretaria que seleccionara un medico
	 */
	
	private Medic selectMedic(Secretary s) {
		s.showMedics();
		Scanner reader = new Scanner(System.in);
		System.out.println("Elija un medico : ");
		int option = reader.nextInt();
		if(option >= 1 && option <= s.getSizeMedics()) return s.getMedic(option - 1);
		return null;
	}
	
	/*
	 * Permite seleccionar un turno de los que tiene un medico
	 * 
	 * @author Alan Beguiristain
	 * 
	 * @date 28/06/2022
	 * 
	 * @parameters s: Secretaria q selecciona un turno, t: filtro utilizado
	 */
	private ArrayList<Turn> selectMedicTurns(Secretary s, FilterTurn t) {
		Medic m = selectMedic(s);
		if(m != null)	return m.searchTurns(t);
		return null;
	}
	
	
	/*
	 * Imprime turnos segun un filtro
	 * 
	 * @author Francisco Aristegui
	 * 
	 * @date 26/06/2022
	 * 
	 * @parameters f: filtro, s: Secretaria que selleccionara turno de medico
	 */
	
	private void printFilterTurns(FilterTurn f,Secretary s){
		ArrayList<Turn> filterTurns = new ArrayList<Turn>();
		ArrayList<Turn> turns = selectMedicTurns(s, new FilterTurnBefore(25));
		if(turns.size()  > 0) {
			for(Turn t : turns) {
				if(f.find(t))
					filterTurns.add(t);
			}
		}
		System.out.println(filterTurns.toString());
	}
	
	/*
	 * Lista los turnos de un medico segun diferentes criterios
	 * 
	 * @author Tomas Fernandez
	 * 
	 * @date 27/06/2022
	 * 
	 * @parameters s: Secretaria que listara turnos de alguno de sus medicos
	 */
	
	private void listTurnsOption(Secretary s) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Menu Listar Turnos Medicos : ");
		System.out.println("1. Listar por turno manana");
		System.out.println("2. Listar por turno tarde");
		System.out.println("3. Listar todos los turnos");
		System.out.println("4. Listar por rango de dias");
		System.out.println("0. Volver");
		int option = reader.nextInt();
		int aux1,aux2;
		switch (option) {
		case 1:
			printFilterTurns(new FilterTurnBefore(13),s);
			break;
		case 2: 
			printFilterTurns(new NotFilterTurn(new FilterTurnBefore(13)),s);
			break;
		case 3:
			printFilterTurns(new FilterTurnBefore(25),s);
			break;
		case 4: 
			System.out.println("A partir del dia : ");
			aux1 = reader.nextInt();
			System.out.println("Hasta el dia : ");
			aux2 = reader.nextInt();
			printFilterTurns(new FilterTurnBetweenDays(aux1,aux2),s);
			break;
		case 0:
			break;
		}
	}
	
	
	/* 
	 * Permite cancelar un turno de un medico asignado a una secretaria 
	 * 
	 * @author Matias Sorenson
	 * 
	 * @date 30/06/2022
	 * 
	 * @parameters s: Secretaria que cancelara un turno
	 */
	
	private void cancelTurnMedic(Secretary s) {
		System.out.println("Menu Cancelar turno : ");
		Medic m = selectMedic(s);
		if(m != null) s.cancelTurn(m);
	}
	
	/*
	 * Permite editar un turno de un medico asignado a una secretaria
	 * 
	 * @author Matias Sorenson
	 * 
	 * @date 2/07/2022
	 * 
	 * @parameters s: Secretaria que modificiara un turno
	 */
	
	private void editTurnMedic(Secretary s) {
		System.out.println("Menu Editar turno : ");
		Medic m = selectMedic(s);
		if(m != null) {s.editTurn(m);} 
	}
	
	/*
	 * Abre sesion para un usuario
	 * 
	 * @author Alan Beguiristain
	 * 
	 * @date 23/05/2022
	 * 
	 * @parameters session: usuario que se logueara
	 */

	private void openSession(User session) {
		Scanner reader = new Scanner(System.in);
		int option = -1;
		while (session != null) {
			session.printMenu();
			option = reader.nextInt();
			if(session instanceof Patient) { /* Menu para un Paciente */
				switch (option) {
				case 1: // Sacar turno
					if(!((Patient) session).cargoDatosPersonales()) {
						((Patient) session).cargarDatos();
					}
					requestTurnOption((Patient) session);
					break;
				case 2: // Cancelar turno
					if (((UserWithTurns) session).haveTurns())
						cancelTurn(session);
					else
						System.out.println("No tiene ningun turno el cual cancelar");
					break;
				case 3: // Mostrar mis turnos
					if (((UserWithTurns) session).haveTurns())
						((UserWithTurns) session).listTurns();
					else
						System.out.println("No tiene ningun turno el cual cancelar");
					break;
				case 0: // Cerrar sesion
					session = null;
					break;
				}
			}else if(session instanceof Secretary) { /* Menu para una Secretaria */
				switch (option) {
				case 1: // Listar turnos
					listTurnsOption((Secretary) session);
					break;
				case 2: // Cancelar turno
					cancelTurnMedic((Secretary) session);
					break;
				case 3: // Reagendar turno
					editTurnMedic((Secretary) session);
					break;
				case 4: // Mostrar medicos asignados
					((Secretary) session).showMedics();
					break;
				case 0: // Cerrar sesion
					session = null;
					break;
				}
			}
			System.out.println("----------------------------");
		}
	}

	/*
	 * Obtiene todos los medicos de los usuarios de la plataforma
	 * 
	 * @author Tomas Fernandez
	 * 
	 * @date 23/05/2022
	 * 
	 *
	 */
	
	private ArrayList<Medic> getMedics() {
		ArrayList<Medic> medics = new ArrayList<Medic>();
		for (User u : users) {
			if (u instanceof Medic)
				medics.add((Medic) u);
		}
		return medics;
	}
	
	/*
	 * Obtiene los medicos de los usuarios de la plataforma segun un filtro
	 * 
	 * @author Esteban Boroni
	 * 
	 * @date 24/05/2022
	 * 
	 *
	 */

	private ArrayList<Medic> findMedics(FilterMedic filterMedic) {
		ArrayList<Medic> medicsFiltered = new ArrayList<Medic>();
		for (Medic m : getMedics()) {
			if (filterMedic.find(m))
				medicsFiltered.add(m);
		}
		return medicsFiltered;
	}
}