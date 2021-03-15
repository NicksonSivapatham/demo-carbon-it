package fr.carbonIT.demo.chasseAuTresors.files.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fr.carbonIT.demo.chasseAuTresors.files.service.impl.GameReaderFromTxt;

 class GameWriterToTxtTest {
	
	Logger logger = LoggerFactory.getLogger(GameWriterToTxtTest.class);
	
	private GameWriterToTxt gameWriterToTxt;

	@Test
	 void writeFile() throws IOException {
		String filePath = "src/test/resources/ResultTest.txt";
		gameWriterToTxt = new GameWriterToTxt(filePath);
	    List<String> dataToWrite = List.of("Ceci est un fichier de test", "Hello World!");  
	    gameWriterToTxt.write(dataToWrite);
	    Path path = Paths.get(filePath);
		List<String> result = Files.lines(path).collect(Collectors.toList());
	    assertThat(result.get(0)).isEqualTo(dataToWrite.get(0));  
	    assertThat(result.get(1)).isEqualTo(dataToWrite.get(1));
	}
}
