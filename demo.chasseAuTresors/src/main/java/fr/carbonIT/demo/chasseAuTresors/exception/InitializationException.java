package fr.carbonIT.demo.chasseAuTresors.exception;

public class InitializationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InitializationException(String string, Exception e) {
		super(string, e);
	}

	public InitializationException(String string) {
		super(string);
	}

}
