package fr.carbonIT.demo.chasseAuTresors.game.map;

import fr.carbonIT.demo.chasseAuTresors.game.person.Person;
import fr.carbonIT.demo.chasseAuTresors.game.type.Position2D;

public abstract class Cell {
	
	private Position2D position;
	private Person person;

	public abstract boolean isCrossable();
	
	protected Cell(Integer row, Integer column) {
		super();
		Position2D positionInfo = new Position2D(row, column);
		this.position = positionInfo;
	}

	public Position2D getPosition() {
		return this.position;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}

	public String renderCell() {
		return person == null ? toString() : person.toString();
	}
}
