package fr.carbonIT.demo.chasseAuTresors.game.map;

import fr.carbonIT.demo.chasseAuTresors.game.map.element.Mountain;
import fr.carbonIT.demo.chasseAuTresors.game.map.element.Plain;
import fr.carbonIT.demo.chasseAuTresors.game.map.element.Treasure;
import static fr.carbonIT.demo.chasseAuTresors.utils.Separator.INFO_SEPARATOR;

public class CellFactory {
	
	private CellFactory() {
	    throw new IllegalStateException("Utility class");
	}
	
	/**
	 * Create a case based on the info of the line
	 * @param infoLine ex: M - 1 - 0 or T - 0 - 3 - 2
	 * @return
	 */
	public static Cell getCase(String infoLine) throws NumberFormatException{
		String[] infos = infoLine.split(INFO_SEPARATOR);
		Cell cell = null;
		Integer row;
		Integer column;
		Integer numberOfTreasure;
		switch (infos[0]) {
			case "M":
				//TO_DO gerer exception
				row = Integer.valueOf(infos[2]);
				column = Integer.valueOf(infos[1]);
				cell = new Mountain(row, column);
				break;
			case "P":
				//TO_DO gerer exception
				row = Integer.valueOf(infos[2]);
				column = Integer.valueOf(infos[1]);
				cell = new Plain(row, column);
				break;
			case "T":
				//TO_DO gerer exception
				row = Integer.valueOf(infos[2]);
				column = Integer.valueOf(infos[1]);
				numberOfTreasure = Integer.valueOf(infos[3]);
				cell = new Treasure(row, column, numberOfTreasure);
				break;
			default:
				// TO DO exception
		}
		return cell;
	}
}
