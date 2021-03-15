package fr.carbonIT.demo.chasseAuTresors.files.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.carbonIT.demo.chasseAuTresors.files.service.GameFileReader;

public class GameReaderFromTxt implements GameFileReader{
	
	Logger logger = LoggerFactory.getLogger(GameReaderFromTxt.class);
	
	String filePath;
	
	public GameReaderFromTxt(String filePath) {
		super();
		this.filePath = filePath;
	}

	@Override
	public List<String> read() throws IOException{
		Path path = Paths.get(filePath);
		try (Stream<String> input = Files.lines(path))   {
			return input.collect(Collectors.toList());
		} catch (IOException e) {
			logger.error("Error during reading file at {}", path);
			throw e;
		}
	}
}