package rpnpackage;

/**
 * This will represent the print command 
*/

public class Print implements Command {

	private String command;
	private Expression expression;

	public Print(String line) {
		command = PRINT;
		/**
		 * Split string in to array and get the expression
		*/
		String[] tempArr = line.split("\\s+");

		/**
		 * the expression will start at the second element
		 * in the array
		*/
		String[] expArr = Arrays.copyOfRange(tempArr, 2, tempArr.length-1);
		expression = new Expression(expArr);
	}

	public int evaluate(SymbolTable st) {

		return 0;
	}

	public String getCommand() {
		return command;
	}

}