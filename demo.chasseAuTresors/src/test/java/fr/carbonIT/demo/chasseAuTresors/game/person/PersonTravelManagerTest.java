package fr.carbonIT.demo.chasseAuTresors.game.person;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fr.carbonIT.demo.chasseAuTresors.exception.InitializationException;
import fr.carbonIT.demo.chasseAuTresors.game.map.element.Treasure;
import fr.carbonIT.demo.chasseAuTresors.game.map.service.impl.MadreDeDiosMap;
import fr.carbonIT.demo.chasseAuTresors.game.person.Adventurer;
import fr.carbonIT.demo.chasseAuTresors.game.person.PersonTravelManager;
import fr.carbonIT.demo.chasseAuTresors.game.type.Movement;
import fr.carbonIT.demo.chasseAuTresors.game.type.Orientation;
import fr.carbonIT.demo.chasseAuTresors.game.type.Position2D;

 class PersonTravelManagerTest {

	private static MadreDeDiosMap madreDeDios;
	private static Adventurer lara;
	
	static void initializeMap(List<String> infosGames) throws NumberFormatException, InitializationException { 
		madreDeDios = new MadreDeDiosMap(infosGames);
		madreDeDios.intitializeGameMap();
		lara = (Adventurer) madreDeDios.getListOfPersons().get(0);
	}

	@Test
	 void moveAdventurerToUpBorder() throws NumberFormatException, InitializationException {
		List<String> infosGames = List.of("# Carte", "C - 3 - 4", "# Montagne", "M - 1 - 0", "T - 2 - 2 - 1", "A - Lara - 0 - 0 - N - AADADAGGA");
		initializeMap(infosGames);
		PersonTravelManager.moveAdventurerOnMap(madreDeDios.getGameMap(), lara, Movement.A);
		
		Orientation expectedOrientation = Orientation.NORD;
		
		assertThat(lara.getPosition().getColumn()).isZero();
		assertThat(lara.getPosition().getRow()).isZero();
		assertThat(lara.getOrientation()).isEqualTo(expectedOrientation);
	}
	
	@Test
	 void moveAdventurerToLowBorder() throws NumberFormatException, InitializationException {
		List<String> infosGames = List.of("# Carte", "C - 3 - 4", "# Montagne", "M - 1 - 0", "T - 2 - 2 - 1", "A - Lara - 2 - 3 - S - AADADAGGA");
		initializeMap(infosGames);
		PersonTravelManager.moveAdventurerOnMap(madreDeDios.getGameMap(), lara, Movement.A);
		
		Orientation expectedOrientation = Orientation.SUD;
		
		assertThat(lara.getPosition().getRow()).isEqualTo(3);
		assertThat(lara.getPosition().getColumn()).isEqualTo(2);
		assertThat(lara.getOrientation()).isEqualTo(expectedOrientation);
	}
	
	@Test
	 void moveAdventurerToLeftBorder() throws NumberFormatException, InitializationException {
		List<String> infosGames = List.of("# Carte", "C - 3 - 4", "# Montagne", "M - 1 - 0", "T - 2 - 2 - 1", "A - Lara - 0 - 0 - O - AADADAGGA");
		initializeMap(infosGames);
		PersonTravelManager.moveAdventurerOnMap(madreDeDios.getGameMap(), lara, Movement.A);
		
		Orientation expectedOrientation = Orientation.OUEST;
		
		assertThat(lara.getPosition().getColumn()).isZero();
		assertThat(lara.getPosition().getRow()).isZero();
		assertThat(lara.getOrientation()).isEqualTo(expectedOrientation);
	}
	
	@Test
	 void moveAdventurerToRightBorder() throws NumberFormatException, InitializationException {
		List<String> infosGames = List.of("# Carte", "C - 3 - 4", "# Montagne", "M - 1 - 0", "T - 2 - 2 - 1", "A - Lara - 2 - 3 - E - AADADAGGA");
		initializeMap(infosGames);
		PersonTravelManager.moveAdventurerOnMap(madreDeDios.getGameMap(), lara, Movement.A);
		
		Orientation expectedOrientation = Orientation.EST;
		
		assertThat(lara.getPosition().getRow()).isEqualTo(3);
		assertThat(lara.getPosition().getColumn()).isEqualTo(2);
		assertThat(lara.getOrientation()).isEqualTo(expectedOrientation);
	}
	
	@Test
	 void moveAdventurerToMountain() throws NumberFormatException, InitializationException {
		List<String> infosGames = List.of("# Carte", "C - 3 - 4", "# Montagne", "M - 1 - 0", "T - 2 - 2 - 1", "A - Lara - 0 - 0 - E - AADADAGGA");
		initializeMap(infosGames);
		PersonTravelManager.moveAdventurerOnMap(madreDeDios.getGameMap(), lara, Movement.A);
		
		Orientation expectedOrientation = Orientation.EST;
		
		assertThat(lara.getPosition().getColumn()).isZero();
		assertThat(lara.getPosition().getRow()).isZero();
		assertThat(lara.getOrientation()).isEqualTo(expectedOrientation);
	}
	
	@Test
	 void moveAdventurerToOtherPerson() throws NumberFormatException, InitializationException {
		List<String> infosGames = List.of("# Carte", "C - 3 - 4", "A - Lara - 0 - 0 - E - AADADAGGA", "A - Indiana - 1 - 0 - E - AADADAGGA");
		initializeMap(infosGames);
		PersonTravelManager.moveAdventurerOnMap(madreDeDios.getGameMap(), lara, Movement.A);
		
		Orientation expectedOrientation = Orientation.EST;
		
		assertThat(lara.getPosition().getColumn()).isZero();
		assertThat(lara.getPosition().getRow()).isZero();
		assertThat(lara.getOrientation()).isEqualTo(expectedOrientation);
	}
	
	@Test
	void moveAdventurerForward() throws NumberFormatException, InitializationException {
		List<String> infosGames = List.of("# Carte", "C - 3 - 4", "A - Lara - 0 - 0 - E - AADADAGGA");
		initializeMap(infosGames);
		PersonTravelManager.moveAdventurerOnMap(madreDeDios.getGameMap(), lara, Movement.A);
		
		Orientation expectedOrientation = Orientation.EST;
		
		assertThat(lara.getPosition().getColumn()).isEqualTo(1);
		assertThat(lara.getPosition().getRow()).isZero();
		assertThat(lara.getOrientation()).isEqualTo(expectedOrientation);
	}
	
	@Test
	void moveAdventurerOnTreasure() throws NumberFormatException, InitializationException {
		List<String> infosGames = List.of("# Carte", "C - 3 - 4", "T - 2 - 2 - 3", "A - Lara - 1 - 2 - E - AADADAGGA");
		initializeMap(infosGames);
		PersonTravelManager.moveAdventurerOnMap(madreDeDios.getGameMap(), lara, Movement.A);
		Integer row = lara.getPosition().getRow();
		Integer column = lara.getPosition().getColumn();
		assertThat(column).isEqualTo(2);
		assertThat(row).isEqualTo(2);
		Treasure treasure =  (Treasure)madreDeDios.getGameMap()[2][2];
		assertThat(treasure.getNumberOfTreasure()).isEqualTo(2);
	}
	
	@Test
	void moveRotateToTheLeft() throws NumberFormatException, InitializationException {
		List<String> infosGames = List.of("# Carte", "C - 3 - 4", "T - 2 - 2 - 1", "A - Lara - 0 - 0 - E - AADADAGGA");
		initializeMap(infosGames);
		PersonTravelManager.moveAdventurerOnMap(madreDeDios.getGameMap(), lara, Movement.G);
		
		Orientation expectedOrientation = Orientation.NORD;
		
		assertThat(lara.getPosition().getColumn()).isZero();
		assertThat(lara.getPosition().getRow()).isZero();
		assertThat(lara.getOrientation()).isEqualTo(expectedOrientation);
	}
	
	@Test
	void moveRotateToTheRight() throws NumberFormatException, InitializationException {
		List<String> infosGames = List.of("# Carte", "C - 3 - 4", "A - Lara - 0 - 0 - E - AADADAGGA");
		initializeMap(infosGames);
		PersonTravelManager.moveAdventurerOnMap(madreDeDios.getGameMap(), lara, Movement.D);
		
		Orientation expectedOrientation = Orientation.SUD;
		
		assertThat(lara.getPosition().getColumn()).isZero();
		assertThat(lara.getPosition().getRow()).isZero();
		assertThat(lara.getOrientation()).isEqualTo(expectedOrientation);
	}
}
