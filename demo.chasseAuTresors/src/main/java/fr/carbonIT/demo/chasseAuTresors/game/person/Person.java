package fr.carbonIT.demo.chasseAuTresors.game.person;

import fr.carbonIT.demo.chasseAuTresors.game.type.Orientation;
import fr.carbonIT.demo.chasseAuTresors.game.type.Position2D;

public abstract class Person {
	protected String name;
	protected Position2D position;
	protected Orientation orientation;
	
	public String getName() {
		return name;
	}
	
	public Position2D getPosition() {
		return position;
	}
	
	public Orientation getOrientation() {
		return orientation;
	}
		
	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}	
	
	public void setPosition(Position2D position) {
		this.position = position;
	}	
}
