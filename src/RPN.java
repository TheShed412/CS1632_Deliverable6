import rpnpackage.*;

import java.math.BigInteger;

public class RPN {

	RPNReader reader;

	private RPN(String[] args) {
		if(args.length == 0) {

			reader = new RPNReplReader();
			String expression;
			int currentLine;
			Command cmd;
			SymbolTable st = new SymbolTable();
			BigInteger value;
			
			while(true) {
				//get the expression and line number
				expression = reader.nextLine();
				currentLine = reader.getLineNumber();

				if(expression.equals(null)) {
					System.out.println("Line "+ currentLine + ": an error occured");
				} else {
					try{
						cmd = getCommand(expression);
					} catch (Exception e) {
						System.err.println("Line "+ currentLine + ": something happened");
						continue;
					}

					// now I have the expression
					try{ 
						value = cmd.evaluate(st);
						System.out.println(value.toString());
					} catch (Exception e) {
						System.err.println("Line "+ currentLine + ": something happened in eval");
					}

					

				}//else

			}//while

		} else {
			reader = new RPNFileReader(args);
		}
	}


	private Command getCommand(String expression) throws Exception {

		Command ret;

			if (expression.toLowerCase().contains("print")) {
				ret = new Print(expression);
			} else if (expression.toLowerCase().contains("let")) {
				ret = new Let(expression);
			} else if (expression.toLowerCase().contains("quit")) {
				ret = new Quit(expression);
			} else {
				ret = new Expression(expression);
			}

		ret = null;

		return ret;
	}


	/**
	 * This will be the main driver file
	*/
	public static void main (String[] args){
		RPN program = new RPN(args);
	}
}
