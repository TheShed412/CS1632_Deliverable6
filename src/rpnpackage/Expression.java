package rpnpackage;

/**
 * This will represent an expression to be evaluated.
 * It will impleent the Command interface since a single line can
 * be entered as a command and it is used by Let and Print
*/

public class Expression implements Command {
	
	

	public int evaluate(SymbolTable st){

		return 0;
	}

	public String getCommand(){
		return command;
	}

}