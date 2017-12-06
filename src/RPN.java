import rpnpackage.*;

public class RPN {

	RPNReader reader;

	private RPN(String[] args) {
		if(args.length == 0) {

			reader = new RPNReplReader();
			String expression;
			int currentLine;
			Command cmd;
			SymbolTable st = new SymbolTable();
			
			while(true) {
				//get the expression and line number
				expression = reader.nextLine();
				currentLine = reader.getLineNumber();

				if(expression.equals(null)) {
					System.out.println("Line "+ currentLine + ": an error occured");
				} else {

					cmd = getCommand(expression);

				}

			}

		} else {
			reader = new RPNFileReader(args);
		}
	}


	private Command getCommand(String expression) {

		Command ret;

		try{
			if (expression.toLowerCase().contains("print")) {
				ret = new Print(expression);
			} else if (expression.toLowerCase().contains("let")) {
				ret = new Let(expression);
			} else if (expression.toLowerCase().contains("quit")) {
				ret = new Quit(expression);
			} else {
				ret = new Expression(expression);
			}
		} catch (Exception expressn) {
			System.err.println("something happened");
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
