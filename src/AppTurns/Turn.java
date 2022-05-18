package AppTurns;

import java.time.LocalDate;

public class Turn {
	private LocalDate date;
	private String prepaidHealth;
	
	
	public Turn(LocalDate date, String prepaidHealth) {
		super();
		this.date = date;
		this.prepaidHealth = prepaidHealth;
	}


	public LocalDate getDate() {return date;}
	public String getPrepaidHealth() {return prepaidHealth;}
	
	@Override
	public String toString() {
		return "";
	}
	
	public boolean expire() {return false;}
}
