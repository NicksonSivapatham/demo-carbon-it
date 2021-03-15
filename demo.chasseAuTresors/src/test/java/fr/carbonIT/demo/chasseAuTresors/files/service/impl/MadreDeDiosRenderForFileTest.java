package fr.carbonIT.demo.chasseAuTresors.files.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.carbonIT.demo.chasseAuTresors.exception.InitializationException;
import fr.carbonIT.demo.chasseAuTresors.game.map.Cell;
import fr.carbonIT.demo.chasseAuTresors.game.map.element.Mountain;
import fr.carbonIT.demo.chasseAuTresors.game.map.service.impl.MadreDeDiosMap;

 class MadreDeDiosRenderForFileTest {

	@Test
	 void renderMap() throws NumberFormatException, InitializationException {
	    List<String> infosGames = List.of("# Carte", "C - 3 - 4", "# Montagne", "M - 1 - 0", "T - 2 - 2 - 1", "A - Lara - 1 - 1 - S - AADADAGGA");
	    List<String> expectedLines = List.of("C - 3 - 4", "M - 1 - 0", "T - 2 - 2 - 1", "A - Lara - 1 - 1 - S - 0");
		MadreDeDiosMap madreDeDios = new MadreDeDiosMap(infosGames);
		madreDeDios.intitializeGameMap();
		List<String> result = MadreDeDiosRenderForFile.renderMadreDeDios(madreDeDios);
	    assertThat(expectedLines.get(0)).isEqualTo(result.get(0)); 
	    assertThat(expectedLines.get(1)).isEqualTo(result.get(1)); 
	    assertThat(expectedLines.get(2)).isEqualTo(result.get(2)); 
	    assertThat(expectedLines.get(3)).isEqualTo(result.get(3)); 
	}
}
