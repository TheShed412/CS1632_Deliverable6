package rpnpackage;


import java.util.*;
import java.math.BigInteger;
/**
 * This will represent an expression to be evaluated.
 * It will impleent the Command interface since a single line can
 * be entered as a command and it is used by Let and Print
*/

public class Expression implements Command {

	private final String OPS = "+-*/";
	
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

		Stack<BigInteger> rpnStack = new Stack<>();

		for(String token : expression) {

			// if the token is a number, push to the stack
			if(!OPS.contains(token)) {
				rpnStack.push(new BigInteger(token));
			} else {
				// if it's an operator, we operate on the last 2 values
				BigInteger tok1 = rpnStack.pop();
				BigInteger tok2 = rpnStack.pop();

				switch(token) {
					case "+":
						rpnStack.push(tok2.add(tok1));
						break;
					case "-":
						rpnStack.push(tok2.subtract(tok1));
						break;
					case "*":
						rpnStack.push(tok2.multiply(tok1));
						break;
					case "/":
						rpnStack.push(tok2.divide(tok1));
						break;

				}//switch
			}//else

		}//for

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