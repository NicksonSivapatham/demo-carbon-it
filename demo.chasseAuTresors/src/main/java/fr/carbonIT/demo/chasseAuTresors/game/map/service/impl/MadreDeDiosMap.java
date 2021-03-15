package fr.carbonIT.demo.chasseAuTresors.game.map.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.carbonIT.demo.chasseAuTresors.exception.InitializationException;
import fr.carbonIT.demo.chasseAuTresors.game.map.Cell;
import fr.carbonIT.demo.chasseAuTresors.game.map.CellFactory;
import fr.carbonIT.demo.chasseAuTresors.game.person.Person;
import fr.carbonIT.demo.chasseAuTresors.game.person.PersonFactory;

public class MadreDeDiosMap {
	
	public static final String INFO_SEPARATOR = " - ";
	Logger logger = LoggerFactory.getLogger(MadreDeDiosMap.class);
	
	private Cell[][] gameMap;
	private List<String> infosGame;
	private List<Person> listOfPersons;
	
	public MadreDeDiosMap(List<String> infosGame) {
		super();
		this.infosGame = infosGame;
	}

	public void setInfosGame(List<String> infosGame) {
		this.infosGame = infosGame;
	}
	
	public Cell[][] getGameMap() {
		return this.gameMap;
	}

	private void setGameMap(Cell[][] gameMap) {
		this.gameMap = gameMap;
	}

	public List<Person> getListOfPersons() {
		return listOfPersons;
	}

	public void setListOfPersons(List<Person> listOfPersons) {
		this.listOfPersons = listOfPersons;
	}

	public void intitializeGameMap() throws NumberFormatException, InitializationException {
		createGameMap();
		
		creationAndAffectEnvironment();
		
		createAndAffectPersons();		
		
	}

	/**
	 * Creation of Person and position it on the map
	 */
	private void createAndAffectPersons() throws NumberFormatException, ArrayIndexOutOfBoundsException{
		Predicate<String> lineIsInfoAdventurer = line -> line.startsWith("A");
		listOfPersons = infosGame.stream().filter(lineIsInfoAdventurer)
											.map(PersonFactory::getPerson)
											.collect(Collectors.toList());
		for (Person person : listOfPersons) {
			getGameMap()[person.getPosition().getRow()][person.getPosition().getColumn()].setPerson(person);
		}
	}

	/**
	 * Creation of environment (Mountains, Treasure, Plain...) and position it on the map
	 */
	private void creationAndAffectEnvironment() throws NumberFormatException, ArrayIndexOutOfBoundsException {
		Predicate<String> lineIsInfoMountain = line -> line.startsWith("M");
		Predicate<String> lineIsInfoTreasure = line -> line.startsWith("T");
		infosGame.stream().filter(lineIsInfoMountain.or(lineIsInfoTreasure))
							.map(CellFactory::getCase)
							.forEach(cell -> {
								Integer row = cell.getPosition().getRow();
								Integer column = cell.getPosition().getColumn();
								getGameMap()[row][column] = cell;
								});
		
		for (int row = 0; row < getGameMap().length; row ++) {
			for (int column = 0; column < getGameMap()[0].length; column ++) {
				if (getGameMap()[row][column] == null) {
					getGameMap()[row][column] = CellFactory.getCase("P" +  INFO_SEPARATOR + column + INFO_SEPARATOR + row);
				}
			}
		}
	}

	/**
	 * Creation of the gameMap
	 * @throws InitializationException 
	 */
	private void createGameMap() throws InitializationException, NumberFormatException {
		Predicate<String> lineIsInfoMap = line -> line.startsWith("C");
		Optional<String> infoMapOptional = infosGame.stream().filter(lineIsInfoMap)
																.findFirst();
		if (infoMapOptional.isPresent()) {
			String infoMap = infoMapOptional.get();
			String[] infos = infoMap.split(INFO_SEPARATOR);
			Integer rows = Integer.valueOf(infos[2]);
			Integer columns = Integer.valueOf(infos [1]);
			setGameMap(new Cell[rows][columns]);
		} else {
			throw new InitializationException("No infos regarding the map");
		}
	}
	
	public void renderMap() {
		for (int row = 0; row < getGameMap().length; row ++) {
			String lineToRender = Stream.of(getGameMap()[row])
										.map(Cell::renderCell)
										.collect(Collectors.joining("\t"));
			logger.info(lineToRender);
		}
	}

}
