import rpnpackage.*;

import java.math.BigInteger;

public class RPN {

	RPNReader reader;
	boolean isFile = false;

	private RPN(String[] args) {
		if(args.length == 0) {

			reader = new RPNReplReader();

		} else {
			try{
			reader = new RPNFileReader(args);
			} catch(Exception e){
				System.err.println(e.getMessage());
				System.exit(5);
			}
			isFile = true;
		}

			String expression = "";
			int currentLine;
			Command cmd;
			SymbolTable st = new SymbolTable();
			BigInteger value;

			while(!(expression == null)) {
				//get the expression and line number
				expression = reader.nextLine();
				if(expression.equals("")) {
					continue;
				}

				currentLine = reader.getLineNumber();

					try{
						cmd = getCommand(expression);
					} catch (Exception e) {
						System.err.println("Line "+ currentLine + ": " + e.getMessage());

						shouldExit(e.getMessage(), isFile);

						continue;
					}

					// now I have the expression
					try{
						value = cmd.evaluate(st);
						if (!isFile || cmd.getCommand().equals(Command.PRINT))
							System.out.println(value.toString());
					} catch (Exception e) {
						System.err.println("Line "+ currentLine + ": " + e.getMessage());

						shouldExit(e.getMessage(), isFile);
					}


			}//while

	}

	private void shouldExit(String error, boolean isFile) {

		if (error.contains("unknown keyword") && isFile){
			System.exit(4);
		} else if (error.contains("elements in stack after evaluation") && isFile){
			System.exit(3);
		} else if (isFile){
			System.exit(5);
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

		return ret;
	}


	/**
	 * This will be the main driver file
	*/
	public static void main (String[] args){
		RPN program = new RPN(args);
	}
}
