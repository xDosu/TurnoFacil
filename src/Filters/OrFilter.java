package Filters;

import Users.Medic;

public class OrFilter implements Filter{
	private Filter filter1;
	private Filter filter2;
	
	public OrFilter(Filter filter1, Filter filter2) {
		super();
		this.filter1 = filter1;
		this.filter2 = filter2;
	}
	
	@Override
	public boolean find(Medic medic) {
		return filter1.find(medic) & filter1.find(medic);
	}
}
