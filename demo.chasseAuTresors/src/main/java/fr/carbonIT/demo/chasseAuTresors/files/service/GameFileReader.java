package fr.carbonIT.demo.chasseAuTresors.files.service;

import java.io.IOException;
import java.util.List;

public interface GameFileReader {
	public List<String> read() throws IOException;
}
