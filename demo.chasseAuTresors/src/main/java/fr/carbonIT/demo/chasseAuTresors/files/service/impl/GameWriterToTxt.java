package fr.carbonIT.demo.chasseAuTresors.files.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.carbonIT.demo.chasseAuTresors.files.service.GameFileWriter;

public class GameWriterToTxt implements GameFileWriter{
	
	Logger logger = LoggerFactory.getLogger(GameWriterToTxt.class);

	String filePath;
	
	public GameWriterToTxt(String filePath) {
		super();
		this.filePath = filePath;
	}
	
	@Override
	public void write(List<String> lines) throws IOException {
		File file =  new File(filePath);
		
		try (Writer writer = new FileWriter(file)) {
			for (String line : lines) {
				writer.write(line);
				writer.write("\n");
			}
		} catch (IOException e) {
			logger.error("Error during writing file at {}", filePath);
			throw e;
		}
	}

}
