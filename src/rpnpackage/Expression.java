package rpnpackage;

/**
 * This will represent an expression to be evaluated.
 * It will impleent the Command interface since a single line can
 * be entered as a command and it is used by Let and Print
*/

public class Expression implements Command {
	
	private String[] expression;
	private String command;

	public Expression(String[] expressionArr) {

		System.arraycopy(expressionArr, 0, expression, 0, expressionArr.length);
		command = EXP;
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

			if (token.length() != 1) {
				return false;
			}//if

		}//for

		return true;
	}

	/**
	 * This evaluate will be where all of the solving will be done
	 * LET and PRINT will both call this to Solve it's own expressions
	 * 
	 * This will throw an exception when it runs in to a malformed expression
	*/

	public int evaluate(SymbolTable st) throws Exception {

		return 0;
	}

	public String getCommand(){
		return command;
	}

}