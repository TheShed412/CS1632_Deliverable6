package rpnpackage;

import  java.util.Arrays;
import java.math.BigInteger;
/**
 * This will represent the print command 
*/

public class Print implements Command {

	private String command;
	private Expression expression;

	public Print(String line) throws Exception {
		command = PRINT;
		/**
		 * Split string in to array and get the expression
		*/
		String[] tempArr = line.split("\\s+");

		/**
		 * the expression will start at the second element
		 * in the array
		*/
		String[] expArr = Arrays.copyOfRange(tempArr, 1, tempArr.length);
		expression = new Expression(expArr);
	}

	public BigInteger evaluate(SymbolTable st) throws Exception {

		BigInteger value = expression.evaluate(st);

		return value;
	}

	public String getCommand() {
		return command;
	}

}