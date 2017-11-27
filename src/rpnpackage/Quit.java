package rpnpackage;

public class Quit implements Command {

	private String command;
	private int exitType;

	public Quit(String quit, int exit){
		command = quit.toUpperCase();
		exitType = exit;
	}

	public int evaluate (SymbolTable st) throws Exception {
		System.exit(exitType);
		return exitType;
	}

	public String getCommand(){
		return command;
	}

}