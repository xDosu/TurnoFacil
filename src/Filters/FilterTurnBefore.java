package Filters;

import AppTurns.Turn;

public class FilterTurnBefore implements FilterTurn{
	private double hour;
	
	public FilterTurnBefore(double hour) {
		super();
		this.hour = hour;
	}

	@Override
	public boolean find(Turn t) {
		return t.getDate().getHora() < hour;
	}
}
