package rpnpackage;


import java.util.*;
import java.math.BigInteger;
/**
 * This will represent an expression to be evaluated.
 * It will impleent the Command interface since a single line can
 * be entered as a command and it is used by Let and Print
*/

public class Expression implements Command {
	
	private String[] expression;
	private String command;

	public Expression(String[] expressionArr) throws Exception {

		System.arraycopy(expressionArr, 0, expression, 0, expressionArr.length);
		command = EXP;

		if (!checkValidExpression()) {
			throw new Exception("invalid tokens");
		}
	}


	public Expression(String expressionStr) throws Exception {

		expression = expressionStr.split("\\s+");
		command = EXP;

		if (!checkValidExpression()) {
			throw new Exception("invalid tokens");
		}
	}

	private boolean checkValidExpression(){

		for (String token : expression){
			if (token.length() != 1 && !isNumeric(token)) {
				return false;
			}//if

		}//for

		return true;
	}

	private boolean isNumeric(String s) {  

    	return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
	}  

	/**
	 * This evaluate will be where all of the solving will be done
	 * LET and PRINT will both call this to Solve it's own expressions
	 * 
	 * This will throw an exception when it runs in to a malformed expression
	*/

	public int evaluate(SymbolTable st) throws Exception {

		if (!checkValidExpression()) {
			throw new Exception("invalid tokens");
		}

		getValuesFromST(st); //moves values to expression
		// DO THE STACK STUFF

		return 0;
	}

	private void getValuesFromST(SymbolTable st) throws Exception {

		char temp;
		BigInteger tempInt;
		int i = 0;
		// I will replace every letter with it's value
		for (String token : expression) {

			temp = token.charAt(0);

			if (Character.isLetter(temp)) {

				tempInt = st.get(token);
				expression[i] = tempInt.toString();
			}

			i++;
		}

	}

	public String getCommand(){
		return command;
	}

}