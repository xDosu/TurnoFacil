package Filters;

import AppTurns.Turn;

public class FilterTurnFree implements FilterTurn{

	@Override
	public boolean find(Turn t) {return t.isFree();}
}
