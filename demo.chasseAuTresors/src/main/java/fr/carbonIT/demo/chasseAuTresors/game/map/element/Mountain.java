package fr.carbonIT.demo.chasseAuTresors.game.map.element;

import fr.carbonIT.demo.chasseAuTresors.game.map.Cell;

public class Mountain extends Cell{

	public Mountain(Integer row, Integer column) {
		super(row, column);
	}
	
	@Override
	public String toString() {
		return "M";
	}

	@Override
	public boolean isCrossable() {
		return false;
	}
}
