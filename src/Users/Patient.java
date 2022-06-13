package Users;

import AppTurns.Turn;

public class Patient extends UserWithTurns{

	
	public Patient(String user, String password) {super(user, password);}
	
	/*
	Este metodo asigna un paciente a un turno para poder ocuparlo.
	Luego lo anade a su lista de turnos personales.
	@author Tomas Fernandez
	@date 23/05/2022
	@params Turn : Recibe un turno como parametro
	*/
	public void requestTurn(Turn turn) {
		if(turn.isFree()) {
			turn.asingPatient(this);
			super.addTurn(turn);
		}
	}
	
	/*
	Este metodo cancela el turno de un paciente.
	Lo elimina de su lista de turnos, para por ultimo devolverlo para actualizarlo en el objecto 'Clinic'.
	@author Tomas Fernandez
	@date 23/05/2022
	@params Turn : Recibe un turno como parametro
	*/
	
	public void cancelTurn(Turn turn) {
		if(turn != null) {
			turn.erasePatient();
			this.removeTurn(turn);
		}
	}
		
	@Override
	public String toString() {
		return "";
	}

	
	
	
	@Override
	public void printMenu() {
		System.out.println( "Menu Clinica		User : " + this.getUser() + "\n" +
				"1. Sacar turno" + "\n" +
				"2. Cancelar turno" + "\n" +
				"3. Mostrar mis turnos" + "\n" + 
				"0. Cerrar sesion" + "\n" + 
				"Eliga una opcion : ");
	}
}
