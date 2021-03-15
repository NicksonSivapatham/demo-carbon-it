package fr.carbonIT.demo.chasseAuTresors.game.person;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import fr.carbonIT.demo.chasseAuTresors.game.person.Adventurer;
import fr.carbonIT.demo.chasseAuTresors.game.type.Movement;
import fr.carbonIT.demo.chasseAuTresors.game.type.Orientation;
import fr.carbonIT.demo.chasseAuTresors.game.type.Position2D;

 class AdventurerTest {
	private Adventurer adventurer;

	@Test
	 void rotateToTheRight() {
		Position2D position = new Position2D(1,1);
		Movement[] sequenceOfMovement = new Movement[] { Movement.A, Movement.G, Movement.A };
		adventurer = new Adventurer("Indiana", position, Orientation.NORD, sequenceOfMovement);
		Orientation futurOrientation;
		futurOrientation = adventurer.toTheRight();
		adventurer.setOrientation(futurOrientation);
	    assertThat(adventurer.getOrientation()).isEqualTo(Orientation.EST);
	}
	
	@Test
	 void rotateToTheRightFromWest() {
		Position2D position = new Position2D(1,1);
		Movement[] sequenceOfMovement = new Movement[] { Movement.A, Movement.G, Movement.A };
		adventurer = new Adventurer("Indiana", position, Orientation.OUEST, sequenceOfMovement);
		Orientation futurOrientation;
		futurOrientation = adventurer.toTheRight();
		adventurer.setOrientation(futurOrientation);
	    assertThat(adventurer.getOrientation()).isEqualTo(Orientation.NORD);
	}
	
	@Test
	 void rotateToTheLeft() {
		Position2D position = new Position2D(1,1);
		Movement[] sequenceOfMovement = new Movement[] { Movement.A, Movement.G, Movement.A };
		Orientation futurOrientation;
		adventurer = new Adventurer("Indiana", position, Orientation.SUD, sequenceOfMovement);
		futurOrientation = adventurer.toTheLeft();
		adventurer.setOrientation(futurOrientation);
	    assertThat(adventurer.getOrientation()).isEqualTo(Orientation.EST);
	}
	
	@Test
	 void rotateToTheLeftFromNorth() {
		Position2D position = new Position2D(1,1);
		Movement[] sequenceOfMovement = new Movement[] { Movement.A, Movement.G, Movement.A };
		Orientation futurOrientation;
		adventurer = new Adventurer("Indiana", position, Orientation.NORD, sequenceOfMovement);
		futurOrientation = adventurer.toTheLeft();
		adventurer.setOrientation(futurOrientation);
	    assertThat(adventurer.getOrientation()).isEqualTo(Orientation.OUEST);
	}
	
	@Test
	 void moveToNorth() {
		Position2D position = new Position2D(1,1);
		Movement[] sequenceOfMovement = new Movement[] { Movement.A, Movement.G, Movement.A };
		Adventurer adventurer = new Adventurer("Indiana", position, Orientation.NORD, sequenceOfMovement);
		Position2D futurPosition;
		
		//Move to the North
		futurPosition = adventurer.moveFoward();
		assertThat(futurPosition.getRow()).isZero();
		assertThat(futurPosition.getColumn()).isEqualTo(1);
		
	}
	
	@Test
	 void moveToWest() {
		Position2D position = new Position2D(1,1);
		Movement[] sequenceOfMovement = new Movement[] { Movement.A, Movement.G, Movement.A };
		Adventurer adventurer = new Adventurer("Indiana", position, Orientation.OUEST, sequenceOfMovement);
		Position2D futurPosition;
		
		//Move to the North
		futurPosition = adventurer.moveFoward();
		assertThat(futurPosition.getRow()).isEqualTo(1);
		assertThat(futurPosition.getColumn()).isZero();
		
	}
	
	@Test
	 void moveToSouth() {
		Position2D position = new Position2D(1,1);
		Movement[] sequenceOfMovement = new Movement[] { Movement.A, Movement.G, Movement.A };
		Adventurer adventurer = new Adventurer("Indiana", position, Orientation.SUD, sequenceOfMovement);
		Position2D futurPosition;
		
		//Move to the North
		futurPosition = adventurer.moveFoward();
		assertThat(futurPosition.getRow()).isEqualTo(2);
		assertThat(futurPosition.getColumn()).isEqualTo(1);
		
	}
	
	@Test
	 void moveToEst() {
		Position2D position = new Position2D(1,1);
		Movement[] sequenceOfMovement = new Movement[] { Movement.A, Movement.G, Movement.A };
		Adventurer adventurer = new Adventurer("Indiana", position, Orientation.EST, sequenceOfMovement);
		Position2D futurPosition;
		
		//Move to the North
		futurPosition = adventurer.moveFoward();
		assertThat(futurPosition.getRow()).isEqualTo(1);
		assertThat(futurPosition.getColumn()).isEqualTo(2);
		
	}
	
}
