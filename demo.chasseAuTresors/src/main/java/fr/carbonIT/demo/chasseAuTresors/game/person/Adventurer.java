package fr.carbonIT.demo.chasseAuTresors.game.person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.carbonIT.demo.chasseAuTresors.game.map.element.Treasure;
import fr.carbonIT.demo.chasseAuTresors.game.movement.MoveFoward;
import fr.carbonIT.demo.chasseAuTresors.game.movement.Rotate;
import fr.carbonIT.demo.chasseAuTresors.game.type.Movement;
import fr.carbonIT.demo.chasseAuTresors.game.type.Orientation;
import fr.carbonIT.demo.chasseAuTresors.game.type.Position2D;

public class Adventurer extends Person implements Rotate, MoveFoward {
	
	Logger logger = LoggerFactory.getLogger(Adventurer.class);
	private Movement[] sequenceOfMouvement;
	private Integer numberOfTreasure;
	
	public Adventurer(String name, Position2D position, Orientation orientation, Movement[] sequenceOfMouvment) {
		super();
		this.name = name;
		this.position = position;
		this.orientation = orientation;
		this.sequenceOfMouvement = sequenceOfMouvment;
		this.numberOfTreasure = 0;
	}

	public Integer getNumberOfTreasure() {
		return numberOfTreasure;
	}

	@Override
	public String toString() {
		String pseudo = this.name.length() > 2 ? this.name.substring(0,2) + "." :this.name; 
		return "A(" + pseudo + ")";
	}

	public Movement[] getSequenceOfMouvement() {
		return sequenceOfMouvement;
	}

	@Override
	public Position2D moveFoward() {
		Integer currentColumn;
		Integer currentRow;
		Position2D futurPosition = null;
		switch (getOrientation()) {
		case NORD:
			currentColumn = getPosition().getColumn();
			currentRow = getPosition().getRow();
			futurPosition = new Position2D(currentRow - 1, currentColumn);
			break;
		case EST:
			currentColumn = getPosition().getColumn();
			currentRow = getPosition().getRow();
			futurPosition = new Position2D(currentRow, currentColumn + 1);
			break;
		case SUD:
			currentColumn = getPosition().getColumn();
			currentRow = getPosition().getRow();
			futurPosition = new Position2D(currentRow + 1, currentColumn);
			break;
		case OUEST:
			currentColumn = getPosition().getColumn();
			currentRow = getPosition().getRow();
			futurPosition = new Position2D(currentRow, currentColumn - 1);
			break;
		default:
			break;
		}	
		return futurPosition;
	}

	@Override
	public Orientation toTheLeft() {
		Integer nextOrientationsOrder = Math.floorMod(getOrientation().getOrder() - 1, 4);
		return Orientation.fromOrder(nextOrientationsOrder);
	}

	@Override
	public Orientation toTheRight() {
		Integer nextOrientationsOrder =  Math.floorMod(getOrientation().getOrder() + 1, 4);
		return Orientation.fromOrder(nextOrientationsOrder);
	}
	
	public Boolean retrieveTreasure(Treasure treasure) {
		boolean asFoundTreasure = treasure.extractTreasure();
		if (asFoundTreasure) {
			logger.info("{} as found a treasure !", getName());
			numberOfTreasure++;
		}
		return asFoundTreasure;		
	}
	
}
