package rpnpackage;

import  java.util.Arrays;
import java.math.BigInteger;

/**
 * This will represent a LET command 
*/

public class Let implements Command {

	private String command;
	private Expression expression;
	private String var; 

	public Let(String line) throws Exception {
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
		}

		char tempChar = tempVar.charAt(0);
		if (Character.isLetter(tempChar)) {
			var = tempVar;
		} else {
			throw new Exception("no variable to assign value");
		}

		/**
		 * Now I make the expression
		*/
		String[] expArr = Arrays.copyOfRange(tempArr, 2, tempArr.length-1);
		expression = new Expression(expArr);
	}

	/**
	 * This will take the symbol table and add the variable (key) to it
	 * Since everything after the first variable is an expression, it will 
	 * be where we calculate the final value
	*/
	public BigInteger evaluate(SymbolTable st) throws Exception {

		BigInteger value = expression.evaluate(st);
		st.put(var, value);

		return value;
	}

	public String getCommand() {
		return command;
	} 

}