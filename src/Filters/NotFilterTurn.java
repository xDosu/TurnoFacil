package Filters;

import AppTurns.Turn;

public class NotFilterTurn implements FilterTurn{
	private FilterTurn f;
	
	

	public NotFilterTurn(FilterTurn f) {
		super();
		this.f = f;
	}

	@Override
	public boolean find(Turn t) {
		return !f.find(t);
	}
}
