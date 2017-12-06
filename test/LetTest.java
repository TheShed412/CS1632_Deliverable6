import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.*;
import java.math.BigInteger;

import rpnpackage.*;

/**
 * Tests for the et constructors
*/

public class LetTest {

	/**
	 * testing to see if an exception was thrown with a variable name that is too long
	*/
	@Test 
	public void constructorTooLongVarTest() {
		String exp = "let as 2";
		try{
			Let let = new Let(exp);
		} catch(Exception e) {
			return;
		}

		fail();
	}

	/**
	 * testing for a variable that isnt a letter
	*/

	@Test 
	public void constructorNoLetterTest() {
		String exp = "let 3 2";
		try{
			Let let = new Let(exp);
		} catch(Exception e) {
			return;
		}

		fail();
	}
}