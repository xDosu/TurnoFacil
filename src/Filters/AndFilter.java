package Filters;

import Users.Medic;

public class AndFilter implements Filter{
	private Filter filter1;
	private Filter filter2;
	
	public AndFilter(Filter filter1, Filter filter2) {
		super();
		this.filter1 = filter1;
		this.filter2 = filter2;
	}

	@Override
	public boolean find(Medic medic) {
		return filter1.find(medic) & filter1.find(medic);
	}
}
