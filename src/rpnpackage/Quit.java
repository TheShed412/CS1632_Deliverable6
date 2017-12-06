package rpnpackage;

import java.math.BigInteger;


public class Quit implements Command {

	private String command;
	private int exitType;

	public Quit(String quit){
		command = QUIT;
		exitType = 0;
	}

	public BigInteger evaluate (SymbolTable st) throws Exception {
		System.exit(exitType);
		return null;
	}

	public void setExitType(int e) {
		exitType = e;
	}

	public String getCommand(){
		return command;
	}

}