package fr.carbonIT.demo.chasseAuTresors.files.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.carbonIT.demo.chasseAuTresors.game.map.Cell;
import fr.carbonIT.demo.chasseAuTresors.game.map.element.Mountain;
import fr.carbonIT.demo.chasseAuTresors.game.map.element.Treasure;
import fr.carbonIT.demo.chasseAuTresors.game.map.service.impl.MadreDeDiosMap;
import fr.carbonIT.demo.chasseAuTresors.game.person.Adventurer;
import fr.carbonIT.demo.chasseAuTresors.game.person.Person;
import static fr.carbonIT.demo.chasseAuTresors.utils.Separator.INFO_SEPARATOR;

public class MadreDeDiosRenderForFile {

	private MadreDeDiosRenderForFile() {
	    throw new IllegalStateException("Utility class");
	}
	
	private static String renderMap(Cell[][] gameMap) {
		return "C" + INFO_SEPARATOR + gameMap[0].length + INFO_SEPARATOR + gameMap.length;	
	}
	
	private static String renderMountain(Mountain mountain) {
		return "M" + INFO_SEPARATOR + mountain.getPosition().getColumn() + INFO_SEPARATOR
				+ mountain.getPosition().getRow();	
	}
	
	private static String renderTreasure(Treasure treasure) {
		return "T" + INFO_SEPARATOR + treasure.getPosition().getColumn() + INFO_SEPARATOR
				+ treasure.getPosition().getRow() + INFO_SEPARATOR + treasure.getNumberOfTreasure();	
	}
	
	private static String renderAdventurer(Adventurer adventurer) {
		return "A" + INFO_SEPARATOR + adventurer.getName() + INFO_SEPARATOR + 
				adventurer.getPosition().getColumn() + INFO_SEPARATOR + 
				adventurer.getPosition().getRow() + INFO_SEPARATOR + 
				adventurer.getOrientation().getDirection() + INFO_SEPARATOR + 
				adventurer.getNumberOfTreasure();	
	}
	
	public static List<String> renderMadreDeDios(MadreDeDiosMap madreDeDios) {
		List<String> resultLines = new ArrayList<>();
		// Map render
		resultLines.add(renderMap(madreDeDios.getGameMap()));
		
		// Mountain render
		Arrays.stream(madreDeDios.getGameMap())
				.flatMap(Arrays::stream)
				.filter(cell -> cell instanceof Mountain)
				.map(Mountain.class::cast)
				.map(MadreDeDiosRenderForFile::renderMountain)
				.forEach(resultLines::add);
		
		// Treasure render
		Arrays.stream(madreDeDios.getGameMap())
				.flatMap(Arrays::stream)
				.filter(cell -> cell instanceof Treasure)
				.map(Treasure.class::cast)
				.map(MadreDeDiosRenderForFile::renderTreasure)
				.forEach(resultLines::add);
		
		// Adventurer render
		madreDeDios.getListOfPersons().stream()
										.filter(person -> person instanceof Person)
										.map(Adventurer.class::cast)
										.map(MadreDeDiosRenderForFile::renderAdventurer)
										.forEach(resultLines::add);
		return resultLines;
	}
}
