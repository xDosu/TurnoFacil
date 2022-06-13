package AppTurns;

import java.time.LocalDateTime;

import Users.Medic;
import Users.Patient;
import Utilidad.FechaYHora;

public class Turn {
	private FechaYHora date;
	private Medic medic;
	private Patient patient;
	
	public Turn(FechaYHora date, Medic medic) {
		super();
		this.date = date;
		this.medic = medic;
		this.patient = null;
	}

	public FechaYHora getDate() {return date;}
		
	public void asingPatient(Patient patient) {this.patient = patient;};
	
	public void erasePatient() {patient = null;};
	
	public boolean isFree() {return (patient == null);};
	
	@Override
	public String toString() {
		return " Fecha : " + date.toString() + " | Medico : " + medic.toString() + " | Libre : " + isFree();	
	}
	
	public boolean expire() {
		LocalDateTime now = LocalDateTime.now();
		FechaYHora f = new FechaYHora(now.getYear(),now.getMonthValue(),now.getDayOfMonth(),now.getHour());
		return this.date.esMenor(f);

	}
}