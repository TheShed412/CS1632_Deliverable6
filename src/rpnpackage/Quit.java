package rpnpackage;

import java.math.BigInteger;


public class Quit implements Command {

	private String command;
	private int exitType;

	public Quit(String quit, int exit){
		command = quit.toUpperCase();
		exitType = exit;
	}

	public BigInteger evaluate (SymbolTable st) throws Exception {
		System.exit(exitType);
		return null;
	}

	public String getCommand(){
		return command;
	}

}