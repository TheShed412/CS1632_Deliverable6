package rpnpackage;

/**
 * 
 * This class will represent one of 3 commands:
 * 	PRINT
 * 	LET
 * 	QUIT
 * 
*/

public class Command {

	public static final String PRINT = "PRINT";
	public static final String QUIT = "QUIT";
	public static final String LET = "LET";

	private String command;
	private String[] equation;
	private char var;


}