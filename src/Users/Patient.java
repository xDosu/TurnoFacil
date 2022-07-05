package Users;

/*
 * Clase a cargo de:
 * 
 * @author Esteban Boroni y Alan Beguiristain
 * 
 * @date 18/06/2022
 * 
 */


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
	
	
	public void requestTurn(Turn turn) {
		if(turn.isFree()) {
			turn.asingPatient(this);
			super.addTurn(turn);
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
