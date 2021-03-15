package fr.carbonIT.demo.chasseAuTresors.game.map.element;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;


class TreasureTest {
	private Treasure treasure;

	@Test
	 void extractTreasureWhenExist2() {
		treasure = new Treasure(0, 0, 2);
		Boolean treasureExtracted = treasure.extractTreasure();
		assertThat(treasureExtracted).isTrue();
	    assertThat(treasure.getNumberOfTreasure()).isEqualTo(1);
	}
	
	@Test
	 void extractTreasureWhenExist0() {
		treasure = new Treasure(0, 0, 0);
		Boolean treasureExtracted = treasure.extractTreasure();
		assertThat(treasureExtracted).isFalse();
	    assertThat(treasure.getNumberOfTreasure()).isZero();
	}
}
