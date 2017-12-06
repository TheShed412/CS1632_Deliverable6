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
		
		expression = new String[expressionArr.length];
		System.arraycopy(expressionArr, 0, expression, 0, expressionArr.length);
		command = EXP;

		if (!checkValidExpression()) {
			throw new Exception("unknown keyword " + expression[0]);
		}
	}


	public Expression(String expressionStr) throws Exception {
		//I split all whitespace with regex
		expression = expressionStr.split("\\s+");
		command = EXP;

		if (!checkValidExpression()) {
			throw new Exception("unknown keyword " + expressionStr);
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

	public BigInteger evaluate(SymbolTable st) throws Exception {

		if (!checkValidExpression()) {
			throw new Exception("unknown keyword " + expression[0]);
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
				BigInteger tok1;
				BigInteger tok2;
				try {
					tok1 = rpnStack.pop();
					tok2 = rpnStack.pop();
				} catch (Exception e) {
					throw new Exception("operator "+ token +" applied to empty stack");
				}

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
					default:
						throw new Exception("unknown keyword" + token);

				}//switch
			}//else

		}//for

		if (rpnStack.size() > 1) {
			throw new Exception(rpnStack.size() + " elements in stack after eveluation");
		}

		if (rpnStack.size() < 1) {
			throw new Exception(" operator LET applied to empty stack");
		}

		//have to change eturn value to BigInt
		return rpnStack.pop();
	}

	private void getValuesFromST(SymbolTable st) throws Exception {

		char temp;
		BigInteger tempInt;
		int i = 0;
		// I will replace every letter with it's value
		for (String token : expression) {

			temp = token.charAt(0);

			if (Character.isLetter(temp)) {

				tempInt = st.get(token.toLowerCase());
				expression[i] = tempInt.toString();
			}

			i++;
		}

	}

	public String getCommand(){
		return command;
	}

}