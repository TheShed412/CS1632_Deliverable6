package rpnpackage;

/**
 * This will represent the print command 
*/

public class Print implements Command {

	private String command;

	public int evaluate(SymbolTable st) {

		return 0;
	}

	public String getCommand() {
		return command;
	}

}