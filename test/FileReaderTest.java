import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.*;
import java.math.BigInteger;

import rpnpackage.*;

public class FileReaderTest {

	/**
	 * testing a malformed extension is not used
	*/
	
	@Test
	public void constructorInvalidExtensionTest() {

		String[] args = {"thing.rpf"};

		try{
			RPNReader f = new RPNFileReader(args);
		} catch(Exception e) {
			return;
		}

		fail();
	}

	/**
	 * checking that a name must be included
	*/

	@Test
	public void constructorInvalidLengthTest() {

		String[] args = {".rpn"};

		try{
			RPNReader f = new RPNFileReader(args);
		} catch(Exception e) {
			return;
		}

		fail();
	}

	/**
	 * checking for names with whitespace
	*/
	@Test
	public void constructorInvalidWhiteSpaceTest() {

		String[] args = {" .rpn"};

		try{
			RPNReader f = new RPNFileReader(args);
		} catch(Exception e) {
			return;
		}

		fail();
	}

}