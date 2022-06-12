package Filters;

import Users.Medic;

public class FilterPrepaid implements Filter{
	private String prepaid;
	
	public FilterPrepaid(String prepaid) {
		super();
		this.prepaid = prepaid;
	}

	@Override
	public boolean find(Medic medic) {
		return medic.containsPrepaid(prepaid);
	}
}
