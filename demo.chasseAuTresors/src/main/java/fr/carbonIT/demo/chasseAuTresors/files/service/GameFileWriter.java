package fr.carbonIT.demo.chasseAuTresors.files.service;

import java.io.IOException;
import java.util.List;

public interface GameFileWriter {
	public void write(List<String> lignes) throws IOException;
}
