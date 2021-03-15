package fr.carbonIT.demo.chasseAuTresors.game.map;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.carbonIT.demo.chasseAuTresors.game.map.Cell;
import fr.carbonIT.demo.chasseAuTresors.game.map.CellFactory;
import fr.carbonIT.demo.chasseAuTresors.game.map.element.Mountain;
import fr.carbonIT.demo.chasseAuTresors.game.map.element.Plain;
import fr.carbonIT.demo.chasseAuTresors.game.map.element.Treasure;

 class CellFactoryTest {
	 
	
	@Test
	 void getMountain() {
		String infoLine = "M - 1 - 0";
		Cell cell = CellFactory.getCase(infoLine);
		assertThat(cell).isInstanceOf(Mountain.class);
		assertThat(cell.getPosition().getRow()).isEqualByComparingTo(0);
		assertThat(cell.getPosition().getColumn()).isEqualByComparingTo(1);
	}
	
	@Test
	 void getPlain() {
		String infoLine = "P - 0 - 2";
		Cell cell = CellFactory.getCase(infoLine);
		assertThat(cell).isInstanceOf(Plain.class);
		assertThat(cell.getPosition().getColumn()).isEqualByComparingTo(0);
		assertThat(cell.getPosition().getRow()).isEqualByComparingTo(2);
	}
	
	@Test
	 void getTreasure() {
		String infoLine = "T - 0 - 2 - 1";
		Cell cell = CellFactory.getCase(infoLine);
		assertThat(cell).isInstanceOf(Treasure.class);
		assertThat(cell.getPosition().getColumn()).isEqualByComparingTo(0);
		assertThat(cell.getPosition().getRow()).isEqualByComparingTo(2);
		Treasure treasure = (Treasure) cell;
		assertThat(treasure.getNumberOfTreasure()).isEqualByComparingTo(1);
	}
}
