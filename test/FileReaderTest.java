import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.*;
import java.math.BigInteger;

import rpnpackage.*;

public class FileReaderTest {
	
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