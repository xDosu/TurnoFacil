package Filters;

import Users.Medic;

public class OrFilterMedic implements FilterMedic{
	private FilterMedic filter1;
	private FilterMedic filter2;
	
	public OrFilterMedic(FilterMedic filter1, FilterMedic filter2) {
		super();
		this.filter1 = filter1;
		this.filter2 = filter2;
	}
	
	@Override
	public boolean find(Medic medic) {
		return filter1.find(medic) & filter2.find(medic);
	}
}
