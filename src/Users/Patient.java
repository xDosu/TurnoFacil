package Users;

import java.util.Scanner;

import AppTurns.Turn;

public class Patient extends UserWithTurns{
	private String nombre;
	private String apellido;
	private String telefono;
	private String email;
	private String obraSocial;
	private String nroAfiliado;
	
	
	public boolean cargoDatosPersonales() {
		return !(this.nombre ==null);
	}
	
	
	public void cargarDatos() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Ingrese Su Nombre");
		this.setNombre(reader.next());
		System.out.println("Ingrese Su Apellido");
		this.setApellido(reader.next());
		System.out.println("Ingrese Su Telefono");
		this.setTelefono(reader.next());
		System.out.println("Ingrese Su Email");
		this.setEmail(reader.next());
		System.out.println("Ingrese Su obraSocial");
		this.setObraSocial(reader.next());
		System.out.println("Ingrese Su nroAfiliado");
		this.setNroAfiliado(reader.next());
	}
	
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getObraSocial() {
		return obraSocial;
	}

	public void setObraSocial(String obraSocial) {
		this.obraSocial = obraSocial;
	}

	public String getNroAfiliado() {
		return nroAfiliado;
	}

	public void setNroAfiliado(String nroAfiliado) {
		this.nroAfiliado = nroAfiliado;
	}

	public Patient(String user, String password) {
		super(user, password);
		this.nombre = null;
	}
	
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
