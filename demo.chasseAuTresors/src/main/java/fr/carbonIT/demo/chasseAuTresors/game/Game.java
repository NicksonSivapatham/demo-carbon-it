package fr.carbonIT.demo.chasseAuTresors.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.carbonIT.demo.chasseAuTresors.exception.InitializationException;

public interface Game {
	public Logger logger = LoggerFactory.getLogger(Game.class);
	
	public abstract void loadGame() throws InitializationException;
	public abstract void playGame();
	public abstract void closeGame();

	public default void launchGame(){
		try {
			loadGame();
			playGame();
			closeGame();
		} catch (InitializationException e) {
			logger.error("Failed to launch the game.");
		}
		
	}
}
