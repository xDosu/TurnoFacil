package AppTurns;

import java.time.LocalDateTime;

import Users.Medic;
import Users.Patient;
import Utilidad.FechaYHora;

/*
 * Clase a cargo de:
 * 
 * @author Tomas Fernandez , Matias Sorenson
 * 
 * @date 24/05/2022
 * 
 *
 */
public class Turn implements Comparable<Turn>{
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
	
	public void erasePatient() {
		if(!isFree()) {
			patient.removeTurn(this);
			patient = null;			
		}
	};
	
	public boolean isFree() {return (patient == null);};
	
	@Override
	public String toString() {
		return " Fecha : " + date.toString() + " | Medico : " + medic.toString() + " | Libre : " + isFree();	
	}
	
	public int compareTo(Turn turn) {return this.date.compareTo(turn.getDate());}
	
	public boolean expire() {
		LocalDateTime now = LocalDateTime.now();
		FechaYHora f = new FechaYHora(now.getYear(),now.getMonthValue(),now.getDayOfMonth(),now.getHour());
		if (this.date.compareTo(f)<1) return true;
		else return false;
	}
	
	public void setDate(FechaYHora date) {this.date = date;}
}