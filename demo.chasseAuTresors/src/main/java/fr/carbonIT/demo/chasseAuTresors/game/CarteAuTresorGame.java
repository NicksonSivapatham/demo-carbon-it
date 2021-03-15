package fr.carbonIT.demo.chasseAuTresors.game;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.carbonIT.demo.chasseAuTresors.exception.InitializationException;
import fr.carbonIT.demo.chasseAuTresors.files.service.GameFileReader;
import fr.carbonIT.demo.chasseAuTresors.files.service.GameFileWriter;
import fr.carbonIT.demo.chasseAuTresors.files.service.impl.MadreDeDiosRenderForFile;
import fr.carbonIT.demo.chasseAuTresors.game.map.service.impl.MadreDeDiosMap;

public class CarteAuTresorGame implements Game {
	
	Logger logger = LoggerFactory.getLogger(CarteAuTresorGame.class);
	
	GameFileReader gameFileReader;
	MadreDeDiosMap gameMap;
	GameMaster gameMaster;
	GameFileWriter gameFileWriter;
	
	public CarteAuTresorGame(GameFileReader gameFileReader, GameFileWriter gameFileWriter) {
		super();
		this.gameFileReader = gameFileReader;
		this.gameFileWriter = gameFileWriter;
	}

	@Override
	public void loadGame() throws InitializationException{
		try {
			List<String> infosGames = gameFileReader.read();
			gameMap = new MadreDeDiosMap(infosGames);
			gameMap.intitializeGameMap();
		} catch (IOException e) {
			throw new InitializationException("Error attempting reading file", e);
		} catch (NumberFormatException e) {
			throw new InitializationException("Error attempting parsing info. Please verify the input file's datas.", e);
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new InitializationException("Could not place element on the map. Please verify the input file's datas.", e);
		}
		
	}

	@Override
	public void playGame() {
		gameMaster = new ChasseAuTresorRules(gameMap);
		gameMaster.play();
	}

	@Override
	public void closeGame() {
		List<String> test = MadreDeDiosRenderForFile.renderMadreDeDios(gameMap);
		try {
			gameFileWriter.write(test);
		} catch (IOException e) {
			logger.error("Error while writing result in file", e);
		}
	}

}
