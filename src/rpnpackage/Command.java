package rpnpackage;

/**
 * 
 * This interface will represent one of 3 commands:
 * 	PRINT
 * 	LET
 * 	QUIT
 * 
*/

public interface Command {

	public static final String PRINT = "PRINT";
	public static final String QUIT = "QUIT";
	public static final String LET = "LET";

	public int evaluate(SymbolTable st);

}