package fr.carbonIT.demo.chasseAuTresors;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.carbonIT.demo.chasseAuTresors.exception.InitializationException;
import fr.carbonIT.demo.chasseAuTresors.files.service.GameFileReader;
import fr.carbonIT.demo.chasseAuTresors.files.service.GameFileWriter;
import fr.carbonIT.demo.chasseAuTresors.files.service.impl.GameReaderFromTxt;
import fr.carbonIT.demo.chasseAuTresors.files.service.impl.GameWriterToTxt;
import fr.carbonIT.demo.chasseAuTresors.game.CarteAuTresorGame;
import fr.carbonIT.demo.chasseAuTresors.game.Game;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		String directory = "src/main/resources/";
		GameFileReader gameFileReader = new GameReaderFromTxt(directory + "MadreDeDios");
		GameFileWriter gameFileWriter = new GameWriterToTxt(directory + "Result");
		Game game = new CarteAuTresorGame(gameFileReader, gameFileWriter);
		game.launchGame();
	}

}
