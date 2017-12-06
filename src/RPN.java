import rpnpackage.*;

public class RPN {

	RPNReader reader;

	private RPN(String[] args) {
		if(args.length == 0) {
			reader = new RPNReplReader();
		} else {
			reader = new RPNFileReader(args);
		}

		boolean reading = true;
		while(reading) {
			String thisLine = reader.nextLine();

			if(thisLine == null) reading = false;
			else System.out.println(thisLine);
			System.out.println("Line Number: " + reader.getLineNumber());
		}
	}


	/**
	 * This will be the main driver file
	*/
	public static void main (String[] args){
		RPN program = new RPN(args);
	}
}
