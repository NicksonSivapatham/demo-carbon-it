package fr.carbonIT.demo.chasseAuTresors.game.map.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import fr.carbonIT.demo.chasseAuTresors.exception.InitializationException;
import fr.carbonIT.demo.chasseAuTresors.game.map.Cell;
import fr.carbonIT.demo.chasseAuTresors.game.map.element.Mountain;
import fr.carbonIT.demo.chasseAuTresors.game.map.service.impl.MadreDeDiosMap;
import fr.carbonIT.demo.chasseAuTresors.game.person.Adventurer;
import fr.carbonIT.demo.chasseAuTresors.game.person.Person;

 class MadreDeDiosTest {
	MadreDeDiosMap madreDeDios;
	
	@Test
	 void getMountain() throws NumberFormatException, InitializationException {
		List<String> infosGames = List.of("# Carte", "C - 3 - 4", "# Montagne", "M - 1 - 0", "T - 2 - 2 - 1", "A - Lara - 1 - 1 - S - AADADAGGA");
		madreDeDios = new MadreDeDiosMap(infosGames);
		madreDeDios.intitializeGameMap();
		Cell[][] gameMap = madreDeDios.getGameMap();
		Integer rows = gameMap.length;
		Integer columns = gameMap[0].length;
		assertThat(rows).isEqualByComparingTo(4);
		assertThat(columns).isEqualByComparingTo(3);
		assertThat(gameMap[0][1]).isInstanceOf(Mountain.class);
		Person person = gameMap[1][1].getPerson();
		assertThat(person).isInstanceOf(Adventurer.class);
	}
}
