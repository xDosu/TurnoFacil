package Filters;

import Users.*;

public class FilterSpecialty implements FilterMedic{
	private String specialty;
	
	public FilterSpecialty(String specialty) {
		super();
		this.specialty = specialty;
	}

	@Override
	public boolean find(Medic medic) {
		return medic.getSpecialty().equals(specialty);
	}
}
