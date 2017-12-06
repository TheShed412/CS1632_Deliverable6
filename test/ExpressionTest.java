import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.*;
import java.math.BigInteger;

import rpnpackage.*;

public class ExpressionTest {

	@Test
	public void evaluateSimpleTest() throws Exception {
		String rpnStr = "3 2 -";
		int expected = 1;

		Expression exp = new Expression(rpnStr);

		SymbolTable st = Mockito.mock(SymbolTable.class);

		BigInteger actualBI = exp.evaluate(st);

		int actual = getInt(actualBI);

		assertEquals(actual, expected);
	}

	@Test
	public void evaluateDoubleDigitTest() throws Exception {
		String rpnStr = "12 3 - 3 /";
		int expected = 3;

		Expression exp = new Expression(rpnStr);

		SymbolTable st = Mockito.mock(SymbolTable.class);

		BigInteger actualBI = exp.evaluate(st);

		int actual = getInt(actualBI);

		assertEquals(actual, expected);
	}

	@Test
	public void evaluateNegativeTest() throws Exception {
		String rpnStr = "-3";
		int expected = -3;

		Expression exp = new Expression(rpnStr);

		SymbolTable st = Mockito.mock(SymbolTable.class);

		BigInteger actualBI = exp.evaluate(st);

		int actual = getInt(actualBI);

		assertEquals(actual, expected);
	}

	@Test
	public void evaluateNegative2Test() throws Exception {
		String rpnStr = "-3 2 +";
		int expected = -1;

		Expression exp = new Expression(rpnStr);

		SymbolTable st = Mockito.mock(SymbolTable.class);

		BigInteger actualBI = exp.evaluate(st);

		int actual = getInt(actualBI);

		assertEquals(actual, expected);
	}

	@Test
	public void evaluateBigNumTest() throws Exception {
		String rpnStr = "9999999999999999999999999 " +
							"1234635373264729 +";
		String expected = "10000000001234635373264728";

		Expression exp = new Expression(rpnStr);

		SymbolTable st = Mockito.mock(SymbolTable.class);

		BigInteger actualBI = exp.evaluate(st);

		String actual = actualBI.toString();

		assertEquals(actual, expected);
	}

	@Test
	public void evaluateSmallNumTest() throws Exception {
		String rpnStr = "-9999999999999999999999999 " +
							"9999999999999999999999999 +";
		String expected = "0";

		Expression exp = new Expression(rpnStr);

		SymbolTable st = Mockito.mock(SymbolTable.class);

		BigInteger actualBI = exp.evaluate(st);

		String actual = actualBI.toString();

		assertEquals(actual, expected);
	}
	


	private int getInt(BigInteger bi) {
		String str = bi.toString();
		return Integer.parseInt(str);
	}

}