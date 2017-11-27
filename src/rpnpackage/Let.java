package rpnpackage;

/**
 * This will represent a LET command 
*/

public class Let implements Command {

	private String command;
	private Expression expression;
	private char var; 

	public Let(String line) {
		command = LET;

		/**
		 * I'll split the line on whitespace and
		 * check to make sure the length is 1
		 * then check if it's a letter
		*/
		String[] tempArr = line.split("\\s+");
		String tempVar = tempArr[1];

		if (tempVar.length() != 1) {
			throw new Exception("variable name too long");
			return;
		}

		char tempChar = tempVar.charAt(0);
		if (Character.isLetter(tempChar)) {
			var = tempChar;
		} else {
			throw new Exception("no variable to assign value");
			return;
		}

		/**
		 * Now I make the expression
		*/
		String[] expArr = Arrays.copyOfRange(tempArr, 2, tempArr.length-1);
		expression = new Expression(expArr);
	}

	public int evaluate() throws Exception {
		return 0;
	}

	public getCommand() {
		return command;
	} 

}