import rpnpackage.*;

public class RPN {

	RPNReader reader;

	private RPN(String[] args) {
		if(args.length == 0) {
			RPNReader = new RPNReplReader();
		} else {
			RPNReader = new RPNFileReader(args);
		}
	}





	/**
	 * This will be the main driver file
	*/
	public static void main (String[] args){
		RPN program = new RPN(args);
	}
}
