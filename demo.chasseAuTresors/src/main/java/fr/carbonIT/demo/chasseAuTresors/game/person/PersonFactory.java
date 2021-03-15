package fr.carbonIT.demo.chasseAuTresors.game.person;

import fr.carbonIT.demo.chasseAuTresors.game.type.Movement;
import static fr.carbonIT.demo.chasseAuTresors.utils.Separator.INFO_SEPARATOR;
import fr.carbonIT.demo.chasseAuTresors.game.type.Orientation;
import fr.carbonIT.demo.chasseAuTresors.game.type.Position2D;

public class PersonFactory {
	
	private PersonFactory() {
	    throw new IllegalStateException("Utility class");
	}
	
	/**
	 * Create a person based on the info of the line
	 * @param infoLine ex: A - Indiana - 3 - 2 - E - AADADA
	 * @return
	 */
	public static Person getPerson(String infoLine) {
		String[] infos = infoLine.split(INFO_SEPARATOR);
		Person person = null;
		String name;
		if ("A".equals(infos[0])) {
			name = infos[1];
			Integer y = Integer.valueOf(infos[2]);
			Integer x = Integer.valueOf(infos[3]);
			Orientation orientation = Orientation.fromString(infos[4]);
			String[] sequenceOfMovmentString = infos[5].split("");
			Movement[] sequenceOfMovement = new Movement[sequenceOfMovmentString.length];
			for (int i = 0; i < sequenceOfMovmentString.length; i++) {
				sequenceOfMovement[i] = Movement.valueOf(sequenceOfMovmentString[i]);
			}
			person = new Adventurer(name, new Position2D(x, y), orientation, sequenceOfMovement);			
		}
		return person;
	}
}
