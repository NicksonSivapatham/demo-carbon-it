package fr.carbonIT.demo.chasseAuTresors.game.map.element;

import fr.carbonIT.demo.chasseAuTresors.game.map.Cell;

public class Plain extends Cell{

	public Plain(Integer row, Integer column) {
		super(row, column);
	}

	@Override
	public String toString() {
		return ".    ";
	}

	@Override
	public boolean isCrossable() {
		return true;
	}

}
