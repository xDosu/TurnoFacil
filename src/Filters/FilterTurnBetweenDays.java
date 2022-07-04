package Filters;

import AppTurns.Turn;

public class FilterTurnBetweenDays implements FilterTurn{
	private int day1;
	private int day2;
	
	public FilterTurnBetweenDays(int day1, int day2) {
		super();
		this.day1 = day1;
		this.day2 = day2;
	}

	@Override
	public boolean find(Turn t) {
		return (t.getDate().getDia() >= day1 && t.getDate().getDia() <= day2);
	}
}
