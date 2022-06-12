package Filters;

import Users.Medic;

public class FilterMedicSurname implements Filter{
	private String surname;
	

	public FilterMedicSurname(String surname) {
		super();
		this.surname = surname;
	}
	
	@Override
	public boolean find(Medic medic) {
		return medic.getSurname().equals(surname);
	}
}
