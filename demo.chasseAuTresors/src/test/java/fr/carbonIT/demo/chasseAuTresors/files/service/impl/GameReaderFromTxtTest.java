package fr.carbonIT.demo.chasseAuTresors.files.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

 class GameReaderFromTxtTest {
	
	Logger logger = LoggerFactory.getLogger(GameReaderFromTxtTest.class);
	
	private GameReaderFromTxt gameReaderFromTxt;

	@Test
	 void readFile() {
	    List<String> expectedData = List.of("Ceci est un fichier de test", "Hello World!");  
	    List<String> lines = null;
	    String filePath = "src/test/resources/TestFile";
	    gameReaderFromTxt = new GameReaderFromTxt(filePath);
		try {
			lines = gameReaderFromTxt.read();
		} catch (IOException e) {
			logger.error("Erreur lors de la lecture du fichier test", e);
		}
	    assertThat(expectedData).isEqualTo(lines);     
	}
	
	@Test
	 void readFileThrowsIOException() {
	    String filePath = "src/test/resources/TestFile2";
	    gameReaderFromTxt = new GameReaderFromTxt(filePath);
	    Assertions.assertThrows(IOException.class, () -> {
	    	gameReaderFromTxt.read();
		});
	}
}
