package fr.carbonIT.demo.chasseAuTresors.game.person;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.carbonIT.demo.chasseAuTresors.game.map.Cell;
import fr.carbonIT.demo.chasseAuTresors.game.map.element.Treasure;
import fr.carbonIT.demo.chasseAuTresors.game.type.Movement;
import fr.carbonIT.demo.chasseAuTresors.game.type.Orientation;
import fr.carbonIT.demo.chasseAuTresors.game.type.Position2D;

public class PersonTravelManager {
	
	private static Logger logger = LoggerFactory.getLogger(PersonTravelManager.class);
	
	private PersonTravelManager() {
	    throw new IllegalStateException("Utility class");
	}
	
	public static void moveAdventurerOnMap(Cell[][] gameMap, Adventurer adventurer, Movement movement) {
		Orientation futurOrientation;
		switch (movement) {
		case A:
			Cell actualPositionOnMap = getCellOfMap(gameMap, adventurer.getPosition());
			Position2D futurPosition = adventurer.moveFoward();
			if (futurPosition.getRow() < gameMap.length && futurPosition.getColumn() < gameMap[0].length 
				 && futurPosition.getColumn() >= 0 && futurPosition.getRow() >= 0) {
				Cell futurPositionOnMap = getCellOfMap(gameMap, futurPosition);
				if ( futurPositionOnMap.isCrossable() && futurPositionOnMap.getPerson() == null) {
					actualPositionOnMap.setPerson(null);
					futurPositionOnMap.setPerson(adventurer);
					adventurer.setPosition(futurPosition);
				if (futurPositionOnMap instanceof Treasure) {
					adventurer.retrieveTreasure((Treasure)futurPositionOnMap);
				}
				}
			}
			break;
		case G:
			futurOrientation = adventurer.toTheLeft();
			adventurer.setOrientation(futurOrientation);
			break;
		case D:
			futurOrientation = adventurer.toTheRight();
			adventurer.setOrientation(futurOrientation);
			break;
		default:
			logger.info("The move {} is not supported by the game.", movement);
			break;
		}
		
	}
	
	public static Cell getCellOfMap(Cell[][] gameMap, Position2D position) {
		return gameMap[position.getRow()][position.getColumn()];
	}
}
