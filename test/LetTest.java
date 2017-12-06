import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.*;
import java.math.BigInteger;

import rpnpackage.*;

public class LetTest {
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