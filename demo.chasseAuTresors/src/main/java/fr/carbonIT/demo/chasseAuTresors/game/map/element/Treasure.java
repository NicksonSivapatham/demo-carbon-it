package fr.carbonIT.demo.chasseAuTresors.game.map.element;

import fr.carbonIT.demo.chasseAuTresors.game.map.Cell;

public class Treasure extends Cell{
	
	private Integer numberOfTreasure;
	
	public Treasure(Integer row, Integer column, Integer numberOfTreasure) {
		super(row, column);
		this.numberOfTreasure = numberOfTreasure;
	}

	public Integer getNumberOfTreasure() {
		return numberOfTreasure;
	}

	public void setNumberOfTreasure(Integer numberOfTreasure) {
		this.numberOfTreasure = numberOfTreasure;
	}

	@Override
	public String toString() {
		return "T(" + getNumberOfTreasure() + ")";
	}

	@Override
	public boolean isCrossable() {
		return true;
	}
	
	public Boolean extractTreasure() {
		if (getNumberOfTreasure() > 0) {
			setNumberOfTreasure(getNumberOfTreasure() - 1);
			return true;
		}
		return false;
	}
}
