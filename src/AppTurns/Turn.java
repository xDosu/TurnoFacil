package AppTurns;

import java.time.LocalDate;
import Users.Medic;
import Users.Patient;

public class Turn {
	private LocalDate date;
	private Medic medic;
	private Patient patient;
	
	public Turn(LocalDate date, Medic medic) {
		super();
		this.date = date;
		this.medic = medic;
		this.patient = null;
	}

	public LocalDate getDate() {return date;}
	
	public boolean acceptPrepaid(String prepaidHealth) {
		return medic.acceptPrepaid(prepaidHealth);
	}
	
	public void asingPatient(Patient patient) {};
	
	public void erasePatient() {};
	
	public boolean isFree() {return false;};
	
	@Override
	public String toString() {
		return " Fecha : " + date.toString() + " | Medico : " + medic.getUser();
		
	}
	
	public boolean expire() {return false;}
}
