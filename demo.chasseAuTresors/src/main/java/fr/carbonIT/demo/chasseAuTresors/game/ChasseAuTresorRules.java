package fr.carbonIT.demo.chasseAuTresors.game;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.carbonIT.demo.chasseAuTresors.game.map.service.impl.MadreDeDiosMap;
import fr.carbonIT.demo.chasseAuTresors.game.person.Adventurer;
import fr.carbonIT.demo.chasseAuTresors.game.person.PersonTravelManager;
import fr.carbonIT.demo.chasseAuTresors.game.type.Movement;

public class ChasseAuTresorRules implements GameMaster {
	
	Logger logger = LoggerFactory.getLogger(ChasseAuTresorRules.class);

	MadreDeDiosMap madreDeDios;
	
	public ChasseAuTresorRules(MadreDeDiosMap madreDeDios) {
		super();
		this.madreDeDios = madreDeDios;
	}


	@Override
	public void play() {
		logger.info("The game is begining !");
		logger.info("Here is Madre de Mios");
		madreDeDios.renderMap();
		List<Adventurer> listOfAdventurer = madreDeDios.getListOfPersons()
														.stream()
														.filter(Adventurer.class::isInstance)
														.map(Adventurer.class::cast)
														.collect(Collectors.toList());
		Integer numberOfRoundForAdventurer = listOfAdventurer.stream()
																.map(Adventurer::getSequenceOfMouvement)
																.map(sequence -> sequence.length)
																.max(Integer::compare)
																.orElse(0);
		logger.info("We will have {} round.", numberOfRoundForAdventurer);
		for (int i = 0; i < numberOfRoundForAdventurer; i++) {
			logger.info("Round {}", i+1);
			for (Adventurer adventurer : listOfAdventurer) {
				if (i < adventurer.getSequenceOfMouvement().length) {
					Movement movement = adventurer.getSequenceOfMouvement()[i];
					PersonTravelManager.moveAdventurerOnMap(madreDeDios.getGameMap(), adventurer, movement);
				}
			}
			logger.info("Round {} done. Here is the result", i+1);
			madreDeDios.renderMap();
		}													
		
	}

}
